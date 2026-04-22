package tn.esprit.tpgestiondesinscriptionsuniversitaires.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.dto.StudentDTO;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Students;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.mapper.StudentMapper;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public Students addStudent(StudentDTO dto) {
        // نحولو الـ DTO لـ Entity باستعمال المابّر اللي صنعناه
        Students student = studentMapper.toEntity(dto);
        return studentRepository.save(student);
    }

    @Override
    public Students updateStudent(Long id, StudentDTO dto) {
        Students existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        existingStudent.setFirstName(dto.getFirstName());
        existingStudent.setLastName(dto.getLastName());
        existingStudent.setEmail(dto.getEmail());

        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Students getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Students> findByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    @Override
    public List<Students> searchByEmail(String keyword) {
        return studentRepository.findByEmailContaining(keyword);
    }
    @Override
    public Page<Students> getAllStudentsPaged(int page, int size) {
        return studentRepository.findAll(PageRequest.of(page, size));
    }
}