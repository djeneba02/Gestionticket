package com.gestion.gestion.model;

import jakarta.persistence.*;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "apprenant")
public class Apprenant extends Utilisateur {
    // Propriétés spécifiques aux apprenants
    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;

    }


