package com.gestion.gestion.Controller;

import com.gestion.gestion.Repository.UtilisateurRepository;
import com.gestion.gestion.Service.BaseDeConnaissanceService;
import com.gestion.gestion.Service.ApprenantService;
import com.gestion.gestion.Service.TicketServiceImpl;
import com.gestion.gestion.model.BaseDeConnaissance;
import com.gestion.gestion.model.Ticket;
import com.gestion.gestion.model.Utilisateur;
import io.swagger.v3.oas.annotations.Operation;
<<<<<<< HEAD
import io.swagger.v3.oas.annotations.tags.Tag;
=======
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
<<<<<<< HEAD
@Tag(name = "Api apprenant", description = "Cet api permet de gérer le crud Ticket ")

=======
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
@RequestMapping("/api/apprenants")
@Data
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

<<<<<<< HEAD
    @Operation(summary = "CreateTicket ", description = "Permet créer un Ticket ")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    @PostMapping("/createticket")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = apprenantService.createTicket(ticket);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

<<<<<<< HEAD
    @Operation(summary = "rechercheTicket ", description = "Permet de recupére un Ticket  par id")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Long id) {
        Ticket ticket = apprenantService.getTickettById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

<<<<<<< HEAD
    @Operation(summary = "modifierTicket ", description = "Permet de modifier un Ticket  par son id")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    @PutMapping("/update/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        Ticket updatedTicket = apprenantService.updateTicket(id, ticketDetails);
        return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
    }

<<<<<<< HEAD
    @Operation(summary = "supprimerTicket ", description = "Permet de supprimer un Ticket  par son id")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        apprenantService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

<<<<<<< HEAD
    @Operation(summary = "listeTicket ", description = "Permet de voir tout les Ticket ")
=======
    @Operation(summary = "", description = "")
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTicket() {
        List<Ticket> tickets = apprenantService.getAllTicket();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
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
}


