package com.zking.ssm.model;

import lombok.Data;

@Data
public class ComputerType {
    private Long cTypeId;

    private String cpu;

    private String card;

    private String harddisk;

    private Long cTxid;

    public ComputerType(Long cTypeId, String cpu, String card, String harddisk, Long cTxid) {
        this.cTypeId = cTypeId;
        this.cpu = cpu;
        this.card = card;
        this.harddisk = harddisk;
        this.cTxid = cTxid;
    }

    public ComputerType() {
        super();
    }

    public Long getcTypeId() {
        return cTypeId;
    }

    public void setcTypeId(Long cTypeId) {
        this.cTypeId = cTypeId;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getHarddisk() {
        return harddisk;
    }

    public void setHarddisk(String harddisk) {
        this.harddisk = harddisk;
    }

    public Long getcTxid() {
        return cTxid;
    }

    public void setcTxid(Long cTxid) {
        this.cTxid = cTxid;
    }
}