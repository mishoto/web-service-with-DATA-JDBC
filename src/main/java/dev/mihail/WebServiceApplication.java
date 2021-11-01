package dev.mihail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
@ComponentScan(basePackages = {"dev.mihail.DAO", "dev.mihail.DTO", "dev.mihail.service",
											"dev.mihail.config", "dev.mihail.controller"},
		       basePackageClasses = {dev.mihail.controller.UserDAOController.class,
			   						 dev.mihail.DTO.UserDTOService.class})

public class WebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class, args);
	}

}
