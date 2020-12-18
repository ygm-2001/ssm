package com.zking.ssm.service;

import com.zking.ssm.model.Order;
import org.springframework.stereotype.Repository;

public interface IOrderService {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}