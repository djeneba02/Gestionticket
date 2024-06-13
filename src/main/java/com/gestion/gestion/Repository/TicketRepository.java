package com.gestion.gestion.Repository;

import com.gestion.gestion.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
