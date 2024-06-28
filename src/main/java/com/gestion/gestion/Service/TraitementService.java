package com.gestion.gestion.Service;

import com.gestion.gestion.model.Traitement;

import java.util.List;

public interface TraitementService {
    Traitement createTraitement(Traitement traitement);
    Traitement getTraitementById(Long id);

    Traitement updateTraitement(Long id, Traitement traitement);

    void deleteTraitement(Long id);

    List<Traitement> getAllTraitement();
}
