package com.example.helloworldapi.controller;

import com.example.helloworldapi.model.MyUser;
import com.example.helloworldapi.service.MyUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class MyUserController {
    private MyUserService myUserService;

    @PostMapping(value = "")
    public MyUser createUser(
            @RequestBody MyUser myUser
    ) {
        return myUserService.createUser(myUser);
    }
}
