package com.gestion.gestion.Service;

import com.gestion.gestion.model.Admin;
import com.gestion.gestion.model.Formateur;
import com.gestion.gestion.Repository.AdminRepository;
import com.gestion.gestion.Repository.FormateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final FormateurRepository formateurRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, FormateurRepository formateurRepository) {
        this.adminRepository = adminRepository;
        this.formateurRepository = formateurRepository;
    }

    @Override
    public Formateur créerFormateur(Formateur formateur) {
        // Créer un nouveau formateur
        return formateurRepository.save(formateur);
    }

    @Override
    public void ajouterFormateur(Admin admin, Formateur formateur) {
        // Ajout d'un formateur par l'admin
        admin.getFormateurs().add(formateur);
        adminRepository.save(admin);
    }

    @Override
    public void supprimerFormateur(Long formateurId) {
        Optional<Formateur> formateurOptional = formateurRepository.findById(formateurId);
        formateurOptional.ifPresent(formateur -> {
            Admin admin = new Admin();
            admin.getFormateurs().remove(formateur);
            formateurRepository.delete(formateur);
            adminRepository.save(admin);
        });
    }

    @Override
    public void modifierFormateur(Formateur formateur) {
        // Mise à jour d'un formateur par l'admin
        formateurRepository.save(formateur);
    }

    @Override
    public List<Formateur> getAllFormateurs() {
        // Récupérer tous les formateurs
        return formateurRepository.findAll();
    }

    @Override
    public Formateur getFormateurById(Long formateurId) {
        // Récupérer un formateur par son ID
        Optional<Formateur> formateurOptional = formateurRepository.findById(formateurId);
        return formateurOptional.orElse(null);
    }
}
