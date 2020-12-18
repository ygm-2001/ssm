package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.OrderItemMapper;
import com.zking.ssm.model.OrderItem;
import com.zking.ssm.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderItemServiceImpl implements IOrderItemService {
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public int deleteByPrimaryKey(Long oItemId) {
        return orderItemMapper.deleteByPrimaryKey(oItemId);
    }

    @Override
    public int insert(OrderItem record) {
        return orderItemMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderItem record) {
        return orderItemMapper.insertSelective(record);
    }

    @Override
    public OrderItem selectByPrimaryKey(Long oItemId) {
        return orderItemMapper.selectByPrimaryKey(oItemId);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderItem record) {
        return orderItemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderItem record) {
        return orderItemMapper.updateByPrimaryKey(record);
    }
}
