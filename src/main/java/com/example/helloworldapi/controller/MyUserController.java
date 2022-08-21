package com.example.helloworldapi.controller;

import com.example.helloworldapi.model.MyUser;
import com.example.helloworldapi.service.MyUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
@CrossOrigin(origins = "*")
public class MyUserController {
    private MyUserService myUserService;

    @PostMapping(value = "")
    public MyUser createUser(
            @RequestBody MyUser myUser
    ) {
        return myUserService.createUser(myUser);
    }
}
