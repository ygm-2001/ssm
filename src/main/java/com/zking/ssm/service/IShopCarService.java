package com.zking.ssm.service;

import com.zking.ssm.model.ShopCar;
import org.springframework.stereotype.Repository;


public interface IShopCarService {
    int deleteByPrimaryKey(Long carId);

    int insert(ShopCar record);

    int insertSelective(ShopCar record);

    ShopCar selectByPrimaryKey(Long carId);

    int updateByPrimaryKeySelective(ShopCar record);

    int updateByPrimaryKey(ShopCar record);
}