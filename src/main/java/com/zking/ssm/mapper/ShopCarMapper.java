package com.zking.ssm.mapper;

import com.zking.ssm.model.ShopCar;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopCarMapper {
    int deleteByPrimaryKey(Long carId);

    int insert(ShopCar record);

    int insertSelective(ShopCar record);

    ShopCar selectByPrimaryKey(Long carId);

    int updateByPrimaryKeySelective(ShopCar record);

    int updateByPrimaryKey(ShopCar record);
}