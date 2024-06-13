package com.gestion.gestion.Controller;


import com.gestion.gestion.model.Apprenant;
import com.gestion.gestion.model.Formateur;
import com.gestion.gestion.Service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formateurs")
public class FormateurController {

    private final FormateurService formateurService;

    @Autowired
    public FormateurController(FormateurService formateurService) {
        this.formateurService = formateurService;
    }

    // Endpoint pour ajouter un apprenant à un formateur
    @PostMapping("/{formateurId}/apprenants")
    public ResponseEntity<Apprenant> ajouterApprenant(@PathVariable Long formateurId, @RequestBody Apprenant apprenant) {
        formateurService.ajouterApprenant(formateurId, apprenant);
        return new ResponseEntity<>(apprenant, HttpStatus.CREATED);
    }

    // Endpoint pour supprimer un apprenant d'un formateur
    @DeleteMapping("/{formateurId}/apprenants/{apprenantId}")
    public ResponseEntity<Void> supprimerApprenant(@PathVariable Long formateurId, @PathVariable Long apprenantId) {
        formateurService.supprimerApprenant(formateurId, apprenantId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint pour récupérer tous les apprenants d'un formateur
    @GetMapping("/{formateurId}/apprenants")
    public ResponseEntity<List<Apprenant>> getAllApprenants(@PathVariable Long formateurId) {
        List<Apprenant> apprenants = formateurService.getAllApprenants(formateurId);
        return new ResponseEntity<>(apprenants, HttpStatus.OK);
    }

    // Endpoint pour récupérer un apprenant par son ID d'un formateur
    @GetMapping("/{formateurId}/apprenants/{apprenantId}")
    public ResponseEntity<Apprenant> getApprenantById(@PathVariable Long formateurId, @PathVariable Long apprenantId) {
        Apprenant apprenant = formateurService.getApprenantById(formateurId, apprenantId);
        if (apprenant != null) {
            return new ResponseEntity<>(apprenant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{formateurId}/apprenants/{apprenantId}")
    public ResponseEntity<Void> modifierApprenant(@PathVariable Long formateurId, @PathVariable Long apprenantId, @RequestBody Apprenant apprenant) {
        formateurService.modifierApprenant(formateurId, apprenant);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

