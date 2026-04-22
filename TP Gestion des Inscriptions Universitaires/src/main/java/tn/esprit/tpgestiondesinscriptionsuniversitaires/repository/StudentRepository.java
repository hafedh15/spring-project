package tn.esprit.tpgestiondesinscriptionsuniversitaires.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Students;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {

    List<Students> findByLastName(String lastName);

    List<Students> findByEmailContaining(String keyword);

}
