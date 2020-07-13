package com.jguiller.InfoProductService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class})
public class InfoProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoProductServiceApplication.class, args);
	}

}
