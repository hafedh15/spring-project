package tn.esprit.tpgestiondesinscriptionsuniversitaires.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.dto.EnrollmentDTO;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Enrollments;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.service.IEnrollmentService;
import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService enrollmentService;

    // POST /enrollments
    @PostMapping
    public ResponseEntity<?> enroll(@RequestBody EnrollmentDTO dto) {
        try {
            return ResponseEntity.ok(enrollmentService.enrollStudent(dto));
        } catch (RuntimeException e) {
            // الميساج متاع "Refus: Le cours est complet !" يرجع هنا
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // GET /enrollments
    @GetMapping
    public List<Enrollments> getAll() {
        return enrollmentService.getAllEnrollments();
    }

    // GET /enrollments/student/{id}
    @GetMapping("/student/{id}")
    public List<Enrollments> getByStudent(@PathVariable Long id) {
        return enrollmentService.getEnrollmentsByStudent(id);
    }

    // GET /enrollments/course/{id}
    @GetMapping("/course/{id}")
    public List<Enrollments> getByCourse(@PathVariable Long id) {
        return enrollmentService.getEnrollmentsByCourse(id);
    }
}