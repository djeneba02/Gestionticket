package com.gestion.gestion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "apprenant")
public class Apprenant extends Utilisateur {

    // Propriétés spécifiques aux apprenants
    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;

    @JsonIgnore
    @OneToMany(mappedBy = "apprenant", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
    // Constructeurs, getters et setters hérités de la classe Utilisateur
}


