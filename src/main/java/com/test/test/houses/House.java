package com.test.test.houses;

import jakarta.persistence.*;

@Entity
@Table(name = "house")
public class House {
    @Id
    private Long id;
    private String address;
    private Long owner;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long ownerId) {
        this.owner = ownerId;
    }
}
