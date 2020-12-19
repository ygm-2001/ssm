package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.FileTypeMapper;
import com.zking.ssm.model.FileType;
import com.zking.ssm.service.IFileTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileTypeServiceImpl implements IFileTypeService {

    @Autowired
    private FileTypeMapper fileTypeMapper;

    @Override
    public int insert(FileType record) {
        return fileTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(FileType record) {
        return fileTypeMapper.insertSelective(record);
    }
}
