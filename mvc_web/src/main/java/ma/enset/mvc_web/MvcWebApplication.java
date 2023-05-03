package ma.enset.mvc_web;

import ma.enset.mvc_web.entities.Patient;
import ma.enset.mvc_web.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class MvcWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcWebApplication.class, args);
    }
   @Bean
    CommandLineRunner start(PatientRepository patientRepository){
        return args->{
          /*  patientRepository.save(new Patient(null,"Chahira",new Date(),false,25));
            patientRepository.save(new Patient(null,"Ahmed",new Date(),false,33));
            patientRepository.save(new Patient(null,"Chihab",new Date(),false,76));
            patientRepository.save(new Patient(null,"Anas",new Date(),false,19));*/

            patientRepository.findAll().forEach(patient -> {
                System.out.println(patient.getNom());
            });
        };
    }
}
