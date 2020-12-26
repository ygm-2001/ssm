package com.zking.ssm.service;

import com.zking.ssm.model.Shop;
import com.zking.ssm.util.PageBean;

import java.util.List;

public interface IShopService {
    int deleteByPrimaryKey(Long shopId);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Long shopId);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);

//    查询所有商品，当然支持模糊查询
    List<Shop> selectShopAllPager(Shop shop, PageBean pageBean);

}