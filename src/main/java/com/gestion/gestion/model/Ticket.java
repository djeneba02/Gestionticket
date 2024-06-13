package com.gestion.gestion.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String statut; // Par exemple: "Libre", "Pris"

    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    private Apprenant apprenant;
    @Enumerated(EnumType.STRING)
    private Priorite priorite;
}
