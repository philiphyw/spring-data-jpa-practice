package com.outlook.philiphyw.springdatajpapractice.student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.generator.Generator;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name="student")
@Table(name="student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @SequenceGenerator(
            sequenceName="student_sequence",
            name="student_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;
    @Column(
            nullable = false,
            name = "first_name"
    )
    private String firstName;
    @Column(
            nullable = false,
            name = "last_name"
    )
    private String lastName;
    @Column(
            nullable = false,
            name = "email",
            unique = true
    )
    private String email;
    private Integer age;

    private Boolean isActive;






}
