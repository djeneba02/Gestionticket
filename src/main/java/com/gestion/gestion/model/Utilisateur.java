package com.gestion.gestion.model;

import com.gestion.gestion.Enum.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)

@Table(name = "utilisateur")
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

    @Column(length = 100) // Longueur du champ à ajuster selon vos besoins
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;



}