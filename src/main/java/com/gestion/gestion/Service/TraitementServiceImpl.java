package com.gestion.gestion.Service;

import com.gestion.gestion.Enum.Statut;
import com.gestion.gestion.Repository.*;
import com.gestion.gestion.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.gestion.gestion.Enum.Statut.RESOLU;

@Transactional
@Service
@RequiredArgsConstructor
public class TraitementServiceImpl implements TraitementService {

    private final TicketRepository ticketRepository;

    private final TraitementRepository traitementRepository;

    @Autowired
    Messagerie messagerie;

    private final ApprenantRepository apprenantRepository;
    @Autowired
    private FormateurRepository formateurRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private ApprenantServiceImpl apprenantServiceImpl;
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private MessagerieService messagerieService;

    public Traitement createTraitement(Traitement traitement) {
        // Récupérer l'email du formateur à partir de l'authentification
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String emailFormateur = authentication.getName();
        Formateur formateur = (Formateur) utilisateurRepository.findByEmail(emailFormateur);

        if (formateur == null) {
            throw new IllegalArgumentException("Le formateur associé à cet email n'existe pas.");
        }

        // Associer le formateur au traitement et enregistrer le traitement
        traitement.setFormateur(formateur);

        Ticket ticket = ticketRepository.findById(traitement.getTicket().getId()).get();
        // Récupérer le ticket associé au traitement
        Long tiid = ticket.getId();
        if (tiid == null) {
            throw new IllegalArgumentException("Le ticket associé au traitement est null.");
        }

        // Changer le statut du ticket et mettre à jour la date de réponse du traitement
        ticket.setStatut(Statut.RESOLU);
        traitement.setResponseDate(LocalDate.now());
        ticketRepository.save(ticket);

        traitement.setTicket(ticket);

        // Récupérer l'apprenant associé au ticket
        Apprenant apprenant = ticket.getApprenant();
        Long appid = apprenant.getId();
        if (appid == null) {
            throw new RuntimeException("L'apprenant associé au ticket est null.");
        }

        // Vérification de l'email de l'apprenant
        String email = apprenant.getEmail();
        if (email == null || email.isEmpty()) {
            throw new RuntimeException("L'email de l'apprenant est null ou vide.");
        }

        // Envoyer un email à l'apprenant
        String objet = "Résolution du ticket";
        String texte = "Votre ticket a été répondu";
        messagerieService.envoyerMessage(email, objet, texte);

        // Créer et enregistrer une notification
        Notification notification = new Notification();
        notification.setMessage(ticket.getDescription());
        notification.setDate(LocalDateTime.now());
        notification.setTicketId(ticket.getId());
        notificationRepository.save(notification);

        traitementRepository.save(traitement);
        return traitement;
    }




    @Override
    public Traitement getTraitementById(Long id) {
        return traitementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Traitement non trouvé avec l'ID : " + id));
    }

    @Override
    public Traitement updateTraitement(Long id, Traitement traitement) {
        Traitement existingTraitement = traitementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Traitement non trouvé avec l'ID : " + id));

        existingTraitement.setReponse(traitement.getReponse());
        existingTraitement.setTicket(traitement.getTicket());
        existingTraitement.setFormateur(traitement.getFormateur());

        return traitementRepository.save(existingTraitement);
    }

    @Override
    public void deleteTraitement(Long id) {
        Traitement traitement = traitementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Traitement non trouvé avec l'ID : " + id));
        traitementRepository.delete(traitement);
    }

    @Override
    public List<Traitement> getAllTraitement() {
        return traitementRepository.findAll();
    }
}
