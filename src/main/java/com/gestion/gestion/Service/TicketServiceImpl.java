package com.gestion.gestion.Service;


import com.gestion.gestion.model.Apprenant;
import com.gestion.gestion.model.Ticket;
import com.gestion.gestion.Repository.ApprenantRepository;
import com.gestion.gestion.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final ApprenantRepository apprenantRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, ApprenantRepository apprenantRepository) {
        this.ticketRepository = ticketRepository;
        this.apprenantRepository = apprenantRepository;
    }

    @Override
    public void ajouterTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void supprimerTicket(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    @Override
    public void modifierTicket(Ticket ticket) {
        Optional<Ticket> existingTicketOptional = ticketRepository.findById(ticket.getId());
        existingTicketOptional.ifPresent(existingTicket -> {
            existingTicket.setTitre(ticket.getTitre());
            existingTicket.setDescription(ticket.getDescription());
            existingTicket.setStatut(ticket.getStatut());
            ticketRepository.save(existingTicket);
        });
    }

    @Override
    public Ticket getTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId).orElse(null);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public void prendreTicket(Long apprenantId, Long ticketId) {
        Optional<Apprenant> apprenantOptional = apprenantRepository.findById(apprenantId);
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);

        if (apprenantOptional.isPresent() && ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();
            Apprenant apprenant = apprenantOptional.get();
            ticket.setApprenant(apprenant);
            ticket.setStatut("Pris");
            ticketRepository.save(ticket);
        }
    }

    @Override
    public void libererTicket(Long ticketId) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        ticketOptional.ifPresent(ticket -> {
            ticket.setApprenant(null);
            ticket.setStatut("Libre");
            ticketRepository.save(ticket);
        });
    }
}

