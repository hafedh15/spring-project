package tn.esprit.tpgestiondesinscriptionsuniversitaires.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Courses;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long> {

    @Query("SELECT c FROM Courses c WHERE (SELECT COUNT(e) FROM Enrollments e WHERE e.course = c AND e.active = true) >= c.capacity")
    List<Courses> findFullCourses();
}