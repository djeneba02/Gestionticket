package com.gestion.gestion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.gestion.Enum.Categorie;
import com.gestion.gestion.Enum.Priorite;
import com.gestion.gestion.Enum.Statut;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static java.time.LocalTime.now;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    private Date creatAt = new Date();

    private Date response_date;


    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    private Apprenant apprenant;

    @Enumerated(EnumType.STRING)
    private Priorite priorite;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;
    //@Enumerated(EnumType.STRING)
    
    @Enumerated(EnumType.STRING)
    private Statut statut;

    @JsonIgnore
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<Traitement> traitements;

    public void getStatut(com.gestion.gestion.Enum.Statut statut) {

    }

    public void setResponseDate(LocalDate now) {
    }
}
