package com.test.demos.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 描述: Mybatis 配置类
 *
 * @author caoXB
 * @date 2020/3/13 17:59
 */
@Configuration
@MapperScan({"com.test.demos.mapper"})
public class MyBatisConfig {
}
