package org.yevhen.dao;

import org.yevhen.dao.util.DataTransferObject;

public class Customer implements DataTransferObject {
    private long id;
    private String name;

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long getId() {
        return 0;
    }
}
