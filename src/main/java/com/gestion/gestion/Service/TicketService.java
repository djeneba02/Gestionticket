package com.gestion.gestion.Service;

import com.gestion.gestion.Enum.Statut;
import com.gestion.gestion.model.Ticket;
import com.gestion.gestion.model.Traitement;
import org.springframework.stereotype.Service;

@Service
public interface TicketService {

    Traitement createTraitement(Traitement traitement);


}
