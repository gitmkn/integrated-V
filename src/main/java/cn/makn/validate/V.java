package cn.makn.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version V1.0
 * @description
 * @Auther: makn
 * @Date: Created by 2020/10/30 15:46
 */

/**
 * @Retention(RetentionPolicy.SOURCE)
 * Retention注解决定类注解的生命周期
 * 这个注解的意思是让MyAnnotation注解只在java源文件中存在，编译成.class文件后注解就不存在了
 * @Retention(RetentionPolicy.CLASS)
 * 这个注解的意思是编译成.class文件后注解也还存在，
 * 被注解类标识的类被类加载器加载到内存中后注解就不存在了
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface V {

    /**
     * 字段说明
     * @return
     */
    String desc() default "";

    /**
     * 是否必须输入,默认false
     * @return true,false
     */
    boolean notNull() default false;

    /**
     * 最小整数，默认 Integer.MIN_VALUE
     * @return int
     */
    int min() default Integer.MIN_VALUE;

    /**
     * 最大整数，默认 Integer.MAX_VALUE
     * @return int
     */
    int max() default Integer.MAX_VALUE;

    /**
     * 用于检查STRING是否全部为数字,默认false
     * @return
     */
    boolean digit() default false;


}
