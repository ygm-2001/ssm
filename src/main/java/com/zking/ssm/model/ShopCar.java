package com.zking.ssm.model;

import lombok.Data;

@Data
public class ShopCar {
    private Long carId;

    private Long shopId;

    private Long userId;

    private Integer count;

    private Float moneys;

    public ShopCar(Long carId, Long shopId, Long userId, Integer count, Float moneys) {
        this.carId = carId;
        this.shopId = shopId;
        this.userId = userId;
        this.count = count;
        this.moneys = moneys;
    }

    public ShopCar() {
        super();
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getMoneys() {
        return moneys;
    }

    public void setMoneys(Float moneys) {
        this.moneys = moneys;
    }
}