package com.gestion.gestion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.gestion.Enum.Categorie;
import com.gestion.gestion.Enum.Priorite;
<<<<<<< HEAD
import com.gestion.gestion.Enum.Statut;
=======
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
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
<<<<<<< HEAD

    private LocalDate responseDate;
=======
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5

    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    private Apprenant apprenant;

    @Enumerated(EnumType.STRING)
    private Priorite priorite;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

<<<<<<< HEAD
    //@Enumerated(EnumType.STRING)
    private Statut statut;
=======
    @Enumerated(EnumType.STRING)
    private com.gestion.gestion.Enum.Statut Statut;
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5

    @JsonIgnore
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<Traitement> traitements;

}
