package com.zking.ssm.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MyFileDto {

    private Integer bookId;
    private MultipartFile file;

}
