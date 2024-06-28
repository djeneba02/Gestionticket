package com.gestion.gestion.Service;


import com.gestion.gestion.Repository.ApprenantRepository;
import com.gestion.gestion.model.Apprenant;
import com.gestion.gestion.model.Formateur;
import com.gestion.gestion.Repository.FormateurRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Data
public class FormateurServiceImpl implements FormateurService {

    private final FormateurRepository formateurRepository;
    private final ApprenantRepository apprenantRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Apprenant createApprenant(Apprenant apprenant) {
        apprenant.setPassword(passwordEncoder.encode(apprenant.getPassword()));
        return apprenantRepository.save(apprenant);

    }

    @Override
    public Apprenant getApprenantById(Long apprenantId) {
        return apprenantRepository.findById(apprenantId)
                .orElseThrow(() -> new IllegalArgumentException("Apprenant non trouvé avec l'ID : " + apprenantId));
    }

    @Override
    public Apprenant updateApprenant(Long id, Apprenant apprenant) {
        return apprenantRepository.findById(id)
                .map(a->{
                    a.setNom(apprenant.getNom());
                    a.setPrenom(apprenant.getPrenom());
                    a.setEmail(apprenant.getEmail());
                    a.setRole(apprenant.getRole());
                    return apprenantRepository.save(a);
                }).orElseThrow(() -> new RuntimeException("Apprenant non trouver !" ));

    }

    @Override
    public void deleteApprenant(Long id) {
        apprenantRepository.deleteById(id);

    }



    @Override
    public List<Apprenant> getAllApprenants() {
        return apprenantRepository.findAll();
    }
}