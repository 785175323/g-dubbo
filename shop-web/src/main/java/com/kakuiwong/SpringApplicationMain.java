package com.kakuiwong;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: gaoyang
 * @Description:
 */
@NacosPropertySource(dataId = "shop.yaml",autoRefreshed = true,groupId = "DEFAULT_GROUP")
@SpringBootApplication
public class SpringApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationMain.class, args);
    }
}
