package com.zking.ssm.mapper;

import com.zking.ssm.model.JiaKu;
import org.springframework.stereotype.Repository;

@Repository
public interface JiaKuMapper {
    int insert(JiaKu record);

    int insertSelective(JiaKu record);
}