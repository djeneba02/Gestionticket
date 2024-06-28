package com.gestion.gestion.Service;

import com.gestion.gestion.Repository.*;
import com.gestion.gestion.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class TraitementServiceImpl implements TraitementService {

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

    @Override
    public Traitement createTraitement(Traitement traitement) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String emailformateur = authentication.getName();
        Formateur fromateur = (Formateur) utilisateurRepository.findByEmail(emailformateur);

        traitement.setFormateur(fromateur);
        traitementRepository.save(traitement);

        Ticket ticket = traitement.getTicket();
        Apprenant apprenant = ticket.getApprenant();
        String email = apprenant.getEmail();
        String Object ="huuuuuuuuuuuuuuuuuu";
        String Texte = "ffffffffffffff";
        apprenantServiceImpl.envoiesMessage(email,Object,Texte);
        Notification notification = new Notification();
        notification.setMessage(ticket.getDescription());
        notification.setDate(LocalDateTime.now());
        notification.setTicketId(ticket.getId());
        notificationRepository.save(notification);

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
