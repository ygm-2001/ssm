package com.zking.ssm.model;

import lombok.Data;

@Data
public class FileType {
    private Long fileTypeId;

    private String fType;

    public FileType(Long fileTypeId, String fType) {
        this.fileTypeId = fileTypeId;
        this.fType = fType;
    }

    public FileType() {
        super();
    }

    public Long getFileTypeId() {
        return fileTypeId;
    }

    public void setFileTypeId(Long fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType;
    }
}