package com.outlook.philiphyw.springdatajpapractice.student.repository;

import com.outlook.philiphyw.springdatajpapractice.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT s FROM Student s WHERE s.isActive = true AND s.age >= ?1 ORDER BY s.age DESC")
    List<Student> findActiveStudentOverAge(Integer age);
}
