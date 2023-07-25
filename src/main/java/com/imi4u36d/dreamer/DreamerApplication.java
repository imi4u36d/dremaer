package com.imi4u36d.dreamer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.imi4u36d.dreamer.mapper")
@SpringBootApplication
public class DreamerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DreamerApplication.class, args);
    }

}
