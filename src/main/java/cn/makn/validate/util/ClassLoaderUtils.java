package cn.makn.validate.util;

import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version V1.0
 * @description Class 和 Resource 工具类
 * @Auther: makn
 * @Date: Created by 2020/10/30 18:10
 */
public class ClassLoaderUtils {
    private static final Map<String, Class<?>> classCache = new ConcurrentHashMap<String, Class<?>>();

    /**
     * 加载java类
     * 使用全限定类名
     * @param className
     * @return
     * @throws ClassNotFoundException
     */
    public static Class<?> loadClass(String className) throws ClassNotFoundException {
        Class<?> clazz = null;
        if (classCache.containsKey(className)) {
            return classCache.get(className);
        }
        clazz = ClassUtils.forName(className, getClassLoader());
        if (null != clazz) {
            classCache.put(className, clazz);
        }

        return clazz;
    }

    /**
     * 得到加载器
     * @return
     */
    public static ClassLoader getClassLoader(){
        return ClassLoaderUtils.class.getClassLoader();
    }

    /**
     * 根据属性名称在对象中获取属性值
     *
     * @param obj
     * @param fieldName
     * @return
     */
    public static Object getField(Object obj, String fieldName) {
        return getObject(obj, fieldName);
    }

    private static Object getObject(Object obj, String fieldName) {
        Object value = null;
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = obj.getClass().getMethod(getter);
            value = method.invoke(obj);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return value;
    }
}
