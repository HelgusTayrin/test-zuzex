package com.test.test.lodgers;

import jakarta.persistence.*;

@Entity
@Table(name = "lodger")
public class Lodger {
    @Id
    private Long lodgerId;
    private Long userId;
    private Long houseId;

    public Long getLodgerId() {
        return lodgerId;
    }

    public void setLodgerId(Long lodgerId) {
        this.lodgerId = lodgerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }
}
