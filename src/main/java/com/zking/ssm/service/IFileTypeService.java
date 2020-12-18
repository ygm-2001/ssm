package com.zking.ssm.service;

import com.zking.ssm.model.FileType;
import org.springframework.stereotype.Repository;

public interface IFileTypeService {
    int insert(FileType record);

    int insertSelective(FileType record);
}