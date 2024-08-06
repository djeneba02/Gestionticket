package com.gestion.gestion.Service;

import com.gestion.gestion.Enum.Statut;
import com.gestion.gestion.Repository.*;
import com.gestion.gestion.model.*;
import lombok.Data;
import org.springframework.expression.ExpressionException;

import com.gestion.gestion.Repository.*;
import com.gestion.gestion.model.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.gestion.gestion.Enum.Statut.ENCOURS;
import static com.gestion.gestion.Enum.Statut.OUVERT;

@Service
@Transactional
@Data
public class ApprenantServiceImpl implements ApprenantService {

    private final TicketRepository ticketRepository;
    private final ApprenantRepository apprenantRepository;
    private final Messagerie messagerie;
    private final JavaMailSender javaMailSender;
    private final TraitementRepository traitementRepository;
    private final NotificationRepository notificationRepository;
    private final UtilisateurRepository utilisateurRepository;
    @Autowired
    private  UtilisateurService utilisateurService;

    @Autowired
    private  AdminService adminService;

    @Autowired
    private MessagerieService messagerieService;




    @Override
    public Ticket createTicket(Ticket ticket) {
        // Récupération de l'utilisateur connecté
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String emailApp = authentication.getName();
        Apprenant apprenant = (Apprenant) utilisateurRepository.findByEmail(emailApp);

        if (apprenant == null) {
            throw new RuntimeException("Utilisateur non trouvé avec l'email: " + emailApp);
        }

        // Attribution de l'apprenant au ticket
        ticket.setApprenant(apprenant);
        ticket.setStatut(Statut.OUVERT); // Assurez-vous que "OUVERT" est une constante valide dans votre enum Statut

        // Sauvegarde du ticket
        Ticket enrTicket = ticketRepository.save(ticket);

        // Envoi des emails aux formateurs
        sendEmailToFormateurs(apprenant, ticket);

        // Création et sauvegarde de la notification
        Notification notification = new Notification();
        notification.setTicketId(ticket.getId());
        notification.setDate(LocalDateTime.now());
        notification.setMessage(ticket.getDescription());
        notificationRepository.save(notification);

        return enrTicket;
    }

    public void sendEmailToFormateurs(Apprenant apprenant, Ticket ticket) {
        List<Formateur> formateurs = adminService.getAllFormateur();

        for (Formateur formateur : formateurs) {
            String emailFormateur = formateur.getEmail();
            String objet = "Création d'un nouveau ticket par " + apprenant.getNom() + " " + apprenant.getPrenom();
            String texte = "Le ticket créé est : " + ticket.getDescription();

            // Envoi du message
            messagerieService.envoyerMessage(emailFormateur, objet, texte);
        }



    }



    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ticket non trouvé avec l'ID : " + id));
    }

    @Override
    public Ticket updateTicket(Long id, Ticket ticket) {
        // Récupère l'utilisateur connecté
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Utilisateur utilisateurConnecte = utilisateurRepository.findByEmail(email);

        // Vérifie si le ticket avec l'ID donné existe
        Optional<Ticket> existingTicketOptional = ticketRepository.findById(id);

        if (existingTicketOptional.isPresent()) {
            Ticket existingTicket = existingTicketOptional.get();

            // Vérifie si l'utilisateur est un formateur ou un apprenant
            boolean isFormateur = utilisateurConnecte instanceof Formateur;
            boolean isApprenant = utilisateurConnecte instanceof Apprenant;

            // Si l'utilisateur est un apprenant, vérifie que le statut du ticket est "OUVERT"
            if (isApprenant && !existingTicket.getStatut().equals(Statut.OUVERT)) {
                throw new RuntimeException("Le ticket ne peut être modifié que s'il est ouvert.");
            }

            // Met à jour les informations du ticket existant avec celles du ticket fourni
            existingTicket.setTitre(ticket.getTitre());
            existingTicket.setDescription(ticket.getDescription());
            existingTicket.setCategorie(ticket.getCategorie());

            // Si l'utilisateur est un formateur, met à jour le statut du ticket en "ENCOURS"
            if (isFormateur) {
                existingTicket.setStatut(Statut.ENCOURS);

                // Envoie un message à l'apprenant pour l'informer du changement de statut
                Apprenant apprenant = ticket.getApprenant();
                String emailApprenant = apprenant.getEmail();
                String objet = "Mise à jour du statut de votre ticket";
                String texte = "Bonjour " + apprenant.getNom() + ",\n\n" +
                        "Le statut de votre ticket avec le titre \"" + ticket.getTitre() + "\" a été modifié en \"ENCOURS\".\n" +
                        "Description : " + ticket.getDescription() + "\n\n" +
                        "Cordialement,\nL'équipe de gestion des tickets";

                messagerieService.envoyerMessage(emailApprenant, objet, texte);
            } else if (isApprenant) {
                // Pour les apprenants, le statut du ticket ne doit pas être modifié
                // Vous pouvez conserver le statut existant ou ne rien faire
                existingTicket.setStatut(existingTicket.getStatut());
            }

            // Sauvegarde le ticket mis à jour dans le dépôt
            return ticketRepository.save(existingTicket);
        } else {
            // Lève une exception si le ticket avec l'ID donné n'est pas trouvé
            throw new RuntimeException("Ticket non trouvé !");
        }
    }



    /**@Override
    public Ticket updateStatut(Long ticketId, Statut statut) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ExpressionException("Ticket not found"));
        ticket.setStatut(OUVERT);
        return ticketRepository.save(ticket);
    }**/

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

   /* public String envoiesMessage(String to, String subject, String text) {
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
    }*/
}

