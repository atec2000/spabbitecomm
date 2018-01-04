package com.spabbitecomm.common.model;

import java.io.Serializable;

public class Model implements Serializable {

    private static final long serialVersionUID = 3358011408416008394L;

    private String id;

    public Model() {
    }

    public Model(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
