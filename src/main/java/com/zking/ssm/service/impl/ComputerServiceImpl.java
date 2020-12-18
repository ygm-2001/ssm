package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.ComputerMapper;
import com.zking.ssm.model.Computer;
import com.zking.ssm.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;

public class ComputerServiceImpl implements IComputerService {

    @Autowired
    private ComputerMapper computerMapper;

    @Override
    public int deleteByPrimaryKey(Long comId) {
        return computerMapper.deleteByPrimaryKey(comId);
    }

    @Override
    public int insert(Computer record) {
        return computerMapper.insert(record);
    }

    @Override
    public int insertSelective(Computer record) {
        return computerMapper.insertSelective(record);
    }

    @Override
    public Computer selectByPrimaryKey(Long comId) {
        return computerMapper.selectByPrimaryKey(comId);
    }

    @Override
    public int updateByPrimaryKeySelective(Computer record) {
        return computerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Computer record) {
        return computerMapper.updateByPrimaryKey(record);
    }
}
