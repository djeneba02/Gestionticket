package com.gestion.gestion.Controller;


import com.gestion.gestion.Service.ApprenantService;
import com.gestion.gestion.Service.BaseDeConnaissanceService;
import com.gestion.gestion.model.Apprenant;
import com.gestion.gestion.model.BaseDeConnaissance;
import com.gestion.gestion.model.Formateur;
import com.gestion.gestion.Service.FormateurService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/api/formateurs")
public class FormateurController {
    private final FormateurService formateurService;
    private final ApprenantService apprenantService;

    @Operation(summary = "", description = "")

    @PostMapping("/create")
    public ResponseEntity<Apprenant> createApprenant(@RequestBody Apprenant apprenant) {
        Apprenant createdApprenant = formateurService.createApprenant(apprenant);
        return new ResponseEntity<>(createdApprenant, HttpStatus.CREATED);
    }

    @Operation(summary = "", description = "")

    @GetMapping("/{id}")
    public ResponseEntity<Apprenant> getApprenant(@PathVariable Long id) {
        Apprenant apprenant = formateurService.getApprenantById(id);
        return new ResponseEntity<>(apprenant, HttpStatus.OK);
    }

    @Operation(summary = "", description = "")

    @PutMapping("/update/{id}")
    public ResponseEntity<Apprenant> updateApprenant(@PathVariable Long id, @RequestBody Apprenant apprenantDetails) {
        Apprenant updatedApprenant = formateurService.updateApprenant(id, apprenantDetails);
        return new ResponseEntity<>(updatedApprenant, HttpStatus.OK);
    }

    @Operation(summary = "", description = "")

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteApprenant(@PathVariable Long id) {
        formateurService.deleteApprenant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "", description = "")

    @GetMapping("/all")
    public ResponseEntity<List<Apprenant>> getAllApprenants() {
        List<Apprenant> apprenants = formateurService.getAllApprenants();
        return new ResponseEntity<>(apprenants, HttpStatus.OK);
    }


    @Autowired
   private BaseDeConnaissanceService baseDeConnaissanceService;

    @Operation(summary = "", description = "")

    @GetMapping("/basedeconnaissances")
    public ResponseEntity<List<BaseDeConnaissance>> getAllBaseDeConnaissances() {
        List<BaseDeConnaissance> baseDeConnaissances = baseDeConnaissanceService.getAllBaseDeConnaissances();
        return ResponseEntity.ok(baseDeConnaissances);
    }

    @Operation(summary = "", description = "")

    @GetMapping("/basedeconnaissances/{id}")
    public ResponseEntity<BaseDeConnaissance> getBaseDeConnaissanceById(@PathVariable("id") Long id) {
        Optional<BaseDeConnaissance> baseDeConnaissance = baseDeConnaissanceService.getBaseDeConnaissanceById(id);
        return baseDeConnaissance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "", description = "")

    @PostMapping("/basedeconnaissances/create")
    public ResponseEntity<BaseDeConnaissance> createBaseDeConnaissance(@RequestBody BaseDeConnaissance baseDeConnaissance) {
        BaseDeConnaissance createdBaseDeConnaissance = baseDeConnaissanceService.createBaseDeConnaissance(baseDeConnaissance);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBaseDeConnaissance);
    }

    @Operation(summary = "", description = "")

    @PutMapping("/basedeconnaissances/{id}")
    public ResponseEntity<BaseDeConnaissance> updateBaseDeConnaissance(
            @PathVariable("id") Long id,
            @RequestBody BaseDeConnaissance baseDeConnaissanceDetails) {
        BaseDeConnaissance updatedBaseDeConnaissance = baseDeConnaissanceService.updateBaseDeConnaissance(id, baseDeConnaissanceDetails);
        return ResponseEntity.ok(updatedBaseDeConnaissance);
    }

    @Operation(summary = "", description = "")

    @DeleteMapping("/basedeconnaissances/{id}/delete")
    public ResponseEntity<Void> deleteBaseDeConnaissance(@PathVariable("id") Long id) {
        baseDeConnaissanceService.deleteBaseDeConnaissance(id);
        return ResponseEntity.noContent().build();
    }
}

