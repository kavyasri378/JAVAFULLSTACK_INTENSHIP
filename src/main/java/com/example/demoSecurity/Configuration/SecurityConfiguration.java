package com.example.demoSecurity.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//customeized security
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        //disable csrf
        http.csrf(Customizer->Customizer.disable());
        //only Authenticated person can enter to authenticate we use form for browsor and basic http for postman
        http.authorizeHttpRequests(request->request.anyRequest().authenticated());
        //for browser
        //http.formLogin(Customizer.withDefaults());
        //for postman
        http.httpBasic(Customizer.withDefaults());
        //session id change akite irukum every time
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
