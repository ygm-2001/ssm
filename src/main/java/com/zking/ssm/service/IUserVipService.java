package com.zking.ssm.service;

import com.zking.ssm.model.UserVip;
import org.springframework.stereotype.Repository;

public interface IUserVipService {
    int insert(UserVip record);

    int insertSelective(UserVip record);
}