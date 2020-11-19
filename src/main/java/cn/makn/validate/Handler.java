package cn.makn.validate;

import java.lang.reflect.Field;

public interface Handler {

    /**
     * 检查处理接口
     * @param v V校验
     * @param field 字段
     * @param value 字段值
     */
    void validate(V v, Field field, Object value);
}
