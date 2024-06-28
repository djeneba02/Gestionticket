package com.gestion.gestion.Service;

import com.gestion.gestion.model.Utilisateur;
import com.gestion.gestion.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec le nom : " + email);
        }

        return User.withUsername(utilisateur.getEmail())
                .password(utilisateur.getPassword())
                .authorities(new SimpleGrantedAuthority("ROLE_" + utilisateur.getRole())) // Utilisation de utilisateur.getRole()
                .build();
    }
}
