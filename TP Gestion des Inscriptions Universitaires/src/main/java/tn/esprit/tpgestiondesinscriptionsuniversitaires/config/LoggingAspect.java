package tn.esprit.tpgestiondesinscriptionsuniversitaires.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    // تخدم قبل كل ميثود في الـ Service
    @Before("execution(* tn.esprit.tpgestiondesinscriptionsuniversitaires.service.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        log.info("Début exécution de la méthode : " + joinPoint.getSignature().getName());
    }
}