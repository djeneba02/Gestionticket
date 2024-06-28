package com.gestion.gestion.Repository;

import com.gestion.gestion.model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
    Apprenant findByEmail(String email);
}
