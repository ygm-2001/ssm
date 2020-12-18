package com.zking.ssm.service;

import com.zking.ssm.model.ComputerType;
import org.springframework.stereotype.Repository;


public interface IComputerTypeService {
    int insert(ComputerType record);

    int insertSelective(ComputerType record);
}