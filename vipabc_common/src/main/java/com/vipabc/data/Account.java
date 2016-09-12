package com.vipabc.data;

import java.io.Serializable;

/**
 * Created by andrew on 2016/8/12 0012.
 */
public class Account implements Serializable{
    private String name;
    private String pass = "vipabc";

    @Override
    public String toString() {
        return name;
    }

    public Account(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public Account(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public void setPass(String pass) {

        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
