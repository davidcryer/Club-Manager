package com.davidcryer.services.baseentities;

import javax.persistence.*;

@MappedSuperclass
public abstract class GeneratedIdEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
