package com.example.tutoring.security;

import com.example.tutoring.User.User;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SecurityUser implements UserDetails {

    private final Long id;
    private final String email;
    private final String passwordHash;
    private final String role;

    public SecurityUser(User user){
        this.id=user.getId();
        this.email=user.getEmail();
        this.passwordHash=user.getPasswordHash();
        this.role=user.getRole();
    }

    public Long getId() {
        return this.id;
    }

    public String getRole(){
        return this.role;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+this.role));
    }

    @Override
    public @Nullable String getPassword() {
        return this.passwordHash;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
