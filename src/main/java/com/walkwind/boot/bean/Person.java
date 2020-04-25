package com.walkwind.boot.bean;

/**
 * @Author walkwind
 * @Description
 * @Date 2020-4-25-17:32
 **/
public class Person {
    private String name;
    private Integer age;
    private Boolean boss;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Person(String name, Integer age, Boolean boss) {
        this.name = name;
        this.age = age;
        this.boss = boss;
    }
}
