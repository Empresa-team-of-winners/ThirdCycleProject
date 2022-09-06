package com.team.winners.thirdcycleproject;

import com.team.winners.thirdcycleproject.models.Employee;
import com.team.winners.thirdcycleproject.models.Enterprise;
import com.team.winners.thirdcycleproject.models.Profile;
import com.team.winners.thirdcycleproject.repository.EmployeeRepository;
import com.team.winners.thirdcycleproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ThirdcycleprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdcycleprojectApplication.class, args);
	}

}
