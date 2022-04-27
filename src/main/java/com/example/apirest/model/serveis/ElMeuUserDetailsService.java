package com.example.apirest.model.serveis;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElMeuUserDetailsService implements UserDetailsService {
    private final ServeisUser serveiUsuarisUserDetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) serveiUsuarisUserDetails.consultarPerUsername(username);
    }
}
