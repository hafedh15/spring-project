package tn.esprit.tpgestiondesinscriptionsuniversitaires.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Enrollments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Students student;
    @ManyToOne
    @JoinColumn(name="course_id")
    private Courses course;

    private LocalDate enrollmentDate;
    private boolean active;



}
