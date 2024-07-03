package com.gestion.gestion.Service;

<<<<<<< HEAD
import com.gestion.gestion.Enum.Statut;
import com.gestion.gestion.Repository.TicketRepository;
import com.gestion.gestion.Repository.TraitementRepository;
import com.gestion.gestion.model.Ticket;
import com.gestion.gestion.model.Traitement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TicketServiceImpl implements TicketService
{
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    TraitementRepository traitementRepository;



    @Override
    public Traitement createTraitement(Traitement traitement) {
        Ticket ticket = traitement.getTicket();
        ticket.setStatut(Statut.RESOLU); // Set status to RESOLU
        ticketRepository.save(ticket);

        traitement.setResponseDate(LocalDate.now());
        return traitementRepository.save(traitement);
    }

=======
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService
{
>>>>>>> 4d9f6a42d7ebcc4cc0950563327e09ed3aab5bb5
}
