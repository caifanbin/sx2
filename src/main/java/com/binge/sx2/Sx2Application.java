package com.binge.sx2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(value = "com.binge.sx2.mapper")
@SpringBootApplication
public class Sx2Application {

    public static void main(String[] args) {
        SpringApplication.run(Sx2Application.class, args);
    }

}
