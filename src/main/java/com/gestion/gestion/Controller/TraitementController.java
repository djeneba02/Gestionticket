package com.gestion.gestion.Controller;

import com.gestion.gestion.model.Ticket;
import io.swagger.v3.oas.annotations.Operation;
<<<<<<< HEAD
import io.swagger.v3.oas.annotations.tags.Tag;
=======
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.gestion.gestion.Service.TraitementService;
import com.gestion.gestion.model.Traitement;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@Tag(name = "Api formateur", description = "Cet api permet de gérer le crud Ticket ")

=======
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
@RequestMapping("/api/reponse")
@Data
public class TraitementController {

    final TraitementService traitementService;

<<<<<<< HEAD
   // @Operation(summary = "", description = "")

    @PostMapping("/create")
   /* public ResponseEntity<Traitement> createTraitement(@RequestBody Traitement traitement) {
        Traitement createdTraitement = traitementService.createTraitement(traitement);
        return new ResponseEntity<>(createdTraitement, HttpStatus.CREATED);
    }*/


    @Operation(summary = "recherchetraitement ", description = "Permet de recupére un traitement par id")
=======
    @Operation(summary = "", description = "")

    @PostMapping("/create")
    public ResponseEntity<Traitement> createTraitement(@RequestBody Traitement traitement) {
        Traitement createdTraitement = traitementService.createTraitement(traitement);
        return new ResponseEntity<>(createdTraitement, HttpStatus.CREATED);
    }

    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5

    @GetMapping("/{id}")
    public ResponseEntity<Traitement> getTraitement(@PathVariable Long id) {
        Traitement traitement  = traitementService.getTraitementById(id);
        return new ResponseEntity<>(traitement , HttpStatus.OK);
    }

<<<<<<< HEAD
    @Operation(summary = "modifiertraitement ", description = "Permet de modifier un traitement par son id")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5

    @PutMapping("/update/{id}")
    public ResponseEntity<Traitement > updateTraitement (@PathVariable Long id, @RequestBody Traitement  traitementDetails) {
        Traitement  updatedTraitement  = traitementService.updateTraitement(id, traitementDetails);
        return new ResponseEntity<>(updatedTraitement , HttpStatus.OK);
    }

<<<<<<< HEAD
    @Operation(summary = "supprimertraitement ", description = "Permet de supprimer un traitement  par son id")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTraitement (@PathVariable Long id) {
        traitementService.deleteTraitement (id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

<<<<<<< HEAD
    @Operation(summary = "listetraitement", description = "Permet de voir tout les traitements")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5

    @GetMapping("/all")
    public ResponseEntity<List<Traitement >> getAllTicket() {
        List<Traitement > traitements = traitementService.getAllTraitement();
        return new ResponseEntity<>(traitements, HttpStatus.OK);
    }
<<<<<<< HEAD

    @Operation(summary = "Createtraitement ", description = "Permet de traitementer un ticket ")

    @PostMapping("/create/traitements")
    public ResponseEntity<Traitement> createTraitement(@RequestBody Traitement traitement) {
        try {
            Traitement createdTraitement = traitementService.createTraitement(traitement);
            return ResponseEntity.ok(createdTraitement);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
=======
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
}

