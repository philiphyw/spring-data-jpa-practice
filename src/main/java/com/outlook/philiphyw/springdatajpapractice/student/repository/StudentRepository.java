package com.outlook.philiphyw.springdatajpapractice.student.repository;

import com.outlook.philiphyw.springdatajpapractice.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
