package com.vipabc.data;

import java.io.Serializable;

/**
 * Created by andrew on 2016/8/12 0012.
 */
public class NetWork implements Serializable{
    private String host;
    private String path;

    @Override
    public String toString() {
        return "NetWork{" +
                "host='" + host + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

    public NetWork(String host, String path) {
        this.host = host;
        this.path = path;
    }

    public String getHost() {

        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
