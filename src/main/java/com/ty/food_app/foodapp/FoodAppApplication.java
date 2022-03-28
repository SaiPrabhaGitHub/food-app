package com.ty.food_app.foodapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FoodAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodAppApplication.class, args);
	}
	public Docket getDocket() {
		Contact contact=new Contact("Prabah", "www.prabha.com", "info@ty.com");
		List<VendorExtension> extensions=new ArrayList();
		
		ApiInfo apiInfo=new ApiInfo("Food App Service", "Service To Maneger Food Slaves", "SNPSHOT 1.5", "www.prabhaglobal.com", contact, "Licence 143", "www.prabha.com", extensions);
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ty.car.carappboot"))
				.build()
				.apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}

}



