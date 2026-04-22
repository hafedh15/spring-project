package tn.esprit.tpgestiondesinscriptionsuniversitaires.service;

import tn.esprit.tpgestiondesinscriptionsuniversitaires.dto.EnrollmentDTO;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Enrollments;
import java.util.List;

public interface IEnrollmentService {
    Enrollments enrollStudent(EnrollmentDTO dto);
    List<Enrollments> getAllEnrollments();
    List<Enrollments> getEnrollmentsByStudent(Long studentId);
    List<Enrollments> getEnrollmentsByCourse(Long courseId);

}