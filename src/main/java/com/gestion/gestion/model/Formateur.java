package com.gestion.gestion.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "formateur")
public class Formateur extends Utilisateur {

    // Relation Many-to-One avec Admin
    @ManyToOne
    @JoinColumn(name = "admin_id") // Nom de la colonne de la clé étrangère dans la table formateur
    private Admin admin;
    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Apprenant> apprenants = new ArrayList<>();

    }

