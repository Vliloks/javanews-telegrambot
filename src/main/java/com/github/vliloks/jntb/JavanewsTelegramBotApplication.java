package com.github.vliloks.jntb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JavanewsTelegramBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavanewsTelegramBotApplication.class, args);
	}

}
