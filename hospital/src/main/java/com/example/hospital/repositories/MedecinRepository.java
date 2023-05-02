package com.example.hospital.repositories;

import com.example.hospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data
//terminer mapping objet relationnel
public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);
}
