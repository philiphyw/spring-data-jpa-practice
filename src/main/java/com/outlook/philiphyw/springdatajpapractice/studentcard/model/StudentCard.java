package com.outlook.philiphyw.springdatajpapractice.studentcard.model;

import com.outlook.philiphyw.springdatajpapractice.student.model.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity(name="StudentCard")
@Table(name="student_card")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCard {
    @Id
    @SequenceGenerator(name = "student_card_sequence", sequenceName = "student_card_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_card_sequence")
    private Long id;

    @Column(name = "card_number", length =15,nullable = false)
    private String cardNumber;
    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "student_id",referencedColumnName="id")
    private Student student;
}
