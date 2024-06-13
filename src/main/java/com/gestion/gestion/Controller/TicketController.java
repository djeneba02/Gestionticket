package com.gestion.gestion.Controller;


import com.gestion.gestion.model.Ticket;
import com.gestion.gestion.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Void> ajouterTicket(@RequestBody Ticket ticket) {
        ticketService.ajouterTicket(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<Void> supprimerTicket(@PathVariable Long ticketId) {
        ticketService.supprimerTicket(ticketId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<Void> modifierTicket(@PathVariable Long ticketId, @RequestBody Ticket ticket) {
        ticket.setId(ticketId);
        ticketService.modifierTicket(ticket);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long ticketId) {
        Ticket ticket = ticketService.getTicketById(ticketId);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @PostMapping("/{ticketId}/prendre/{apprenantId}")
    public ResponseEntity<Void> prendreTicket(@PathVariable Long ticketId, @PathVariable Long apprenantId) {
        ticketService.prendreTicket(apprenantId, ticketId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{ticketId}/liberer")
    public ResponseEntity<Void> libererTicket(@PathVariable Long ticketId) {
        ticketService.libererTicket(ticketId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

