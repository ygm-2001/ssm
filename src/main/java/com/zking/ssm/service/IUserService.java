package com.zking.ssm.service;

import com.zking.ssm.model.JiaKu;
import com.zking.ssm.model.User;
import org.springframework.stereotype.Repository;

public interface IUserService {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //二个事件共同完成
    void intoUserAndJiaKu(JiaKu jiaKu,User user);
    //防重复注册
    int selectByIdentity(User user);
}