package tn.esprit.tpgestiondesinscriptionsuniversitaires.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.dto.StudentDTO;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Students;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.service.IStudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    // 1. CREATE: POST /students
    @PostMapping
    public ResponseEntity<Students> addStudent(@Valid @RequestBody StudentDTO dto) {
        return ResponseEntity.ok(studentService.addStudent(dto));
    }

    // 2. READ (All): GET /students
    @GetMapping
    public List<Students> getAll() {
        return studentService.getAllStudents();
    }

    // 2. READ (One by ID): GET /students/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Students> getById(@PathVariable Long id) {
        Students s = studentService.getStudentById(id);
        return (s != null) ? ResponseEntity.ok(s) : ResponseEntity.notFound().build();
    }

    // 3. UPDATE: PUT /students/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Students> update(@PathVariable Long id, @Valid @RequestBody StudentDTO dto) {
        try {
            return ResponseEntity.ok(studentService.updateStudent(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 4. DELETE: DELETE /students/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    // --- Recherche (مطابق للـ Enoncé بالضبط) ---

    // GET /students/search?lastName=Doe
    @GetMapping("/search")
    public List<Students> getByLastName(@RequestParam String lastName) {
        return studentService.findByLastName(lastName);
    }

    // GET /students/search/email?keyword=gmail
    @GetMapping("/search/email")
    public List<Students> getByEmail(@RequestParam String keyword) {
        return studentService.searchByEmail(keyword);
    }
    @GetMapping("/paged")
    public ResponseEntity<Page<Students>> getAllPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(studentService.getAllStudentsPaged(page, size));
    }
}