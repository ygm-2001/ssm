package com.zking.ssm.controller;

import com.zking.ssm.dto.MyFileDto;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/file")
public class MyFileController {

    @ModelAttribute
    public void init(){
        System.out.println("MyFileController......初始化数据中");
    }

    @RequestMapping("/toUpload")
    public String toUpload(){
        return "upload";
    }

    @RequestMapping("/upload")
    public String upload(MyFileDto myFileDto, HttpServletRequest request){
        Integer bookId = myFileDto.getBookId();
        String name = "a";
        MultipartFile file = myFileDto.getFile();
        String path = File.separator+"upload"+File.separator+file.getOriginalFilename();
        System.out.println("path**************"+path);
        request.setAttribute("path",path);
        //上传真实路径
        String realPath = request.getServletContext().getRealPath(path);
        System.out.println("realPath========="+realPath);
        request.setAttribute("realPath",realPath);
        try {
            //一行代码文件上传
            file.transferTo(new File(realPath));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        //获取当前时间
        long fileId = System.currentTimeMillis();
        com.zking.ssm.model.File myFile = new com.zking.ssm.model.File();
        myFile.setFileId(fileId);
        myFile.setRealName(file.getOriginalFilename());
        myFile.setContentType(file.getContentType());
        myFile.setFilePath(path);
        return "forward:/bookList?bookName=";
    }

//    @RequestMapping(value="/download")
//    public ResponseEntity<byte[]> download(@RequestParam Long fileId,HttpServletRequest req) throws UnsupportedEncodingException {
//        //先根据文件id查询对应图片信息
//        com.zking.ssm.model.File myFile = fileService.selectByPrimaryKey(fileId);
//        //虚拟路径去找到真实路径
//        String filePath = myFile.getFilePath();
//        System.out.println(filePath);
//        //获取到真实路径
//        String realPath = req.getServletContext().getRealPath(filePath);
//        System.out.println(realPath);
//        //获取真实名字（图片）
//        String realName = myFile.getRealName();
////开始正式下载
//        //真实路径
//        File file = new File(realPath);
//        //http头信息
//        HttpHeaders headers = new HttpHeaders();
//        //设置编码
//        String downloadFileName = new String(realName.getBytes("UTF-8"),"iso-8859-1");
//        headers.setContentDispositionFormData("attachment", downloadFileName);
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        //MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息
//        try {
//            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

}
