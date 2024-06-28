package com.gestion.gestion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
    private List<Apprenant> apprenants ;

    @JsonIgnore
    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
    private List<Traitement> traitements;
    }

