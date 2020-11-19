package cn.makn.validate.service;

import cn.makn.validate.V;
import cn.makn.validate.Validator;
import cn.makn.validate.util.ClassLoaderUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ValidatorHandler implements Validator {
    private static final Logger log = LoggerFactory.getLogger(ValidatorHandler.class);

    private static V emptyPlaceHolder;

    private static ValidatorHandler validatorHandler;

    private static Map<String, V> vMap = new ConcurrentHashMap<String, V>();

    private Handler handler = new VHandler();

    static {
        try {
            Field field = ValidatorHandler.class.getDeclaredField("emptyPlaceHolder");
            V empty = field.getAnnotation(V.class);
            emptyPlaceHolder = empty;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    // 单例模式，校验类
    public static ValidatorHandler getInstance() {
        if (validatorHandler == null) {
            synchronized (ValidatorHandler.class) {
                if (validatorHandler == null) {
                    validatorHandler = new ValidatorHandler();
                }
            }
        }
        return validatorHandler;
    }

    /**
     * 字段校验入口方法
     * @param obj 对象
     */
    @Override
    public void validator(Object obj) {
        validator(obj, "");
    }

    /**
     * 字段处理
     * @param obj 对象
     */
    private void validator(Object obj, String path) {
        if (null == obj) {
            if (log.isWarnEnabled()) {
                log.warn("validator 校验对象为空");
            }
        }
        // 字段位置
        if(ObjectUtils.isEmpty(path)){
            path = obj.getClass().getSimpleName() + ".";
        }
        // 获取对象
        Class<?> clazz = obj.getClass();
        // 字段集合
        Set<String> fieldNames = new HashSet<String>();
        while (clazz != null) {
            // 获取字段对象
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                // 字段名称
                String fieldName = field.getName();

                // 防止父类同属性被校验
                if (fieldNames.contains(fieldName)) {
                    continue;
                } else {
                    fieldNames.add(fieldName);
                }


                V v = null;
                if (!ObjectUtils.isEmpty(fieldName) && !vMap.containsKey(fieldName)) {
                    v = field.getAnnotation(V.class);
                    if (v == null) {
                        v = emptyPlaceHolder;
                    }
                    if (v != null) {
                        vMap.put(fieldName, v);
                    }
                }

                v = vMap.get(fieldName);
                if (v == emptyPlaceHolder) {
                    continue;
                }

                // 获取当前属性值
                Object value = ClassLoaderUtils.getField(obj, fieldName);

                // 根据属性校验值是否正确
                if(value instanceof List){
                    handler.validate(v, field, value, path);
                    // 数组内部校验处理
                    int i = 0;
                    for(Object array : ((List<?>)value).toArray()){
                        validator(array, path + fieldName + "[" + i + "].");
                        i++;
                    }
                }else{
                    handler.validate(v, field, value, path);
                }

            }

            // 获取该对象的父类，并对父类的属性进行校验
            Class<?> superClass =clazz.getSuperclass();
            if (Object.class == superClass) {
                clazz = null;
                vMap.clear();
            }else{
                clazz = superClass;
            }
        }
    }
}
