package com.outlook.philiphyw.springdatajpapractice.course.model;

import com.outlook.philiphyw.springdatajpapractice.student.model.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name="Course")
@Table(name="course")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE,generator = "course_sequence")
    @Column(name="id",updatable=false)
    private Long id;

    @Column(
            name="course_name",
            nullable = false
    )
    String name;

    @Column(
            name="department",
            nullable = false
    )
    String department;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "enrollment",
            joinColumns=@JoinColumn(
                    name = "course_id",
                    foreignKey=@ForeignKey(
                            name="enrollment_course_id_fk"
                    )
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    foreignKey=@ForeignKey(
                            name="enrollment_student_id_fk"
                    )
            )
    )
    private List<Student> students;
}
