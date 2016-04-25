package com.stpan.chitchat.entity;

import java.io.Serializable;

/**
 * 功能：
 * 创建时间:2016/3/15 : 11:27
 * 作者:pst
 */
public class Student implements Serializable {
    private String id;
    private String name;
    private String gender;

    public Student() {
    }

    public Student(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
