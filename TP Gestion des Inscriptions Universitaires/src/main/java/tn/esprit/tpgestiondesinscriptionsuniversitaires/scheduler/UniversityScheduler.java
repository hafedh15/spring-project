package tn.esprit.tpgestiondesinscriptionsuniversitaires.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.entity.Enrollments;
import tn.esprit.tpgestiondesinscriptionsuniversitaires.repository.EnrollmentRepository;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j // باش نستعملو log.info في الـ console
public class UniversityScheduler {

    private final EnrollmentRepository enrollmentRepository;

    // Tâche 1 : Désactivation (Chaque jour à 00:00)
    // "0 0 0 * * *" تعني: ثانية 0، دقيقة 0، ساعة 0 (نص ليل)
    @Scheduled(cron = "0 0 0 * * *")
    public void deactivateOldEnrollments() {
        List<Enrollments> activeInscriptions = enrollmentRepository.findByActiveTrue();

        for (Enrollments e : activeInscriptions) {
            // نثبتو إذا فات عليها 365 يوم
            if (e.getEnrollmentDate().isBefore(LocalDate.now().minusDays(365))) {
                e.setActive(false);
                enrollmentRepository.save(e);
                log.info("L'inscription ID " + e.getId() + " a été désactivée (Ancienneté > 1 an)");
            }
        }
    }

    // Tâche 2 : Rapport journalier (Chaque jour à 23:00)
    // "0 0 23 * * *" تعني: ثانية 0، دقيقة 0، ساعة 23
    @Scheduled(cron = "0 0 23 * * *")
    public void dailyReport() {
        long count = enrollmentRepository.countByActiveTrue();
        System.out.println("---------- RAPPORT JOURNALIER ----------");
        System.out.println("Nombre d'inscriptions actives : " + count);
        System.out.println("----------------------------------------");
    }
}