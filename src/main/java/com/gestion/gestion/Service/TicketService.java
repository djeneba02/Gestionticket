package com.gestion.gestion.Service;



import com.gestion.gestion.model.Ticket;

import java.util.List;

public interface TicketService {

    void ajouterTicket(Ticket ticket);

    void supprimerTicket(Long ticketId);

    void modifierTicket(Ticket ticket);

    Ticket getTicketById(Long ticketId);

    List<Ticket> getAllTickets();

    void prendreTicket(Long apprenantId, Long ticketId);

    void libererTicket(Long ticketId);
}
