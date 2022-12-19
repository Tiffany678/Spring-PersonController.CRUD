package io.zipcoder.crudapp;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CRUDApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(CRUDApplication.class, args);
		}
		catch (Exception e){

		}
	}

	@Bean
	ServletRegistrationBean h2servletRegistration(){
		try {
			ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
			registrationBean.addUrlMappings("/console/*");
			return registrationBean;
		}
		catch (Exception e) {}
		return null;
	}
}
