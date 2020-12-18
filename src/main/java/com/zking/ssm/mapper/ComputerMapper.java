package com.zking.ssm.mapper;

import com.zking.ssm.model.Computer;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerMapper {
    int deleteByPrimaryKey(Long comId);

    int insert(Computer record);

    int insertSelective(Computer record);

    Computer selectByPrimaryKey(Long comId);

    int updateByPrimaryKeySelective(Computer record);

    int updateByPrimaryKey(Computer record);
}