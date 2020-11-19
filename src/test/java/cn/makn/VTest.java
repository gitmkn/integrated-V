package cn.makn;


import cn.makn.entity.User;
import cn.makn.validate.V;
import cn.makn.validate.util.ClassLoaderUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class VTest {
    private static final Logger log = LoggerFactory.getLogger(VTest.class);

    @Test
    public void Test(){
        User user = new User();
//        user.setUser("111");
        ClassLoaderUtils classLoaderUtils = new ClassLoaderUtils();
//        Class<?> clzz = classLoaderUtils.loadClass("user");

        Object obj = user;
        Method[] methods =  obj.getClass().getMethods();

        for(Field field : obj.getClass().getDeclaredFields()){
            V v = field.getAnnotation(V.class);
            System.out.println( v.desc() + "-:" + field.getName());
            System.out.println( v.desc() + "-描述:" + v.desc());
            System.out.println( v.desc() + "-是否空:" + v.notNull());
        }
    }
}
