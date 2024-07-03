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



<<<<<<< HEAD
    @Operation(summary = "CreateAdmin", description = "Permet créer un admin")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    //@PreAuthorize("hasRole('ADMIN') or hasRole('ADMIN')")
    @PostMapping("/createadmin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.createAdmin(admin);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

<<<<<<< HEAD
    @Operation(summary = "CreateFormateur", description = "Permet créer un formateur")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    @PostMapping("/createformateur")
    public ResponseEntity<Formateur> createFormateur(@RequestBody Formateur formateur) {
        Formateur createdFormateur = adminService.createFormateur(formateur);
        return new ResponseEntity<>(createdFormateur, HttpStatus.CREATED);
    }

<<<<<<< HEAD
    @Operation(summary = "rechercheAdmin", description = "Permet de recupére un admin par id")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    @GetMapping("/{id}admin")
    public ResponseEntity<Admin> getAdmin(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

<<<<<<< HEAD
    @Operation(summary = "rechercheFormateur", description = "Permet de recupére un formateur par id")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    @GetMapping("/{id}formateur")
    public ResponseEntity<Formateur> getFormateur(@PathVariable Long id) {
        Formateur formateur = adminService.getFormateurById(id);
        return new ResponseEntity<>(formateur, HttpStatus.OK);
    }

<<<<<<< HEAD
    @Operation(summary = "modifierAdmin", description = "Permet de modifier un admin par son id")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    @PutMapping("/update/{id}admin")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        Admin updatedAdmin = adminService.updateAdmin(id, adminDetails);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
    }

<<<<<<< HEAD
    @Operation(summary = "modifierFormateur", description = "Permet de modifier un formateur par son id")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    @PutMapping("/update/{id}formateur")
    public ResponseEntity<Formateur> updateFormateur(@PathVariable Long id, @RequestBody Formateur formateurDetails) {
        Formateur updatedFormateur = adminService.updateFormateur(id, formateurDetails);
        return new ResponseEntity<>(updatedFormateur, HttpStatus.OK);
    }

<<<<<<< HEAD
    @Operation(summary = "supprimerAdmin", description = "Permet de supprimer un admin par son id")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    @DeleteMapping("/delete/{id}admin")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

<<<<<<< HEAD
    @Operation(summary = "supprimerFormateur", description = "Permet de supprimer un formateur par son id")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    @DeleteMapping("/delete/{id}formateur")
    public ResponseEntity<Void> deleteFormateur(@PathVariable Long id) {
        adminService.deleteFormateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

<<<<<<< HEAD
    @Operation(summary = "listeAdmin", description = "Permet de voir tout les Admin")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    @GetMapping("/alladmin")
    public ResponseEntity<List<Admin>> getAllAdmin() {
        List<Admin> admins = adminService.getAllAdmin();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

<<<<<<< HEAD
    @Operation(summary = "listeformateur", description = "Permet de voir tout les Formateur")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    @GetMapping("/allformateur")  // L'annotation pour l'endpoint spécifique
    public ResponseEntity<List<Formateur>> getAllFormateur() {
        List<Formateur> formateurs = adminService.getAllFormateur();
        return new ResponseEntity<>(formateurs, HttpStatus.OK);
    }
}
