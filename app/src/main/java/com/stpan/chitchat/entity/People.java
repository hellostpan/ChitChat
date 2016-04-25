package com.stpan.chitchat.entity;

import java.io.Serializable;

/**
 * 功能：
 * 创建时间:2016/3/15 : 11:28
 * 作者:pst
 */
public class People implements Serializable {
    private String id;
    private String type;
    private String status;

    public People() {
    }

    public People(String id, String type, String status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
