package com.gestion.gestion.Service;


import com.gestion.gestion.Enum.Statut;
import com.gestion.gestion.Repository.*;
import com.gestion.gestion.model.*;
import lombok.Data;
import org.springframework.expression.ExpressionException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Data
public class ApprenantServiceImpl implements ApprenantService {

    private final TicketRepository ticketRepository;
    private final ApprenantRepository apprenantRepository;

    private final JavaMailSender javaMailSender;
    private final TraitementRepository traitementRepository;
    private final NotificationRepository notificationRepository;
    private final UtilisateurRepository utilisateurRepository;



    @Override
    public Ticket createTicket(Ticket ticket){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String emailApp = authentication.getName();
        Apprenant apprenant = (Apprenant) utilisateurRepository.findByEmail(emailApp);

        ticket.setApprenant(apprenant);
        //ticket.setStatut(Statut.OUVERT);
        Ticket enrTicket = ticketRepository.save(ticket);

        Formateur formateur = apprenant.getFormateur();
        String emailFormateur = formateur.getEmail();
        String object = "Creation d'un nouveau ticket par "+apprenant.getNom()+" "+apprenant.getPrenom();
        String Text = "Le ticket creer est :"+ticket.getDescription();
        envoiesMessage(emailFormateur,object,Text);

        Notification notification = new Notification();
        notification.setTicketId(ticket.getId());
        notification.setDate(LocalDateTime.now());
        notification.setMessage(ticket.getDescription());
        notificationRepository.save(notification);


    return enrTicket;
}


    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ticket non trouvé avec l'ID : " + id));
    }

    @Override
    public Ticket updateTicket(Long id, Ticket ticket) {
        //Vérifie si le ticket avec l'ID donné existe
        Optional<Ticket> existingTicketOptional = ticketRepository.findById(id);

        if (existingTicketOptional.isPresent()) {
            Ticket existingTicket = existingTicketOptional.get();
            // Met à jour les informations du ticket existant avec celles du ticket fourni
            existingTicket.setTitre(ticket.getTitre());
            existingTicket.setDescription(ticket.getDescription());
           // existingTicket.setStatut(ticket.getStatut());
            existingTicket.setCategorie(ticket.getCategorie());
            // Sauvegarde le ticket mis à jour dans le dépôt
            return ticketRepository.save(existingTicket);
        } else {
            // Lève une exception si le ticket avec l'ID donné n'est pas trouvé
            throw new RuntimeException("Ticket non trouvé !");
        }
        }
@Override
    public Ticket updateStatut(Long ticketId, Statut statut) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ExpressionException("Ticket not found"));
        ticket.setStatut(statut);
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
            ticketRepository.deleteById(id);
        }



    @Override
    public List<Ticket> getAllTicket() {
            return ticketRepository.findAll();
    }

    @Override
    public Ticket getTickettById(Long id) {
        return null;
    }

    public String envoiesMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setTo(to);
            mailMessage.setSubject(subject);
            mailMessage.setText(text);

            javaMailSender.send(mailMessage);
            return "Mail envoyer";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

