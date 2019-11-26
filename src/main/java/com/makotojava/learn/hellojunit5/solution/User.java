package com.makotojava.learn.hellojunit5.solution;

import lombok.ToString;

/**
 * @author BirdSnail
 * @date 2019/11/25
 */
@ToString
public class User {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**五年以后的年纪*/
    public int getFiveYearAge() {
        if (age < 0) {
            throw new IllegalArgumentException("年纪不能小于0");
        }
        return age + 5;
    }
}
