package com.gestion.gestion.Service;

<<<<<<< HEAD
import com.gestion.gestion.Enum.Statut;
=======
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
import com.gestion.gestion.model.Apprenant;
import com.gestion.gestion.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApprenantService {

    Ticket createTicket(Ticket ticket);


    Ticket getTicketById(Long id);

    Ticket updateTicket(Long id, Ticket ticketDetails);

<<<<<<< HEAD
    Ticket updateStatut(Long ticketId, Statut statut);

=======
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
    void deleteTicket(Long id);

    List<Ticket> getAllTicket();

    Ticket getTickettById(Long id);
    public String envoiesMessage(String to, String subject, String text);
}
