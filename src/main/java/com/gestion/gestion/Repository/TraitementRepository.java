package com.gestion.gestion.Repository;

import com.gestion.gestion.model.Traitement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface TraitementRepository extends JpaRepository<Traitement, Long> {
    //Optional<Traitement> findByEmail(String email);


}
