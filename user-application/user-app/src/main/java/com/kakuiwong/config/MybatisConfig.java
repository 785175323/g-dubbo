package com.kakuiwong.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: gaoyang
 * @Description:
 */
@MapperScan(basePackages = "com.kakuiwong.mapper")
@Configuration
public class MybatisConfig {
}
