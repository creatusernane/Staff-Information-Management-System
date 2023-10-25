package com.hl.staffboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName StaffApplication
 * @Description TODO
 * @Author yx
 * @Date 2023/10/24 14:29
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.hl.staffboot.dao")
public class StaffApplication {
    public static void main(String[] args) {
        SpringApplication.run(StaffApplication.class,args);
    }
}
