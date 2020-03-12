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

    /**
     * 存在@TableField(file=FieldFill.XXX)的时候，才会进入这个方法。@TableId()不会进入
     * @author yu.shigui@rongzer.com
     * @date 2020/3/12 17:23
     * @param 
     * @return com.bzdnet.community.handler.MyBatisPlusFillHandler
     **/
    @Bean
    public MyBatisPlusFillHandler myBatisPlusFillHandler() {
        return new MyBatisPlusFillHandler();
    }

}
