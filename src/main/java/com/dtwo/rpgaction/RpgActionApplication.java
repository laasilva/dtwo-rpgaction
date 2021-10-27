package com.dtwo.rpgaction;

import com.dtwo.rpgaction.model.entities.User;
import com.dtwo.rpgaction.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("com.dtwo.rpgaction")
@EntityScan(basePackageClasses={User.class})
@EnableJpaRepositories(basePackageClasses={UserRepository.class})
public class RpgActionApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpgActionApplication.class, args);
	}

}
