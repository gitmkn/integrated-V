package cn.makn.validate.service;

import cn.makn.validate.V;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import javax.validation.ValidationException;
import java.lang.reflect.Field;

public class VHandler implements Handler {
    private static final Logger logger = LoggerFactory.getLogger(VHandler.class);

    /**
     * 检查处理接口
     *
     * @param v     V校验
     * @param field 字段
     * @param value 字段值
     */
    @Override
    public void validate(V v, Field field, Object value, String path) {
        // 字段名称
        String fieldName = field.getName();
        // 判断是否必须输入
        checkNotNull(v, field, value, fieldName, path);
        // 判断是否为空
        checkSize(v, field, value, fieldName, path);
    }

    /**
     * 是否必须输入,默认false
     *
     * @return true, false
     */
    private void checkNotNull(V v, Field field, Object value, String fieldName, String path) {
        if (v.notNull()) {
            if (ObjectUtils.isEmpty(value)) {
                if (logger.isWarnEnabled()) {
                    logger.warn(fieldName + "是必输字段:");
                }
                throw new ValidationException(path + fieldName + "是必输字段:");
            } else {
                if (logger.isWarnEnabled()) {
                    logger.warn(fieldName + "值为:{}", value.toString());
                }
            }
        }
    }

    /**
     * 是否为空,用于String类型和LIST类型检查,默认true
     *
     * @return true, false
     */
    private void checkSize(V v, Field field, Object value, String fieldName, String path) {
        if (value instanceof Integer) {

        }
    }
}
