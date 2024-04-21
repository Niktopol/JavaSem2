package com.example.demo.controller;

import com.example.demo.model.dto.UserDTO;
import com.example.demo.service.AuthorizationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController("/")
public class UserController {
    AuthorizationService authorizationService;

    @PostMapping("auth/signup")
    public String signUp(@RequestBody UserDTO user){
        if(authorizationService.signUp(user)){
            return "User created";
        }else{
            return "User exists";
        }
    }
}
