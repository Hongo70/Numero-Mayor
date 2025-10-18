package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EjemplojsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjemplojsonApplication.class, args);
	}
	@Bean
    public ServletRegistrationBean<ServletJason> registrarServlet() {
        return new ServletRegistrationBean<>(new ServletJason(), "/api/json");
    }
}
