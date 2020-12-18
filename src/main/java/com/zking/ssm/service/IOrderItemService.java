package com.zking.ssm.service;

import com.zking.ssm.model.OrderItem;
import org.springframework.stereotype.Repository;


public interface IOrderItemService {
    int deleteByPrimaryKey(Long oItemId);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Long oItemId);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}