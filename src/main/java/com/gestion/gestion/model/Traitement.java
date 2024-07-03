package com.gestion.gestion.model;

import jakarta.persistence.*;
import lombok.Data;

<<<<<<< HEAD
import java.time.LocalDate;
import java.time.LocalDateTime;

=======
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
@Entity
@Data
@Table(name = "traitement")
public class Traitement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String reponse;

<<<<<<< HEAD
    private String response;
    private LocalDate responseDate;

=======
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;
}
