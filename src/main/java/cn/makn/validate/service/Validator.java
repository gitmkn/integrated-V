package cn.makn.validate.service;

import cn.makn.validate.V;
import cn.makn.validate.util.ClassLoaderUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Validator {
    private static final Logger log = LoggerFactory.getLogger(Validator.class);

    private static V emptyPlaceHolder;

    private static Validator validator;

    private static Map<String, V> vMap = new ConcurrentHashMap<String, V>();

    private cn.makn.validate.Handler handler = new VHandler();

    static {
        try {
            Field field = Validator.class.getDeclaredField("emptyPlaceHolder");
            V empty = field.getAnnotation(V.class);
            emptyPlaceHolder = empty;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static Validator getInstance() {
        if (validator == null) {
            synchronized (Validator.class) {
                if (validator == null) {
                    validator = new Validator();
                }
            }
        }
        return validator;
    }

    public void validator(Object obj) {
        if (null == obj) {
            if (log.isWarnEnabled()) {
                log.warn("validator 校验对象为空");
            }
        }
        Class<?> clazz = validator.getClass();
        // 字段集合
        Set<String> fieldNames = new HashSet<String>();
//        while (clazz != null){
        for (Field field : obj.getClass().getDeclaredFields()) {
            // 字段名称
            String fieldName = field.getName();
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
            handler.validate(v, field, value);
        }
//        }
    }
}
