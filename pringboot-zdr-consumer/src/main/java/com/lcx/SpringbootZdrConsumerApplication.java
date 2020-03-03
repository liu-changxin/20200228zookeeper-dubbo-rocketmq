package com.lcx;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class SpringbootZdrConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootZdrConsumerApplication.class, args);
	}

}
