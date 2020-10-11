package com.reggie.movie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//addResourceHandler请求路径
//addResourceLocations 在项目中的资源路径
//setCacheControl 设置静态资源缓存时间
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());
    }

}