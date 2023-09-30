package com.outlook.philiphyw.springdatajpapractice;

import com.github.javafaker.Faker;
import com.outlook.philiphyw.springdatajpapractice.student.model.Student;
import com.outlook.philiphyw.springdatajpapractice.student.repository.StudentRepository;
import com.outlook.philiphyw.springdatajpapractice.studentcard.model.StudentCard;
import com.outlook.philiphyw.springdatajpapractice.studentcard.repository.StudentCardRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class SpringDataJpaPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaPracticeApplication.class, args);
	}

	@Bean
	Faker getFaker() {
		return new Faker();
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository, StudentCardRepository studentCardRepository,Faker faker){
		return args -> {

//			List<Student> students = IntStream
//					.rangeClosed(1,20)
//					.mapToObj(i -> Student
//							.builder()
//							.firstName(faker.name().firstName())
//							.lastName(faker.name().lastName())
//							.email(faker.internet().emailAddress())
//							.age(faker.number().numberBetween(18,80))
//							.isActive(faker.bool().bool())
//							.build()
//					).collect(Collectors.toList());
//
//			studentRepository.saveAll(students);

			List<StudentCard> studentCards = IntStream
					.rangeClosed(1,20)
					.mapToObj(i -> {
						Student student = Student
								.builder()
								.firstName(faker.name().firstName())
								.lastName(faker.name().lastName())
								.email(faker.internet().emailAddress())
								.age(faker.number().numberBetween(18,80))
								.isActive(faker.bool().bool())
								.build();

						return new StudentCard(
								null,
								UUID.randomUUID().toString().substring(0,15),
								student
						);
					}).collect(Collectors.toList());

			studentCardRepository.saveAll(studentCards);

			studentRepository.deleteById(2L);

			studentCardRepository.deleteById(20L);

//			Student student = students.get(0);
//
//			StudentCard studentCard = new StudentCard(
//							null,
//							"alksdfja12",
//							student
//							);
//			studentCardRepository.save(studentCard);


//			List<StudentCard> studentCards = IntStream
//					.rangeClosed(1,20)
//					.mapToObj(i -> new StudentCard(
//							null,
//							faker.idNumber().toString(),
//							students.get(i-1)
//							)
//					).collect(Collectors.toList());
//			studentCardRepository.saveAll(studentCards);

			System.out.println("sample data is generated");


//			Test JPQL in Student Repository
//			studentRepository.findActiveStudentOverAge(30)
//					.stream()
//					.forEach(student -> System.out.println("findActiveStudentOverAge: " + student));

//			System.out.println("findStudentBetweenAge(18,80) before deletion");
//
//			studentRepository.findStudentBetweenAge(18,80)
//					.stream()
//					.forEach(student -> System.out.println("findStudentBetweenAge: " + student));
//
//
//			System.out.println("About to deleteStudentByAgeLessThan(60)");
//			studentRepository.deleteStudentByAgeLessThan(60);
//
//			System.out.println("findStudentBetweenAge(18,80) after deletion");
//
//			studentRepository.findStudentBetweenAge(18,80)
//					.stream()
//					.forEach(student -> System.out.println("findStudentBetweenAge: " + student));

		};

	}

}
