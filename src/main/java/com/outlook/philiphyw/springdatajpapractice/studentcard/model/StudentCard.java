package com.outlook.philiphyw.springdatajpapractice.studentcard.model;

import com.outlook.philiphyw.springdatajpapractice.student.model.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name="StudentCard")
@Table(name="student_card")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCard {
    @Id
    @SequenceGenerator(
            sequenceName="student_card_sequence",
            name="student_card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_card_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    @Column(name = "card_number", length =15,nullable = false)
    private String cardNumber;
//    TODO Fix Student deletion when StudentCard is deleted
    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "student_id",
            referencedColumnName="id",
            foreignKey = @ForeignKey(name = "student_card_student_fk"))
    private Student student;

    public StudentCard(String cardNumber, Student student) {
        this.cardNumber=cardNumber;
        this.student=student;
    }
}
