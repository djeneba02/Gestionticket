package com.gestion.gestion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "admin")
public class Admin extends Utilisateur {

    // Relation One-to-Many avec Formateur
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Formateur> formateurs;
}
