package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.JiaKuMapper;
import com.zking.ssm.mapper.UserMapper;
import com.zking.ssm.model.JiaKu;
import com.zking.ssm.model.User;
import com.zking.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private JiaKuMapper jiaKuMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Transactional
    @Override
    public void intoUserAndJiaKu(JiaKu jiaKu,User user) {
        jiaKuMapper.insert(jiaKu);
        userMapper.insertSelective(user);
    }

    @Override
    public int selectByIdentity(User user) {
        return userMapper.selectByIdentity(user);
    }

    @Override
    public User selectByIdentityUser(User user) {
        return userMapper.selectByIdentityUser(user);
    }

    @Override
    public User selectByIdentityAndPwd(User user) {
        return userMapper.selectByIdentityAndPwd(user);
    }
}
