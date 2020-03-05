package com.bzdnet.community.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.bzdnet.community.handler.MyBatisPlusFillHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({
        "com.bzdnet.community.dao"
})
public class MybatisPlusConfiguration {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }

    @Bean
    public MyBatisPlusFillHandler myBatisPlusFillHandler() {
        return new MyBatisPlusFillHandler();
    }

}
