package tn.esprit.tpgestiondesinscriptionsuniversitaires.service;

import tn.esprit.tpgestiondesinscriptionsuniversitaires.dto.CourseDTO;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Courses;

import java.util.List;

public interface ICourseService {
        Courses addCourse(CourseDTO dto);
        List<Courses> getAllCourses();
        List<Courses> getFullCourses(); // هذي اللي طالبينها JPQL
    }

