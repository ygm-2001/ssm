package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.ShopMapper;
import com.zking.ssm.model.Shop;
import com.zking.ssm.service.IShopService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements IShopService {
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public int deleteByPrimaryKey(Long shopId) {
        return shopMapper.deleteByPrimaryKey(shopId);
    }

    @Override
    public int insert(Shop record) {
        return shopMapper.insert(record);
    }

    @Override
    public int insertSelective(Shop record) {
        return shopMapper.insertSelective(record);
    }

    @Override
    public Shop selectByPrimaryKey(Long shopId) {
        return shopMapper.selectByPrimaryKey(shopId);
    }

    @Override
    public int updateByPrimaryKeySelective(Shop record) {
        return shopMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Shop record) {
        return shopMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Shop> selectShopAllPager(Shop shop, PageBean pageBean) {
        return shopMapper.selectShopAllPager(shop);
    }
}
