package com.qiniu.oss;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "qiniu")
public class QiNiuOSSProperties {
    private String accessKey;
    //身份ID
    private String secretKey ;
    //身份密钥
    private String bucket ;
    //存储空间
    private String domain;
}
