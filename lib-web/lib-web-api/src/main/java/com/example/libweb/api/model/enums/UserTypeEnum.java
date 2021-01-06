package com.example.libweb.api.model.enums;


/**
 * @author kangwei
 */

public enum    UserTypeEnum {
    /**
     * 学生枚举值
     */
    STUDENT(1,"学生"),
    /**
     * 教师枚举值
     */
            TEACHER(2,"教师"),
    /**
     * 图书管理员枚举值
     */
            LIBADMIN(3,"图书管理员"),
    /**
     * 系统管理员枚举值
     */
            SYSADMIN(4,"系统管理员");

    private Integer num;
    private String name;



    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    UserTypeEnum(Integer num, String name) {
        this.num = num;
        this.name = name;
    }
}
