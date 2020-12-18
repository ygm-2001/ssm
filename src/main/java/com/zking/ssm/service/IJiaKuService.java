package com.zking.ssm.service;

import com.zking.ssm.model.JiaKu;
import org.springframework.stereotype.Repository;

public interface IJiaKuService {
    int insert(JiaKu record);

    int insertSelective(JiaKu record);
}