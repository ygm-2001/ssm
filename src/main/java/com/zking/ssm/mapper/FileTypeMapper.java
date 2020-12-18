package com.zking.ssm.mapper;

import com.zking.ssm.model.FileType;
import org.springframework.stereotype.Repository;

@Repository
public interface FileTypeMapper {
    int insert(FileType record);

    int insertSelective(FileType record);
}