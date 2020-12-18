package com.zking.ssm.model;

import lombok.Data;

import java.util.Date;
@Data
public class Order {
    private Long orderId;

    private Long orderItemId;

    private Long userId;

    private Long comId;

    private Date orderTimed;

    private Float prices;

    public Order(Long orderId, Long orderItemId, Long userId, Long comId, Date orderTimed, Float prices) {
        this.orderId = orderId;
        this.orderItemId = orderItemId;
        this.userId = userId;
        this.comId = comId;
        this.orderTimed = orderTimed;
        this.prices = prices;
    }

    public Order() {
        super();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public Date getOrderTimed() {
        return orderTimed;
    }

    public void setOrderTimed(Date orderTimed) {
        this.orderTimed = orderTimed;
    }

    public Float getPrices() {
        return prices;
    }

    public void setPrices(Float prices) {
        this.prices = prices;
    }
}