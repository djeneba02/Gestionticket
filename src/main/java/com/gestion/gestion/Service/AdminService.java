package com.gestion.gestion.Service;

import com.gestion.gestion.model.Admin;
import com.gestion.gestion.model.Formateur;

import java.util.List;

public interface AdminService {

    // Méthode pour créer un nouveau formateur par un admin
    Formateur créerFormateur(Formateur formateur);

    // Méthode pour ajouter un formateur par un admin
    void ajouterFormateur(Admin admin, Formateur formateur);

    // Méthode pour supprimer un formateur par un admin en utilisant l'ID du formateur
    void supprimerFormateur(Long formateurId);

    // Méthode pour mettre à jour un formateur par un admin
    void modifierFormateur(Formateur formateur);

    // Méthode pour récupérer tous les formateurs
    List<Formateur> getAllFormateurs();

    // Méthode pour récupérer un formateur par son ID
    Formateur getFormateurById(Long formateurId);
}
