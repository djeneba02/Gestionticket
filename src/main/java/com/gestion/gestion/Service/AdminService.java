package com.gestion.gestion.Service;

import com.gestion.gestion.model.Admin;
import com.gestion.gestion.model.Formateur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    Formateur createFormateur(Formateur formateur);

    Formateur getFormateurById(Long id);

    Formateur updateFormateur(Long id, Formateur formateurDetails);

    void deleteFormateur(Long id);

    List<Formateur> getAllFormateur();


    Admin createAdmin(Admin admin);

    Admin getAdminById(Long id);

    Admin updateAdmin(Long id, Admin adminDetails);

    void deleteAdmin(Long id);

    List<Admin> getAllAdmin();
}
