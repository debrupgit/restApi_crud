package com.dsr.rest_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="student CRUD",description="its a rest API for performing crud operation on student record",version="1.0",contact=@Contact (name="Debrup",email="debrupsardar355@gmail.com",url="https://www.naukri.com/mnjuser/profile?id=&altresid")))
public class RestCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestCrudApplication.class, args);
	}

}
