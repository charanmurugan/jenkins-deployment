package com.example.demo.mapper;

import com.example.demo.dto.UserDetailsDTO;
import com.example.demo.entity.UserDetailsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ToEntity {
    ToEntity INSTANCE = Mappers.getMapper(ToEntity.class);

    UserDetailsEntity toUserDetailsEntity(UserDetailsDTO userDetailsDTO);
}
