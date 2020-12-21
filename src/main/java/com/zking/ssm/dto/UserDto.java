package com.zking.ssm.dto;

import com.zking.ssm.model.User;

public class UserDto extends User {

    private Integer[] vipId;

    public Integer[] getVipId() {
        return vipId;
    }

    public void setVipId(Integer[] vipId) {
        this.vipId = vipId;
    }
}
