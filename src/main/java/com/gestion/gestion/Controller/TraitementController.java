package com.gestion.gestion.Controller;

import com.gestion.gestion.model.Ticket;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.gestion.gestion.Service.TraitementService;
import com.gestion.gestion.model.Traitement;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Api formateur", description = "Cet api permet de gérer le crud Ticket ")

@RequestMapping("/api/reponse")
@Data
public class TraitementController {

    final TraitementService traitementService;

   // @Operation(summary = "", description = "")

    @PostMapping("/create")
   /* public ResponseEntity<Traitement> createTraitement(@RequestBody Traitement traitement) {
        Traitement createdTraitement = traitementService.createTraitement(traitement);
        return new ResponseEntity<>(createdTraitement, HttpStatus.CREATED);
    }*/


    @Operation(summary = "recherchetraitement ", description = "Permet de recupére un traitement par id")

    @GetMapping("/{id}")
    public ResponseEntity<Traitement> getTraitement(@PathVariable Long id) {
        Traitement traitement  = traitementService.getTraitementById(id);
        return new ResponseEntity<>(traitement , HttpStatus.OK);
    }

    @Operation(summary = "modifiertraitement ", description = "Permet de modifier un traitement par son id")

    @PutMapping("/update/{id}")
    public ResponseEntity<Traitement > updateTraitement (@PathVariable Long id, @RequestBody Traitement  traitementDetails) {
        Traitement  updatedTraitement  = traitementService.updateTraitement(id, traitementDetails);
        return new ResponseEntity<>(updatedTraitement , HttpStatus.OK);
    }

    @Operation(summary = "supprimertraitement ", description = "Permet de supprimer un traitement  par son id")

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTraitement (@PathVariable Long id) {
        traitementService.deleteTraitement (id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "listetraitement", description = "Permet de voir tout les traitements")

    @GetMapping("/all")
    public ResponseEntity<List<Traitement >> getAllTicket() {
        List<Traitement > traitements = traitementService.getAllTraitement();
        return new ResponseEntity<>(traitements, HttpStatus.OK);
    }

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
}

