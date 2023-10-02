package com.outlook.philiphyw.springdatajpapractice;

import com.github.javafaker.Faker;
import com.outlook.philiphyw.springdatajpapractice.book.model.Book;
import com.outlook.philiphyw.springdatajpapractice.book.repository.BookRepository;
import com.outlook.philiphyw.springdatajpapractice.student.model.Student;
import com.outlook.philiphyw.springdatajpapractice.student.repository.StudentRepository;
import com.outlook.philiphyw.springdatajpapractice.studentcard.model.StudentCard;
import com.outlook.philiphyw.springdatajpapractice.studentcard.repository.StudentCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
	CommandLineRunner commandLineRunner(StudentRepository studentRepository, StudentCardRepository studentCardRepository,Faker faker,BookRepository bookRepository){
		return args -> {
			List<Student> students = IntStream
					.rangeClosed(1,20)
					.mapToObj(i -> {
						Student student = Student
								.builder()
								.firstName(faker.name().firstName())
								.lastName(faker.name().lastName())
								.email(faker.internet().emailAddress())
								.age(faker.number().numberBetween(18,80))
								.isActive(faker.bool().bool())
								.books(new ArrayList<Book>())
								.build();
						student.setStudentCard(new StudentCard(
								UUID.randomUUID().toString().substring(0,15),
								student
						));
						return student;
					}).collect(Collectors.toList());

				studentRepository.saveAll(students);

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

//			List<StudentCard> studentCards = IntStream
//					.rangeClosed(1,20)
//					.mapToObj(i -> {
//						Student student = Student
//								.builder()
//								.firstName(faker.name().firstName())
//								.lastName(faker.name().lastName())
//								.email(faker.internet().emailAddress())
//								.age(faker.number().numberBetween(18,80))
//								.isActive(faker.bool().bool())
//								.books(new ArrayList<Book>())
//								.build();
//						return new StudentCard(
//								null,
//								UUID.randomUUID().toString().substring(0,15),
//								student
//						);
//					}).collect(Collectors.toList());
//
//			studentCardRepository.saveAll(studentCards);

			Optional<Student> student = studentRepository.findById(1L);
//
			student.ifPresent(
					s -> createBookSampleData(s,bookRepository)
			);

//			studentRepository.deleteById(2L);
//
//			studentCardRepository.deleteById(20L);





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

	private void createBookSampleData(Student student, BookRepository bookRepository) {
		List<Book> bookList = IntStream
				.rangeClosed(1,5)
				.mapToObj(i ->
					Book.builder()
							.student(student)
							.title(UUID.randomUUID().toString().substring(0,20))
							.build()
				).collect(Collectors.toList());
		bookRepository.saveAll(bookList);
	}
}
