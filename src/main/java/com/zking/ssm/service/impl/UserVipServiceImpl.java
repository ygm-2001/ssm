package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.UserVipMapper;
import com.zking.ssm.model.UserVip;
import com.zking.ssm.service.IUserVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVipServiceImpl implements IUserVipService {
    @Autowired
    private UserVipMapper userVipMapper;

    @Override
    public int insert(UserVip record) {
        return userVipMapper.insert(record);
    }

    @Override
    public int insertSelective(UserVip record) {
        return userVipMapper.insertSelective(record);
    }
}
