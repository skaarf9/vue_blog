package com.skaarf9.vueblog.config.MybatisPlusConfig;/**
 * @author: Administrator
 * @date: 2022/2/22 16:14
 * @description:
 */

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Administrator
 * @date 2022/2/22
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.skaarf9.vueblog.mapper")
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor  paginationInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
