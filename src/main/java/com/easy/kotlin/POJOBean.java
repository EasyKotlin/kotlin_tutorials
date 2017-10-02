package com.easy.kotlin;

public class POJOBean {
}

class PersonJava {
    Integer id;
    String name;

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

    public PersonJava(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
