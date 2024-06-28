package com.gestion.gestion.model;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.Data;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Data
public class Messagerie {

    private final JavaMailSender mailSender;

    public void envoiesMessage(String email, String email2[], String message) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("L'adresse de destination ne doit pas être nulle ou vide");
        }

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(email);
            //helper.setCc(email2);
            helper.setSubject("nouvelle notification");
            helper.setText(message, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
