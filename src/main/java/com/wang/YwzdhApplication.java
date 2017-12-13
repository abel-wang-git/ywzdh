package com.wang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wang.dao")
public class YwzdhApplication {

	public static void main(String[] args) {
		SpringApplication.run(YwzdhApplication.class, args);
	}
}
