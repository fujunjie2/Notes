package com.lambda;



public class User {


    private Integer id;

    private Integer age;

    private String userName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User(Integer id, Integer age, String userName) {
        this.id = id;
        this.age = age;
        this.userName = userName;
    }
}
