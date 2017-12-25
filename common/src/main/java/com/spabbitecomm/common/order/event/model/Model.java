package com.spabbitecomm.common.order.event.model;

import java.io.Serializable;

/**
 * Created by jack on 12/25/17.
 */
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
