package com.zking.ssm.service;

import com.zking.ssm.model.UserVip;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IUserVipService {
    int insert(UserVip record);

    int insertSelective(UserVip record);

    //根据id查询
    UserVip selectVIP(UserVip vipid);

    //查询所有VIP卡片
    List<UserVip> selectVIPALL();
}