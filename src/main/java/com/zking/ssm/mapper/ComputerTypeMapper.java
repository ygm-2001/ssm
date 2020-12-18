package com.zking.ssm.mapper;

import com.zking.ssm.model.ComputerType;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerTypeMapper {
    int insert(ComputerType record);

    int insertSelective(ComputerType record);
}