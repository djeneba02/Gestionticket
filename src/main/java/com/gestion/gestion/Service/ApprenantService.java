package com.gestion.gestion.Service;

import com.gestion.gestion.Enum.Statut;
import com.gestion.gestion.model.Apprenant;
import com.gestion.gestion.model.Ticket;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public interface ApprenantService {

    Ticket createTicket(Ticket ticket);


    Ticket getTicketById(Long id);

    Ticket updateTicket(Long id, Ticket ticketDetails);


    //Ticket updateStatut(Long ticketId, Statut statut);


    void deleteTicket(Long id);

    List<Ticket> getAllTicket();

    Ticket getTickettById(Long id);

}
