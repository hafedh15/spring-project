package tn.esprit.tpgestiondesinscriptionsuniversitaires;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TpGestionDesInscriptionsUniversitairesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpGestionDesInscriptionsUniversitairesApplication.class, args);
    }

}
