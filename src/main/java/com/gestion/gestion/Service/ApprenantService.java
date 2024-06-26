package com.gestion.gestion.Service;

import com.gestion.gestion.model.Apprenant;
import com.gestion.gestion.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApprenantService {

    Ticket createTicket(Ticket ticket);


    Ticket getTicketById(Long id);

    Ticket updateTicket(Long id, Ticket ticketDetails);

    void deleteTicket(Long id);

    List<Ticket> getAllTicket();

    Ticket getTickettById(Long id);
    public String envoiesMessage(String to, String subject, String text);
}
