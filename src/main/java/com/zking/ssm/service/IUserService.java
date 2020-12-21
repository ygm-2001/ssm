package com.zking.ssm.service;

import com.zking.ssm.dto.UserDto;
import com.zking.ssm.model.JiaKu;
import com.zking.ssm.model.User;
import com.zking.ssm.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    //根据身份号查询到用户
    User selectByIdentityUser(User user);

    //登录接口需要身份证号，密码匹配成功才能登录
    User selectByIdentityAndPwd(User user);

    //查询所有user，（支持分页）
    List<User> selectUserAllPager(User user,PageBean pageBean);

    //查询开通vip的用户
    List<User> selectUserByVipPager(UserDto userDto,PageBean pageBean);


}