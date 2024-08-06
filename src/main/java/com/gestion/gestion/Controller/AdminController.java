package com.gestion.gestion.Controller;

import com.gestion.gestion.Service.AdminService;
import com.gestion.gestion.Service.AdminServiceImpl;
import com.gestion.gestion.model.Admin;
import com.gestion.gestion.model.Formateur;
import com.gestion.gestion.Service.FormateurService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Api admin", description = "Cet api permet de gérer le crud de l'admin et du formateur ")
@RestController
@RequestMapping("/api/admin")
@Data
public class AdminController {

    @Autowired
    FormateurService formateurService;

   @Autowired
    AdminService adminService;



    @Operation(summary = "CreateAdmin", description = "Permet créer un admin")

    //@PreAuthorize("hasRole('ADMIN') or hasRole('ADMIN')")
    @PostMapping("/createadmin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.createAdmin(admin);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }


    @Operation(summary = "CreateFormateur", description = "Permet créer un formateur")


    @PostMapping("/createformateur")
    public ResponseEntity<Formateur> createFormateur(@RequestBody Formateur formateur) {
        Formateur createdFormateur = adminService.createFormateur(formateur);
        return new ResponseEntity<>(createdFormateur, HttpStatus.CREATED);
    }


    @Operation(summary = "rechercheAdmin", description = "Permet de recupére un admin par id")

    @GetMapping("/{id}admin")
    public ResponseEntity<Admin> getAdmin(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @Operation(summary = "rechercheFormateur", description = "Permet de recupére un formateur par id")

    @GetMapping("/{id}formateur")
    public ResponseEntity<Formateur> getFormateur(@PathVariable Long id) {
        Formateur formateur = adminService.getFormateurById(id);
        return new ResponseEntity<>(formateur, HttpStatus.OK);
    }


    @Operation(summary = "modifierAdmin", description = "Permet de modifier un admin par son id")

    @PutMapping("/update/{id}admin")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        Admin updatedAdmin = adminService.updateAdmin(id, adminDetails);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
    }


    @Operation(summary = "modifierFormateur", description = "Permet de modifier un formateur par son id")

    @PutMapping("/update/{id}formateur")
    public ResponseEntity<Formateur> updateFormateur(@PathVariable Long id, @RequestBody Formateur formateurDetails) {
        Formateur updatedFormateur = adminService.updateFormateur(id, formateurDetails);
        return new ResponseEntity<>(updatedFormateur, HttpStatus.OK);
    }


    @Operation(summary = "supprimerAdmin", description = "Permet de supprimer un admin par son id")

    @DeleteMapping("/delete/admin/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @Operation(summary = "supprimerFormateur", description = "Permet de supprimer un formateur par son id")

    @DeleteMapping("/delete/formateur/{id}")
    public ResponseEntity<Void> deleteFormateur(@PathVariable Long id) {
        adminService.deleteFormateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @Operation(summary = "listeAdmin", description = "Permet de voir tout les Admin")

    @GetMapping("/alladmin")
    public ResponseEntity<List<Admin>> getAllAdmin() {
        List<Admin> admins = adminService.getAllAdmin();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }
    @Operation(summary = "listeformateur", description = "Permet de voir tout les Formateur")

    @GetMapping("/allformateur")  // L'annotation pour l'endpoint spécifique
    public ResponseEntity<List<Formateur>> getAllFormateur() {
        List<Formateur> formateurs = adminService.getAllFormateur();
        return new ResponseEntity<>(formateurs, HttpStatus.OK);
    }
}
