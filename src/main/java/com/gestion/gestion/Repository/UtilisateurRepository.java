package com.gestion.gestion.Repository;

import com.gestion.gestion.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByNom(String nom);

    Utilisateur findByEmail(String email);
}
