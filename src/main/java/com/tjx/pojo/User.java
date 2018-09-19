package com.tjx.pojo;

import javax.validation.constraints.*;

public class User {
    @NotNull(message = "ID不能为空！")
    @Min(value = 0,message = "ID不能小于{value}")
    @Max(value = 999,message = "ID不能大于{value}")
    private Integer id;
    @NotNull(message = "用户姓名不能为空！")
    @Size(min = 4,max = 6,message = "用户姓名长度不能小于{min}大于{max}")
    private String name;
    @NotNull(message = "性别不能为空！")
    private String sex;
    @NotNull(message = "邮箱不能为空！")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$",message = "邮箱格式不规范")
    private String email;

    public User() {
    }

    public User(Integer id, String name, String sex, String email) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
