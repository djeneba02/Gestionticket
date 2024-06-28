package com.gestion.gestion.Controller;

import com.gestion.gestion.model.Ticket;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.gestion.gestion.Service.TraitementService;
import com.gestion.gestion.model.Traitement;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reponse")
@Data
public class TraitementController {

    final TraitementService traitementService;

    @Operation(summary = "", description = "")

    @PostMapping("/create")
    public ResponseEntity<Traitement> createTraitement(@RequestBody Traitement traitement) {
        Traitement createdTraitement = traitementService.createTraitement(traitement);
        return new ResponseEntity<>(createdTraitement, HttpStatus.CREATED);
    }

    @Operation(summary = "", description = "")

    @GetMapping("/{id}")
    public ResponseEntity<Traitement> getTraitement(@PathVariable Long id) {
        Traitement traitement  = traitementService.getTraitementById(id);
        return new ResponseEntity<>(traitement , HttpStatus.OK);
    }

    @Operation(summary = "", description = "")

    @PutMapping("/update/{id}")
    public ResponseEntity<Traitement > updateTraitement (@PathVariable Long id, @RequestBody Traitement  traitementDetails) {
        Traitement  updatedTraitement  = traitementService.updateTraitement(id, traitementDetails);
        return new ResponseEntity<>(updatedTraitement , HttpStatus.OK);
    }

    @Operation(summary = "", description = "")

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTraitement (@PathVariable Long id) {
        traitementService.deleteTraitement (id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "", description = "")

    @GetMapping("/all")
    public ResponseEntity<List<Traitement >> getAllTicket() {
        List<Traitement > traitements = traitementService.getAllTraitement();
        return new ResponseEntity<>(traitements, HttpStatus.OK);
    }
}

