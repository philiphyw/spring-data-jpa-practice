package com.outlook.philiphyw.springdatajpapractice.book.model;

import com.outlook.philiphyw.springdatajpapractice.student.model.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import javax.naming.spi.NamingManager;
import java.io.FilenameFilter;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name="Book")
@Table(name="book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE,generator = "book_sequence")
    @Column(name="id",updatable=false)
    private Long id;

    @Column(
            name="title",
            nullable=false
    )
    private String title;

    @Column(
            name="created_at",
            nullable=false
    )
    @CreationTimestamp
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(
            name = "student_id",
            nullable=false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey( name = "student_book_fk")
    )
    private Student student;
}
