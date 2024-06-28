package com.gestion.gestion.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "basedeconnaissance ")
public class BaseDeConnaissance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private  String reponse;
    @Column(length = 50)
    private String imageURL;

    private String documentURL;
    @Column(length = 50)
    private String lienURL;
}
