package com.outlook.philiphyw.springdatajpapractice.studentcard.repository;

import com.outlook.philiphyw.springdatajpapractice.studentcard.model.StudentCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCardRepository extends JpaRepository<StudentCard,Long> {

}
