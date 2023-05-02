package com.example.hospital;

import com.example.hospital.entities.*;
import com.example.hospital.repositories.ConsultationRepository;
import com.example.hospital.repositories.MedecinRepository;
import com.example.hospital.repositories.PatientRepository;
import com.example.hospital.repositories.RendezVousRepository;
import com.example.hospital.service.IHospitalService;
import com.example.hospital.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, UserService userService){
        return args->{
           /* User u=new User();
            u.setUserName("user1");
            u.setPassword("123456");
            userService.addNewUser(u);

            User u2=new User();
            u2.setUserName("admin");
            u2.setPassword("123456");
            userService.addNewUser(u2);

            Stream.of("STUDENT","ADMIN","USER")
                    .forEach(r-> {
                                Role role1 = new Role();
                                role1.setRoleName(r);
                                userService.addNewRole(role1);
                            });
            userService.AddRoleToUser("user1","STUDENT");
            userService.AddRoleToUser("user1","USER");

            userService.AddRoleToUser("admin","ADMIN");
            userService.AddRoleToUser("admin","USER");

            try {
                User user=userService.authenticate("user1","123456");
                System.out.println(user.getUserId());
                System.out.println(user.getUserName());
                System.out.println("Roles => ");
                user.getRoles().forEach(r->{
                    System.out.println("Role=>"+r);
                });
            }catch (Exception e){
                e.printStackTrace();
            }*/

            Stream.of("Hidaya","Mohamed","Salah")
                    .forEach(name->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("Nour","Chahad","Asmae")
                    .forEach(name->{
                        Medecin medecin =new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(medecin);
                    });
            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("Hidaya");

            Medecin medecin=medecinRepository.findByNom("Chahad");

            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
             RendezVous saveDRDV=hospitalService.saveRDV(rendezVous);
            System.out.println(saveDRDV.getId());

            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation ......");
            hospitalService.saveConsultation(consultation);
        };
    }
}
