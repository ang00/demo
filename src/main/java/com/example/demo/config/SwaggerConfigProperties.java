package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Auther: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2018/10/29/029 13:59
 * @Version: 1.0
 * @Description:
 */
@ConfigurationProperties(prefix = "sop.swagger")
@Component
public class SwaggerConfigProperties implements Serializable {
    /**
     * 是否开启 Swagger
     */
    private boolean enable = false;
    /**
     * 要扫描的包
     */
    private String packageScan;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 版本信息
     */
    private String version;

    public boolean isEnable (){
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getPackageScan() {
        return packageScan;
    }

    public void setPackageScan(String packageScan) {
        this.packageScan = packageScan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
