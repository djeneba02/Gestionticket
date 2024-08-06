package com.gestion.gestion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/api/admin/createadmin").permitAll()
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/apprenants/createticket").hasRole("APPRENANT")
                        .requestMatchers("/api/formateurs/**").hasRole("FORMATEUR")
                        .requestMatchers("/api/reponse/**").hasRole("FORMATEUR")
                        .requestMatchers("/api/reponse/all").hasRole("APPRENANT")
                        .requestMatchers("/api/formateurs/basedeconnaissances").hasRole("APPRENANT")
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {return userDetailsService; }

    @Bean
    public AuthenticationProvider authenticationPrincipal(){
        DaoAuthenticationProvider authprovider=new DaoAuthenticationProvider();
        authprovider.setUserDetailsService(userDetailsService);
        authprovider.setPasswordEncoder(passwordEncoder());
        return authprovider;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}



/*
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build();

        UserDetails formateur = User.withDefaultPasswordEncoder()
                .username("formateur")
                .password("password")
                .roles("FORMATEUR")
                .build();

        UserDetails apprenant = User.withDefaultPasswordEncoder()
                .username("apprenant")
                .password("password")
                .roles("APPRENANT")
                .build();

        return new InMemoryUserDetailsManager(admin, formateur, apprenant);
    }*/
}

