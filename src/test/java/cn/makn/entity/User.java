package cn.makn.entity;


import cn.makn.validate.V;

/**
 * @version V1.0
 * @description
 * @Auther: makn
 * @Date: Created by 2020/10/30 16:10
 */
public class User {

    @V(desc = "用户名", notNull = true)
    private String user;

    @V(desc = "用户密码")
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
