package com.gestion.gestion.Controller;

import com.gestion.gestion.Repository.UtilisateurRepository;
import com.gestion.gestion.Service.BaseDeConnaissanceService;
import com.gestion.gestion.Service.ApprenantService;
import com.gestion.gestion.Service.TicketServiceImpl;
import com.gestion.gestion.model.BaseDeConnaissance;
import com.gestion.gestion.model.Ticket;
import com.gestion.gestion.model.Utilisateur;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
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

    @Operation(summary = "", description = "")
    @PostMapping("/createticket")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = apprenantService.createTicket(ticket);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    @Operation(summary = "", description = "")
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Long id) {
        Ticket ticket = apprenantService.getTickettById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @Operation(summary = "", description = "")
    @PutMapping("/update/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        Ticket updatedTicket = apprenantService.updateTicket(id, ticketDetails);
        return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
    }

    @Operation(summary = "", description = "")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        apprenantService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "", description = "")
    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTicket() {
        List<Ticket> tickets = apprenantService.getAllTicket();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }


   @Autowired
   private BaseDeConnaissanceService baseDeConnaissanceService;

    @Operation(summary = "", description = "")

    @GetMapping("/basedeconnaissances")
    public ResponseEntity<List<BaseDeConnaissance>> getAllBaseDeConnaissances() {
        List<BaseDeConnaissance> baseDeConnaissances = baseDeConnaissanceService.getAllBaseDeConnaissances();
        return ResponseEntity.ok(baseDeConnaissances);
    }
}


