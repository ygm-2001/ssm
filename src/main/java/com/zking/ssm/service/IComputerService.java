package com.zking.ssm.service;

import com.zking.ssm.model.Computer;


public interface IComputerService {
    int deleteByPrimaryKey(Long comId);

    int insert(Computer record);

    int insertSelective(Computer record);

    Computer selectByPrimaryKey(Long comId);

    int updateByPrimaryKeySelective(Computer record);

    int updateByPrimaryKey(Computer record);
}