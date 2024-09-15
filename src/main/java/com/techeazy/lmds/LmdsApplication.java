package com.techeazy.lmds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class LmdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmdsApplication.class, args);
	}
	

	

}
