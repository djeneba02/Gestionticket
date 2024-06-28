package com.gestion.gestion.Repository;

import com.gestion.gestion.model.Admin;
import com.gestion.gestion.model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {

    Formateur findByEmail(String emailformateur);
}
