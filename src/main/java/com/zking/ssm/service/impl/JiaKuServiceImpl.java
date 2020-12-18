package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.JiaKuMapper;
import com.zking.ssm.model.JiaKu;
import com.zking.ssm.service.IJiaKuService;
import org.springframework.beans.factory.annotation.Autowired;

public class JiaKuServiceImpl implements IJiaKuService {

    @Autowired
    private JiaKuMapper jiaKuMapper;

    @Override
    public int insert(JiaKu record) {
        return jiaKuMapper.insert(record);
    }

    @Override
    public int insertSelective(JiaKu record) {
        return jiaKuMapper.insertSelective(record);
    }
}
