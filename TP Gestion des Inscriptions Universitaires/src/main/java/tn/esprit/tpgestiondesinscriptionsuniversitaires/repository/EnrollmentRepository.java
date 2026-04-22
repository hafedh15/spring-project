package tn.esprit.tpgestiondesinscriptionsuniversitaires.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Enrollments;
import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollments, Long> {

    long countByCourseIdAndActiveTrue(Long courseId);

    // زدهم هاذم:
    List<Enrollments> findByStudentId(Long studentId);
    List<Enrollments> findByCourseId(Long courseId);

    // هذي باش يستعملها الـ Scheduler لمهمّة الـ Rapport Journalier
    long countByActiveTrue();

    @Query("SELECT e.student FROM Enrollments e WHERE e.course.id = :courseId")
    List<Object> findStudentsByCourseId(@Param("courseId") Long courseId);

    List<Enrollments> findByActiveTrue();
}