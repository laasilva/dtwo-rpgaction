package com.dtwo.rpgaction.configuration;

import com.dtwo.rpgaction.exception.AuthenticationException;
import com.dtwo.rpgaction.model.entities.User;
import com.dtwo.rpgaction.repositories.UserRepository;
import com.dtwo.rpgaction.utils.AppConstants;
import com.dtwo.rpgaction.utils.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new PasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userRepository.findUserByUsername(username);

        boolean passwordMatches = passwordEncoder.isPasswordValid(user.getPassword(), password);

        if(user != null) {
            if(passwordMatches) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(user.getRole().getDescription())); // description is a string

                return new UsernamePasswordAuthenticationToken(username, password, authorities);
            } else {
                throw new AuthenticationException(AppConstants.USER_VALIDATION_PASSWORD_ERROR);
            }
        } else {
            throw new AuthenticationException(AppConstants.PASSWORD_IS_NOT_VALID);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}