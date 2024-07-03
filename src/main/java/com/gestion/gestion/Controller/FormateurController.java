package com.gestion.gestion.Controller;


import com.gestion.gestion.Service.ApprenantService;
import com.gestion.gestion.Service.BaseDeConnaissanceService;
import com.gestion.gestion.model.Apprenant;
import com.gestion.gestion.model.BaseDeConnaissance;
import com.gestion.gestion.model.Formateur;
import com.gestion.gestion.Service.FormateurService;
import io.swagger.v3.oas.annotations.Operation;
<<<<<<< HEAD
import io.swagger.v3.oas.annotations.tags.Tag;
=======
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Data
<<<<<<< HEAD
@Tag(name = "Api formateur", description = "Cet api permet de gérer le crud Ticket ")

=======
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
@RequestMapping("/api/formateurs")
public class FormateurController {
    private final FormateurService formateurService;
    private final ApprenantService apprenantService;

<<<<<<< HEAD
    @Operation(summary = "CreateApprenant ", description = "Permet créer un Apprenant ")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5

    @PostMapping("/create")
    public ResponseEntity<Apprenant> createApprenant(@RequestBody Apprenant apprenant) {
        Apprenant createdApprenant = formateurService.createApprenant(apprenant);
        return new ResponseEntity<>(createdApprenant, HttpStatus.CREATED);
    }

<<<<<<< HEAD
    @Operation(summary = "rechercheApprenant ", description = "Permet de recupére un Apprenant par id")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5

    @GetMapping("/{id}")
    public ResponseEntity<Apprenant> getApprenant(@PathVariable Long id) {
        Apprenant apprenant = formateurService.getApprenantById(id);
        return new ResponseEntity<>(apprenant, HttpStatus.OK);
<<<<<<< HEAD
    }

    @Operation(summary = "modifierApprenant ", description = "Permet de modifier un Apprenant par son id")

    @PutMapping("/update/{id}")
    public ResponseEntity<Apprenant> updateApprenant(@PathVariable Long id, @RequestBody Apprenant apprenantDetails) {
        Apprenant updatedApprenant = formateurService.updateApprenant(id, apprenantDetails);
        return new ResponseEntity<>(updatedApprenant, HttpStatus.OK);
    }

    @Operation(summary = "supprimerApprenant ", description = "Permet de supprimer un Apprenant  par son id")
=======
    }

    @Operation(summary = "", description = "")

    @PutMapping("/update/{id}")
    public ResponseEntity<Apprenant> updateApprenant(@PathVariable Long id, @RequestBody Apprenant apprenantDetails) {
        Apprenant updatedApprenant = formateurService.updateApprenant(id, apprenantDetails);
        return new ResponseEntity<>(updatedApprenant, HttpStatus.OK);
    }

    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteApprenant(@PathVariable Long id) {
        formateurService.deleteApprenant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

<<<<<<< HEAD
    @Operation(summary = "listeApprenant", description = "Permet de voir tout les Apprenant ")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5

    @GetMapping("/all")
    public ResponseEntity<List<Apprenant>> getAllApprenants() {
        List<Apprenant> apprenants = formateurService.getAllApprenants();
        return new ResponseEntity<>(apprenants, HttpStatus.OK);
    }


    @Autowired
   private BaseDeConnaissanceService baseDeConnaissanceService;

<<<<<<< HEAD
    @Operation(summary = "listebasedeconnaissances ", description = "Permet de voir la basedeconnaissances ")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5

    @GetMapping("/basedeconnaissances")
    public ResponseEntity<List<BaseDeConnaissance>> getAllBaseDeConnaissances() {
        List<BaseDeConnaissance> baseDeConnaissances = baseDeConnaissanceService.getAllBaseDeConnaissances();
        return ResponseEntity.ok(baseDeConnaissances);
    }

<<<<<<< HEAD
    @Operation(summary = "recherchedansbasedeconnaissance ", description = "Permet de recupére une info dans la  basedeconnaissance par id")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5

    @GetMapping("/basedeconnaissances/{id}")
    public ResponseEntity<BaseDeConnaissance> getBaseDeConnaissanceById(@PathVariable("id") Long id) {
        Optional<BaseDeConnaissance> baseDeConnaissance = baseDeConnaissanceService.getBaseDeConnaissanceById(id);
        return baseDeConnaissance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

<<<<<<< HEAD
    @Operation(summary = "Createbasedeconnaissance ", description = "Permet créer une basedeconnaissance ")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5

    @PostMapping("/basedeconnaissances/create")
    public ResponseEntity<BaseDeConnaissance> createBaseDeConnaissance(@RequestBody BaseDeConnaissance baseDeConnaissance) {
        BaseDeConnaissance createdBaseDeConnaissance = baseDeConnaissanceService.createBaseDeConnaissance(baseDeConnaissance);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBaseDeConnaissance);
    }

<<<<<<< HEAD
    @Operation(summary = "supprimerbasedeconnaissance", description = "Permet de supprimer une info basedeconnaissance  par son id")

    @PutMapping("/basedeconnaissances/update/{id}")
=======
    @Operation(summary = "", description = "")

    @PutMapping("/basedeconnaissances/{id}")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    public ResponseEntity<BaseDeConnaissance> updateBaseDeConnaissance(
            @PathVariable("id") Long id,
            @RequestBody BaseDeConnaissance baseDeConnaissanceDetails) {
        BaseDeConnaissance updatedBaseDeConnaissance = baseDeConnaissanceService.updateBaseDeConnaissance(id, baseDeConnaissanceDetails);
        return ResponseEntity.ok(updatedBaseDeConnaissance);
    }

<<<<<<< HEAD
    @Operation(summary = "supprimerbasedeconnaissance ", description = "Permet de supprimer une info dans la  basedeconnaissance  par son id")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5

    @DeleteMapping("/basedeconnaissances/{id}/delete")
    public ResponseEntity<Void> deleteBaseDeConnaissance(@PathVariable("id") Long id) {
        baseDeConnaissanceService.deleteBaseDeConnaissance(id);
        return ResponseEntity.noContent().build();
    }
}

