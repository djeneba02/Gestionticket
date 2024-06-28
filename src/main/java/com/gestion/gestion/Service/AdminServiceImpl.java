package com.gestion.gestion.Service;

import com.gestion.gestion.model.Admin;
import com.gestion.gestion.model.Formateur;
import com.gestion.gestion.Repository.AdminRepository;
import com.gestion.gestion.Repository.FormateurRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Data
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final FormateurRepository formateurRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Formateur createFormateur(Formateur formateur) {
        formateur.setPassword(passwordEncoder.encode(formateur.getPassword()));
        return formateurRepository.save(formateur);

    }


    @Override
    public Formateur getFormateurById(Long formateurId) {
        return formateurRepository.findById(formateurId)
                .orElseThrow(() -> new IllegalArgumentException("Formateur non trouvé avec l'ID : " + formateurId));
    }

    @Override
    public Formateur updateFormateur(Long id, Formateur formateur) {
        return formateurRepository.findById(id)
                .map(f->{
                    f.setNom(formateur.getNom());
                    f.setPrenom(formateur.getPrenom());
                    f.setEmail(formateur.getEmail());
                    f.setRole(formateur.getRole());
                    return formateurRepository.save(f);
                }).orElseThrow(() -> new RuntimeException("Apprenant non trouver !" ));

    }

    @Override
    public void deleteFormateur(Long id) {
        formateurRepository.deleteById(id);

    }

    @Override
    public List<Formateur> getAllFormateur() {
        return formateurRepository.findAll();
    }



    @Override
    public Admin createAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));

        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Formateur non trouvé avec l'ID : " + id));
    }

    @Override
    public Admin updateAdmin(Long id, Admin admin) {
        return adminRepository.findById(id)
                .map(ad->{
                    ad.setNom(admin.getNom());
                    ad.setPrenom(admin.getPrenom());
                    ad.setEmail(admin.getEmail());
                    ad.setRole(admin.getRole());
                    return adminRepository.save(ad);
                }).orElseThrow(() -> new RuntimeException("Admin non trouver !" ));

    }

    @Override
    public void deleteAdmin(Long id) {

        adminRepository.deleteById(id);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

}
