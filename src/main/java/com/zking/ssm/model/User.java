package com.zking.ssm.model;

import lombok.Data;

@Data
public class User {
    private Long id;

    private String name;

    private String password;

    private String salt;

    private String locked;

    private Float money;

    private String state;

    private String identity;

    private Long vipid;

    private Long img;

    private Integer lv;

    private Long xid;

    public User(Long id, String name, String password, String salt, String locked, Float money, String state, String identity, Long vipid, Long img, Integer lv, Long xid) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.salt = salt;
        this.locked = locked;
        this.money = money;
        this.state = state;
        this.identity = identity;
        this.vipid = vipid;
        this.img = img;
        this.lv = lv;
        this.xid = xid;
    }

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Long getVipid() {
        return vipid;
    }

    public void setVipid(Long vipid) {
        this.vipid = vipid;
    }

    public Long getImg() {
        return img;
    }

    public void setImg(Long img) {
        this.img = img;
    }

    public Integer getLv() {
        return lv;
    }

    public void setLv(Integer lv) {
        this.lv = lv;
    }

    public Long getXid() {
        return xid;
    }

    public void setXid(Long xid) {
        this.xid = xid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", locked='" + locked + '\'' +
                ", money=" + money +
                ", state='" + state + '\'' +
                ", identity='" + identity + '\'' +
                ", vipid=" + vipid +
                ", img=" + img +
                ", lv=" + lv +
                ", xid=" + xid +
                '}';
    }
}