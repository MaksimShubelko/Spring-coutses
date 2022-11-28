package com.example.springcourses.mapper;

import com.example.springcourses.dto.SystemOptionDto;
import com.example.system.entity.SystemOptionEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SystemOptionMapper {

    SystemOptionDto mapToDto(SystemOptionEntity entity);

    List<SystemOptionDto> mapListToDto(List<SystemOptionEntity> entities);
}
