package com.zking.ssm.model;

import lombok.Data;

import java.util.Date;

@Data
public class Computer {
    private Long comId;

    private Long comTypeId;

    private Float comPrice;

    private Long userId;

    private Date comToptime;

    private Date comDowntime;

    private String comState;

    private Long comXid;

    public Computer(Long comId, Long comTypeId, Float comPrice, Long userId, Date comToptime, Date comDowntime, String comState, Long comXid) {
        this.comId = comId;
        this.comTypeId = comTypeId;
        this.comPrice = comPrice;
        this.userId = userId;
        this.comToptime = comToptime;
        this.comDowntime = comDowntime;
        this.comState = comState;
        this.comXid = comXid;
    }

    public Computer() {
        super();
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public Long getComTypeId() {
        return comTypeId;
    }

    public void setComTypeId(Long comTypeId) {
        this.comTypeId = comTypeId;
    }

    public Float getComPrice() {
        return comPrice;
    }

    public void setComPrice(Float comPrice) {
        this.comPrice = comPrice;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getComToptime() {
        return comToptime;
    }

    public void setComToptime(Date comToptime) {
        this.comToptime = comToptime;
    }

    public Date getComDowntime() {
        return comDowntime;
    }

    public void setComDowntime(Date comDowntime) {
        this.comDowntime = comDowntime;
    }

    public String getComState() {
        return comState;
    }

    public void setComState(String comState) {
        this.comState = comState;
    }

    public Long getComXid() {
        return comXid;
    }

    public void setComXid(Long comXid) {
        this.comXid = comXid;
    }
}