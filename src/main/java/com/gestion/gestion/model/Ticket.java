package com.gestion.gestion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.gestion.Enum.Categorie;
import com.gestion.gestion.Enum.Priorite;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

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

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    private Apprenant apprenant;

    @Enumerated(EnumType.STRING)
    private Priorite priorite;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    @Enumerated(EnumType.STRING)
    private com.gestion.gestion.Enum.Statut Statut;

    @JsonIgnore
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<Traitement> traitements;

}
