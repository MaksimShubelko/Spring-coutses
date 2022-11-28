package com.example.springcourses.mapper;

import com.example.springcourses.dto.SystemLogDto;
import com.example.system.entity.SystemLogEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SystemLogMapper {

    SystemLogDto mapToDto(SystemLogEntity entity);

    List<SystemLogDto> mapListToDto(List<SystemLogEntity> entities);

    SystemLogEntity mapDtoToEntity(SystemLogDto dto);
}
