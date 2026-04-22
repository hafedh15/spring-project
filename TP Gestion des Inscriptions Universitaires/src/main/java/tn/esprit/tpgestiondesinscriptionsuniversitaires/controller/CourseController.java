package tn.esprit.tpgestiondesinscriptionsuniversitaires.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.dto.CourseDTO;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Courses;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.service.ICourseService;

import java.util.List;

@RestController
@RequestMapping("/api/courses") // هذا الـ Path الأساسي
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService courseService;

    // POST /courses
    @PostMapping
    public Courses addCourse(@Valid @RequestBody CourseDTO dto) {
        return courseService.addCourse(dto);
    }

    // GET /courses
    @GetMapping
    public List<Courses> getAll() {
        return courseService.getAllCourses();
    }

    // GET /courses/full (الـ JPQL Query)
    @GetMapping("/full")
    public List<Courses> getFullCourses() {
        return courseService.getFullCourses();
    }
}