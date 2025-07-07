package com.example.demo.mapper;

import com.example.demo.dto.UserDetailsDTO;
import com.example.demo.entity.UserDetailsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ToDTO {
    ToDTO INSTANCE = Mappers.getMapper(ToDTO.class);

    UserDetailsDTO toUserDetailsDto(UserDetailsEntity userDetailsEntity);

    List<UserDetailsDTO> toUserDetailsDtoList(List<UserDetailsEntity> userDetailsEntityList);
}
