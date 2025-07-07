package com.example.demo.controller;


import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.UserDetailsDTO;
import com.example.demo.service.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserDetailsService userDetailsService;

    public UserController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    public List<UserDetailsDTO> getAllUser() {
        return userDetailsService.getAllUser();
    }

    @PostMapping
    public ResponseDTO saveUser(@RequestBody UserDetailsDTO userDetailsDTO){
        return userDetailsService.saveUser(userDetailsDTO);
    }

}
