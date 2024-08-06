package com.gestion.gestion.Service;

import com.gestion.gestion.Enum.Statut;
import com.gestion.gestion.Repository.TicketRepository;
import com.gestion.gestion.Repository.TraitementRepository;
import com.gestion.gestion.model.Ticket;
import com.gestion.gestion.model.Traitement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.gestion.gestion.Enum.Statut.RESOLU;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
   private TraitementRepository traitementRepository;


   /* @Override
    public Traitement createTraitement(Traitement traitement) {
        Ticket ticket = traitement.getTicket();
        ticket.getStatut(RESOLU); // Set status to RESOLU
        ticketRepository.save(ticket);

        traitement.setResponseDate(LocalDate.now());
        return traitementRepository.save(traitement);
    }*/
}



