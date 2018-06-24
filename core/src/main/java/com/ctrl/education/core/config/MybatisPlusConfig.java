package com.ctrl.education.core.config;


import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * com.ctrl.education.config
 *
 * @author ly
 * @name MybatisPlusConfig
 * @description
 * @date 2018-06-02 14:39
 */
@Configuration
@MapperScan("com.ctrl.education.dao")
public class MybatisPlusConfig {
    /*
     * 分页插件，自动识别数据库类型
     * 多租户，请参考官网【插件扩展】
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
