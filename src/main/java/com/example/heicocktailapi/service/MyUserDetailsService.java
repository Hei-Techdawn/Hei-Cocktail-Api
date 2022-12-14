package com.example.heicocktailapi.service;

import com.example.heicocktailapi.model.MyUserDetails;
import com.example.heicocktailapi.model.MyUser;
import com.example.heicocktailapi.repository.MyUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserRepository.findByUsername(username);
        if (myUser == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new MyUserDetails(myUser);
    }
}
