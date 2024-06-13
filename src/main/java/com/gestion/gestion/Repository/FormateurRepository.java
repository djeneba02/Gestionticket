package com.gestion.gestion.Repository;

import com.gestion.gestion.model.Admin;
import com.gestion.gestion.model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
}
