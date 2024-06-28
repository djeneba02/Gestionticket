package com.gestion.gestion.Service;



import com.gestion.gestion.model.Apprenant;
import com.gestion.gestion.model.Formateur;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FormateurService {



    Apprenant createApprenant(Apprenant apprenant);

    Apprenant getApprenantById(Long id);

    Apprenant updateApprenant(Long id, Apprenant apprenantDetails);

    void deleteApprenant(Long id);

    List<Apprenant> getAllApprenants();
}
