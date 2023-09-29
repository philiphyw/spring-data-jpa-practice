package com.outlook.philiphyw.springdatajpapractice.student.repository;

import com.outlook.philiphyw.springdatajpapractice.student.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT s FROM Student s WHERE s.isActive = true AND s.age >= ?1 ORDER BY s.age DESC")
    List<Student> findActiveStudentOverAge(Integer age);

    @Query("SELECT s FROM Student s WHERE s.age >= :age1 AND s.age <=:age2 ORDER BY s.age DESC")
    List<Student> findStudentBetweenAge(@Param("age1")Integer age1,@Param("age2")Integer age2);

    @Modifying
    @Transactional
    @Query("DELETE FROM Student u WHERE u.age <:age1")
            int deleteStudentByAgeLessThan(@Param("age1")Integer age1);
}
