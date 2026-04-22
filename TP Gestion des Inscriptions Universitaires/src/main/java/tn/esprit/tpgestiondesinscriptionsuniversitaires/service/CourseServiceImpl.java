package tn.esprit.tpgestiondesinscriptionsuniversitaires.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.dto.CourseDTO;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Courses;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.mapper.CourseMapper;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.repository.CourseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public Courses addCourse(CourseDTO dto) {
        return courseRepository.save(courseMapper.toEntity(dto));
    }

    @Override
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Courses> getFullCourses() {

        return courseRepository.findFullCourses(); // تنادي للـ JPQL اللي كتبناه
    }
}