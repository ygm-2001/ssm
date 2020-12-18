package com.zking.ssm.mapper;

import com.zking.ssm.model.File;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMapper {
    int deleteByPrimaryKey(Long fileId);

    int insert(File record);

    int insertSelective(File record);

    File selectByPrimaryKey(Long fileId);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);
}