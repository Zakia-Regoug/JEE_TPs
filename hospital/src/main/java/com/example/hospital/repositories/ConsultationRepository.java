package com.example.hospital.repositories;

import com.example.hospital.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data
//terminer mapping objet relationnel
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
