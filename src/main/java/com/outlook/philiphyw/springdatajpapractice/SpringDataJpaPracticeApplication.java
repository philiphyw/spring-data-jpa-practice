package com.outlook.philiphyw.springdatajpapractice;

import com.outlook.philiphyw.springdatajpapractice.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaPracticeApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository){
		return args -> {
			System.out.println("commandLineRunner is running");
		};
	}

}
