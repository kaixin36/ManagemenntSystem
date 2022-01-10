package com.lf.backmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lf.backmanage.mapper")//使用MapperScan批量扫描所有的Mapper接口；
public class BackmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackmanageApplication.class, args);
    }

}
