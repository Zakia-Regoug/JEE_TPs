package com.example.hospital.repositories;

import com.example.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data
//terminer mapping objet relationnel
public interface RendezVousRepository extends JpaRepository<RendezVous, String> {

}
