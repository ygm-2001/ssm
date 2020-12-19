package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.ComputerTypeMapper;
import com.zking.ssm.model.ComputerType;
import com.zking.ssm.service.IComputerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerTypeServiceImpl implements IComputerTypeService {
    @Autowired
    private ComputerTypeMapper computerTypeMapper;
    @Override
    public int insert(ComputerType record) {
        return computerTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(ComputerType record) {
        return computerTypeMapper.insertSelective(record);
    }
}
