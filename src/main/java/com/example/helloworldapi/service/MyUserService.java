package com.example.helloworldapi.service;

import com.example.helloworldapi.model.MyUser;
import com.example.helloworldapi.repository.MyUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserService {
    private MyUserRepository myUserRepository;

    public MyUser createUser(MyUser myUser) {
        myUser.setPassword(passwordEncoder().encode(myUser.getPassword()));
        return myUserRepository.save(myUser);
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
