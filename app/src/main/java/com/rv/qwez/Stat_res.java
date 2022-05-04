package com.rv.qwez;

public class Stat_res {

    private String name;
    private String result;
    private String id;

    public Stat_res(String name, String result, String id) {
        this.name = name;
        this.result = result;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
