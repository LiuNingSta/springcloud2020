package com.atliuning.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: L.N
 * @create: 2020-04-15 22:53
 **/

@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLeve(){
        return Logger.Level.FULL;
    }
}
