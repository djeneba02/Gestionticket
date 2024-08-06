package com.gestion.gestion.Controller;

import com.gestion.gestion.Repository.UtilisateurRepository;
import com.gestion.gestion.Service.BaseDeConnaissanceService;
import com.gestion.gestion.Service.ApprenantService;
import com.gestion.gestion.Service.TicketServiceImpl;
import com.gestion.gestion.model.BaseDeConnaissance;
import com.gestion.gestion.model.Ticket;
import com.gestion.gestion.model.Utilisateur;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Tag(name = "Api apprenant", description = "Cet api permet de gérer le crud Ticket ")

@RequestMapping("/api/apprenants")
@Data
@RestController
public class ApprenantController {

    private final TicketServiceImpl ticketService;
    private final ApprenantService apprenantService;
    private final UtilisateurRepository utilisateurRepository;

    //public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
    /*@PostMapping("/createticket")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        //Ticket createdTicket = apprenantService.createTicket(ticket);
        //return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
        apprenantService.envoiesMessage("djenebacissoko01@gmail.com","djenebacissoko01@gmail.com","Ticket créer avec SMTP","Ticket créer avec succès");
        return apprenantService.createTicket(ticket);
    }*/


    //@Operation(summary = "CreateTicket ", description = "Permet créer un Ticket ")

    @PostMapping(path = "/createticket")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = apprenantService.createTicket(ticket);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }


    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return new ResponseEntity<>("Endpoint is working", HttpStatus.OK);
    }

    @Operation(summary = "rechercheTicket ", description = "Permet de recupére un Ticket  par id")

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Long id) {
        Ticket ticket = apprenantService.getTickettById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }


    @Operation(summary = "modifierTicket ", description = "Permet de modifier un Ticket  par son id")

    @PutMapping("/update/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        Ticket updatedTicket = apprenantService.updateTicket(id, ticketDetails);
        return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
    }

    @Operation(summary = "supprimerTicket ", description = "Permet de supprimer un Ticket  par son id")

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        apprenantService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @Operation(summary = "listeTicket ", description = "Permet de voir tout les Ticket ")

    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTicket() {
        List<Ticket> tickets = apprenantService.getAllTicket();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }



   private final BaseDeConnaissanceService baseDeConnaissanceService;


    @Operation(summary = "listebasedeconnaissances ", description = "Permet de voir la basedeconnaissances ")


    @GetMapping("/basedeconnaissances")
    public ResponseEntity<List<BaseDeConnaissance>> getAllBaseDeConnaissances() {
        List<BaseDeConnaissance> baseDeConnaissances = baseDeConnaissanceService.getAllBaseDeConnaissances();
        return ResponseEntity.ok(baseDeConnaissances);
    }
}


