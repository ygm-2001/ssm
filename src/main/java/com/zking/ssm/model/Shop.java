package com.zking.ssm.model;

import lombok.Data;
import java.util.Date;

@Data
public class Shop {
    private Long shopId;

    private String shopName;

    private String shopType;

    private Float shopPrice;

    private String shopInven;

    private String shopState;

    private Long shopImgi;

    private String shopImgv;

    private Date shopTime;

    private Long shopXid;

    public Shop(Long shopId, String shopName, String shopType, Float shopPrice, String shopInven, String shopState, Long shopImgi, String shopImgv, Date shopTime, Long shopXid) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopType = shopType;
        this.shopPrice = shopPrice;
        this.shopInven = shopInven;
        this.shopState = shopState;
        this.shopImgi = shopImgi;
        this.shopImgv = shopImgv;
        this.shopTime = shopTime;
        this.shopXid = shopXid;
    }

    public Shop() {
        super();
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public Float getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Float shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getShopInven() {
        return shopInven;
    }

    public void setShopInven(String shopInven) {
        this.shopInven = shopInven;
    }

    public String getShopState() {
        return shopState;
    }

    public void setShopState(String shopState) {
        this.shopState = shopState;
    }

    public Long getShopImgi() {
        return shopImgi;
    }

    public void setShopImgi(Long shopImgi) {
        this.shopImgi = shopImgi;
    }

    public String getShopImgv() {
        return shopImgv;
    }

    public void setShopImgv(String shopImgv) {
        this.shopImgv = shopImgv;
    }

    public Date getShopTime() {
        return shopTime;
    }

    public void setShopTime(Date shopTime) {
        this.shopTime = shopTime;
    }

    public Long getShopXid() {
        return shopXid;
    }

    public void setShopXid(Long shopXid) {
        this.shopXid = shopXid;
    }
}