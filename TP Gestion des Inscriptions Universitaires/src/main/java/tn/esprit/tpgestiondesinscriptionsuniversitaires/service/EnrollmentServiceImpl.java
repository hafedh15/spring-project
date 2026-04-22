package tn.esprit.tpgestiondesinscriptionsuniversitaires.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.dto.EnrollmentDTO;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Courses;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Enrollments;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Students;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.repository.CourseRepository;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.repository.EnrollmentRepository;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.repository.StudentRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements IEnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public Enrollments enrollStudent(EnrollmentDTO dto) {
        // 1. نجيبوا الطالب والكورس مالـ Database
        Students student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found!"));

        Courses course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found!"));

        // 2. نحسبوا قداش من واحد مسجل "Active" في الكورس هذا توا
        long currentCount = enrollmentRepository.countByCourseIdAndActiveTrue(dto.getCourseId());

        // 3. نطبقوا الـ Rule: إذا فات الـ Capacity نخرجو Exception
        if (currentCount >= course.getCapacity()) {
            throw new RuntimeException("Refus: Le cours " + course.getTitle() + " est complet !");
        }

        // 4. إذا مريڨل، نصنعوا الـ Enrollment ونرجيستريوه
        Enrollments enrollment = new Enrollments();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDate.now());
        enrollment.setActive(true);

        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollments> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public List<Enrollments> getEnrollmentsByStudent(Long studentId) {
        // مريڨلة توة
        return enrollmentRepository.findByStudentId(studentId);
    }

    @Override
    public List<Enrollments> getEnrollmentsByCourse(Long courseId) {
        // مريڨلة توة
        return enrollmentRepository.findByCourseId(courseId);
    }

}