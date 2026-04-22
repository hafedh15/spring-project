package tn.esprit.tpgestiondesinscriptionsuniversitaires.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.dto.CourseDTO;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Courses;

@Component
public class CourseMapper {

    public Courses toEntity(CourseDTO dto) {
        Courses c = new Courses();
        c.setTitle(dto.getTitle());
        c.setCode(dto.getCode());
        c.setCapacity(dto.getCapacity());
        return c;
    }

    public CourseDTO toDto(Courses entity) {
        CourseDTO dto = new CourseDTO();
        dto.setTitle(entity.getTitle());
        dto.setCode(entity.getCode());
        dto.setCapacity(entity.getCapacity());
        return dto;
    }
}
