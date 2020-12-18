package com.zking.ssm.model;

import lombok.Data;

@Data
public class UserVip {
    private Long vid;

    private String vipName;

    public UserVip(Long vid, String vipName) {
        this.vid = vid;
        this.vipName = vipName;
    }

    public UserVip() {
        super();
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }
}