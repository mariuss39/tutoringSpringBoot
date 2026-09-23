package com.example.tutoring.auth;

import com.example.tutoring.security.JwtService;
import com.example.tutoring.security.SecurityUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService){
        this.authenticationManager=authenticationManager;
        this.jwtService=jwtService;
    }

    public LoginResponse login(LoginRequest loginRequest){
        Authentication authentication=authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.email(),loginRequest.password()));
        SecurityUser securityUser= (SecurityUser) authentication.getPrincipal();
        String token=jwtService.generateToekn(securityUser.getId(), securityUser.getRole());
        return new LoginResponse(token);
    }


}
