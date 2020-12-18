package com.zking.ssm.mapper;

import com.zking.ssm.model.UserVip;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVipMapper {
    int insert(UserVip record);

    int insertSelective(UserVip record);
}