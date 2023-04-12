package com.itheima.day06.controller;

import com.itheima.day06.common.QiNiuClient;
import com.itheima.day06.common.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


/**
 * 常见控制器
 *
 * @author ilovend
 * @date 2023/02/17
 */
@RestController
@RequestMapping
@Slf4j
@Api(tags = "图片上传下载")
public class CommonController {
@Autowired
private QiNiuClient qiNiuClient;
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        String originalFilename = image.getOriginalFilename();//1.jpg
        int index = originalFilename.lastIndexOf(".");//  1
        String suffix = originalFilename.substring(index);//.jpg
        //随机生成图片的名字  gutrwaestygiutrawstgiuhiset
        String fileName = UUID.randomUUID().toString().replace("-","")+suffix;
        //上传到七牛云
        String url = qiNiuClient.transferQiNiuOss(fileName, image.getInputStream());
        return Result.success(url);
    }
}
