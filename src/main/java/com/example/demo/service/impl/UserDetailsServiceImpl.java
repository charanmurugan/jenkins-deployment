package com.example.demo.service.impl;


import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.UserDetailsDTO;
import com.example.demo.entity.UserDetailsEntity;
import com.example.demo.mapper.ToDTO;
import com.example.demo.mapper.ToEntity;
import com.example.demo.repository.UserDetailsRepository;
import com.example.demo.service.UserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public List<UserDetailsDTO> getAllUser() {
        return ToDTO.INSTANCE.toUserDetailsDtoList(userDetailsRepository.findAll());
    }

    @Override
    public ResponseDTO saveUser(UserDetailsDTO userDetailsDTO) {
        userDetailsRepository.save(ToEntity.INSTANCE.toUserDetailsEntity(userDetailsDTO));
        return new ResponseDTO(HttpStatus.OK,"User has been added");
    }
}
