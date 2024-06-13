package com.gestion.gestion.Controller;

import com.gestion.gestion.model.Admin;
import com.gestion.gestion.model.Formateur;
import com.gestion.gestion.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Endpoint pour créer un formateur
    @PostMapping("/formateurs")
    public ResponseEntity<Formateur> créerFormateur(@RequestBody Formateur formateur) {
        Formateur nouveauFormateur = adminService.créerFormateur(formateur);
        return new ResponseEntity<>(nouveauFormateur, HttpStatus.CREATED);
    }

    // Endpoint pour récupérer tous les formateurs
    @GetMapping("/formateurs")
    public ResponseEntity<List<Formateur>> getAllFormateurs() {
        List<Formateur> formateurs = adminService.getAllFormateurs();
        return new ResponseEntity<>(formateurs, HttpStatus.OK);
    }

    // Endpoint pour récupérer un formateur par son ID
    @GetMapping("/formateurs/{formateurId}")
    public ResponseEntity<Formateur> getFormateurById(@PathVariable Long formateurId) {
        Formateur formateur = adminService.getFormateurById(formateurId);
        if (formateur != null) {
            return new ResponseEntity<>(formateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour mettre à jour un formateur
    @PutMapping("/formateurs/{formateurId}")
    public ResponseEntity<Formateur> updateFormateur(@PathVariable Long formateurId, @RequestBody Formateur formateur) {
        formateur.setId(formateurId); // Assure que l'ID dans le chemin correspond à celui du formateur
        adminService.modifierFormateur(formateur);
        return new ResponseEntity<>(formateur, HttpStatus.OK);
    }

    // Endpoint pour supprimer un formateur par son ID
    @DeleteMapping("/formateurs/{formateurId}")
    public ResponseEntity<Void> deleteFormateur(@PathVariable Long formateurId) {
        adminService.supprimerFormateur(formateurId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
