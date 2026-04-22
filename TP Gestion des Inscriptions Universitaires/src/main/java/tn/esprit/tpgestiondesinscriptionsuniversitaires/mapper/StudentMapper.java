package tn.esprit.tpgestiondesinscriptionsuniversitaires.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.dto.StudentDTO;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Students;

import java.time.LocalDate;

@Component
public class StudentMapper {

    public Students toEntity(StudentDTO dto) {
        Students s = new Students();
        s.setFirstName(dto.getFirstName());
        s.setLastName(dto.getLastName());
        s.setEmail(dto.getEmail());
        s.setRegistrationDate(LocalDate.now());
        return s;
    }

    public StudentDTO toDto(Students entity) {
        StudentDTO dto = new StudentDTO();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        return dto;
    }
}