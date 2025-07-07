package com.example.demo.service;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.UserDetailsDTO;
import com.example.demo.entity.UserDetailsEntity;

import java.util.List;

public interface UserDetailsService {
     List<UserDetailsDTO> getAllUser();
     ResponseDTO saveUser(UserDetailsDTO userDetailsDTO);
}
