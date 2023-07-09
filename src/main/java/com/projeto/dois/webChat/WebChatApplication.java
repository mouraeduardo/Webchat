package com.projeto.dois.webChat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class WebChatApplication {

	public static void main(String[] args) {SpringApplication.run(WebChatApplication.class, args);
	}

}
