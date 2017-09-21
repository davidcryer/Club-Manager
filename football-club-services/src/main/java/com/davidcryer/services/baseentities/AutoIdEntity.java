package com.davidcryer.services.baseentities;

import javax.persistence.*;

@MappedSuperclass
public abstract class AutoIdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
