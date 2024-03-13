package com.yuyu;

import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.yuyu.dao")
@EnableMPP
@EnableScheduling
@EnableTransactionManagement
public class VideosWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideosWebsiteApplication.class, args);
    }

}
