package com.gestion.gestion.Repository;

import com.gestion.gestion.model.Admin;
import com.gestion.gestion.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
