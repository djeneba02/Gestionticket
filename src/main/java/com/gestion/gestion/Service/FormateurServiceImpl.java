package com.gestion.gestion.Service;


import com.gestion.gestion.model.Apprenant;
import com.gestion.gestion.model.Formateur;
import com.gestion.gestion.Repository.FormateurRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class FormateurServiceImpl implements FormateurService {

    private final FormateurRepository formateurRepository;

    @Autowired
    public FormateurServiceImpl(FormateurRepository formateurRepository) {
        this.formateurRepository = formateurRepository;
    }

    @Override
    public Formateur créerFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    @Override
    public List<Formateur> getAllFormateurs() {
        return formateurRepository.findAll();
    }

    @Override
    public Formateur getFormateurById(Long formateurId) {
        Optional<Formateur> formateur = formateurRepository.findById(formateurId);
        return formateur.orElse(null);
    }

    @Override
    public Formateur updateFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    @Override
    public void supprimerFormateur(Long formateurId) {
        formateurRepository.deleteById(formateurId);
    }

    @Override
    public void ajouterApprenant(Long formateurId, Apprenant apprenant) {
        Formateur formateur = getFormateurById(formateurId);
        if (formateur != null) {
            apprenant.setFormateur(formateur);
            formateur.getApprenants().add(apprenant);
            formateurRepository.save(formateur);
        }
    }

    @Override
    public void supprimerApprenant(Long formateurId, Long apprenantId) {
        Formateur formateur = getFormateurById(formateurId);
        if (formateur != null) {
            formateur.getApprenants().removeIf(apprenant -> apprenant.getId().equals(apprenantId));
            formateurRepository.save(formateur);
        }
    }

    @Override
    public List<Apprenant> getAllApprenants(Long formateurId) {
        Formateur formateur = getFormateurById(formateurId);
        if (formateur != null) {
            return formateur.getApprenants();
        }
        return null;
    }

    @Override
    public Apprenant getApprenantById(Long formateurId, Long apprenantId) {
        List<Apprenant> apprenants = getAllApprenants(formateurId);
        if (apprenants != null) {
            for (Apprenant apprenant : apprenants) {
                if (apprenant.getId().equals(apprenantId)) {
                    return apprenant;
                }
            }
        }
        return null;
    }

    @Override
    public void modifierApprenant(Long formateurId, Apprenant apprenant) {
        Formateur formateur = getFormateurById(formateurId);
        if (formateur != null) {
            for (Apprenant existingApprenant : formateur.getApprenants()) {
                if (existingApprenant.getId().equals(apprenant.getId())) {
                    existingApprenant.setNom(apprenant.getNom());
                    existingApprenant.setPrenom(apprenant.getPrenom());
                    existingApprenant.setEmail(apprenant.getEmail());
                    // Enregistrer les modifications
                    formateurRepository.save(formateur);
                    break;
                }
            }

        }
    }
}