package com.zking.ssm.model;

import lombok.Data;

@Data
public class OrderItem {
    private Long oItemId;

    private Long oItemOid;

    private Long oItemPid;

    private Integer quantity;

    public OrderItem(Long oItemId, Long oItemOid, Long oItemPid, Integer quantity) {
        this.oItemId = oItemId;
        this.oItemOid = oItemOid;
        this.oItemPid = oItemPid;
        this.quantity = quantity;
    }

    public OrderItem() {
        super();
    }

    public Long getoItemId() {
        return oItemId;
    }

    public void setoItemId(Long oItemId) {
        this.oItemId = oItemId;
    }

    public Long getoItemOid() {
        return oItemOid;
    }

    public void setoItemOid(Long oItemOid) {
        this.oItemOid = oItemOid;
    }

    public Long getoItemPid() {
        return oItemPid;
    }

    public void setoItemPid(Long oItemPid) {
        this.oItemPid = oItemPid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}