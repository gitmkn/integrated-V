package cn.makn.validate.service;

import cn.makn.validate.V;
import org.springframework.util.ObjectUtils;

import javax.validation.ValidationException;
import java.lang.reflect.Field;

public class VHandler implements cn.makn.validate.Handler {

    /**
     * 检查处理接口
     *
     * @param v     V校验
     * @param field 字段
     * @param value 字段值
     */
    public void validate(V v, Field field, Object value) throws ValidationException {
        // 字段名称
        String fieldName = field.getName();
        // 判断是否必须输入
        notNull(v, field, value, fieldName);
        // 判断是否为空
        notEmpty(v, field, value, fieldName);
    }

    /**
     * 是否必须输入,默认false
     *
     * @return true, false
     */
    private void notNull(V v, Field field, Object value, String fieldName) throws ValidationException {
        if (v.notNull()) {
            if (ObjectUtils.isEmpty(value)) {
                System.out.println(fieldName + "是必输字段:");
                throw new ValidationException(fieldName + "是必输字段:");
            } else {
                System.out.println(fieldName + "值为:" + value);
            }
        }
    }

    /**
     * 是否为空,用于String类型和LIST类型检查,默认true
     *
     * @return true, false
     */
    private void notEmpty(V v, Field field, Object value, String fieldName) {

    }
}
