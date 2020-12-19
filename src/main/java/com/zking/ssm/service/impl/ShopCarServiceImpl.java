package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.ShopCarMapper;
import com.zking.ssm.model.ShopCar;
import com.zking.ssm.service.IShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopCarServiceImpl implements IShopCarService {
    @Autowired
    private ShopCarMapper shopCarMapper;

    @Override
    public int deleteByPrimaryKey(Long carId) {
        return shopCarMapper.deleteByPrimaryKey(carId);
    }

    @Override
    public int insert(ShopCar record) {
        return shopCarMapper.insert(record);
    }

    @Override
    public int insertSelective(ShopCar record) {
        return shopCarMapper.insertSelective(record);
    }

    @Override
    public ShopCar selectByPrimaryKey(Long carId) {
        return shopCarMapper.selectByPrimaryKey(carId);
    }

    @Override
    public int updateByPrimaryKeySelective(ShopCar record) {
        return shopCarMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ShopCar record) {
        return shopCarMapper.updateByPrimaryKey(record);
    }
}
