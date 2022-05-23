package com.gxks.mall_admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 工程额外配置
 */
@Configuration
public class WebConfig {

    /**
     * 向容器中添加一个 RestTemplate 组件，该组件可以完成基于 Rest 的微服务调用
     * @return
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
