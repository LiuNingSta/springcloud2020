package com.atliuning.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: L.N
 * @create: 2020-04-16 23:16
 **/
@Component
public class GateWayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("AAAA",r->r.path("/guonei").uri("https://news.baidu.com/guonei"));
        routes.route("BBBB",r->r.path("/guoji").uri("https://news.baidu.com/guoji"));
        return routes.build();
    }
}
