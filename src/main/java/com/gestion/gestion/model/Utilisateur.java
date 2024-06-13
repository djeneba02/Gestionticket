package com.gestion.gestion.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String prenom;

    @Column(length = 50, unique = true)
    private String email;

   @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private Role role;

    public enum Role {
        ADMIN,
        FORMATEUR,
        APPRENANT
    }
}