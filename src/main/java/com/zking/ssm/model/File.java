package com.zking.ssm.model;

import lombok.Data;

import java.util.Date;
@Data
public class File {
    private Long fileId;

    private String realName;

    private String contentType;

    private Date updateDatetime;

    private String filePath;

    private Long fileType;

    public File(Long fileId, String realName, String contentType, Date updateDatetime, String filePath, Long fileType) {
        this.fileId = fileId;
        this.realName = realName;
        this.contentType = contentType;
        this.updateDatetime = updateDatetime;
        this.filePath = filePath;
        this.fileType = fileType;
    }

    public File() {
        super();
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getFileType() {
        return fileType;
    }

    public void setFileType(Long fileType) {
        this.fileType = fileType;
    }
}