package com.gestion.gestion.Repository;

import com.gestion.gestion.model.BaseDeConnaissance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseDeConnaissanceRepository extends JpaRepository<BaseDeConnaissance, Long> {
    // Vous pouvez ajouter des méthodes spécifiques de requête ici si nécessaire
}

