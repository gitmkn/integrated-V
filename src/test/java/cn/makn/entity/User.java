package cn.makn.entity;


import cn.makn.validate.V;

import java.util.List;

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

    @V(desc = "我的小汽车", notNull = true)
    private List<car> carList;

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

    public List<car> getCarList() {
        return carList;
    }

    public void setCarList(List<car> carList) {
        this.carList = carList;
    }

    public static class car{
        @V(desc = "汽车颜色", notNull = true)
        private String color;
        @V(desc = "汽车长度", notNull = true, min = 1,max = 10)
        private int length;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        @Override
        public String toString() {
            return "car{" +
                    "color='" + color + '\'' +
                    ", length='" + length + '\'' +
                    '}';
        }
    }
}
