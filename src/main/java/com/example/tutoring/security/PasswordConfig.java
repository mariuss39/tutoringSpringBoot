package com.example.tutoring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration  //ne spune ca e o clasa spring
public class PasswordConfig {
    @Bean // un obiect creat o data la inceput de spring si pastrat pe parcrusul aplicatiei
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
