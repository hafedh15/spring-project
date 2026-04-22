package tn.esprit.tpgestiondesinscriptionsuniversitaires.service;

import org.springframework.data.domain.Page;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.dto.StudentDTO;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Students;
import java.util.List;

public interface IStudentService {
    Students addStudent(StudentDTO dto);
    Students updateStudent(Long id, StudentDTO dto);
    void deleteStudent(Long id);
    Students getStudentById(Long id);
    List<Students> getAllStudents();
    List<Students> findByLastName(String lastName);
    List<Students> searchByEmail(String keyword);
    Page<Students> getAllStudentsPaged(int page, int size);
}