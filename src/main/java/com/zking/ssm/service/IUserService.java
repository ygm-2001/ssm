package com.zking.ssm.service;

import com.zking.ssm.model.User;
import org.springframework.stereotype.Repository;

public interface IUserService {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}