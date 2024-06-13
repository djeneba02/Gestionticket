package com.gestion.gestion.Service;



import com.gestion.gestion.model.Apprenant;
import com.gestion.gestion.model.Formateur;

import java.util.List;

public interface FormateurService {

    Formateur créerFormateur(Formateur formateur);

    List<Formateur> getAllFormateurs();

    Formateur getFormateurById(Long formateurId);

    Formateur updateFormateur(Formateur formateur);

    void supprimerFormateur(Long formateurId);

    void ajouterApprenant(Long formateurId, Apprenant apprenant);

    void supprimerApprenant(Long formateurId, Long apprenantId);

    List<Apprenant> getAllApprenants(Long formateurId);

    void modifierApprenant(Long formateurId, Apprenant apprenant);

    Apprenant getApprenantById(Long formateurId, Long apprenantId);
}
