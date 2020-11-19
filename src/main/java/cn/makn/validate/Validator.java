package cn.makn.validate;

public interface Validator {

    /**
     * 字段校验入口方法
     * @param obj 对象
     */
    void validator(Object obj);
}
