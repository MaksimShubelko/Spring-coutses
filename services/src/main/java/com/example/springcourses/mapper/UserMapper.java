package com.example.springcourses.mapper;

import com.example.springcourses.dto.UserDetailsDto;
import com.example.springcourses.dto.UserDto;
import com.example.springcourses.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(uses = {TeacherMapper.class, StudentMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface UserMapper {

    @Mapping(source = "student", target = "studentDto")
    @Mapping(source = "teacher", target = "teacherDto")
    @Mapping(target = "lastModifiedAt", source = "lastModifiedAt", defaultExpression = "java(java.time.OffsetDateTime.now())")
    UserDto mapToDto(UserEntity userEntity);

    List<UserDto> mapListToDto(List<UserDto> users);

    @Mapping(target = "student", source = "studentDto")
    @Mapping(target = "teacher", source = "teacherDto")
    @Mapping(target = "lastModifiedAt", source = "lastModifiedAt", defaultExpression = "java(java.time.OffsetDateTime.now())")
    UserEntity mapDtoToEntity(UserDto userDto);

    @Mapping(target = "userStatus", ignore = true) //TODO
    @Mapping(target = "userRole", ignore = true) //TODO
    @Mapping(target = "createdAt", source = "createdAt", defaultExpression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "lastModifiedAt", source = "lastModifiedAt", defaultExpression = "java(java.time.OffsetDateTime.now())")
    void map(UserDto userDto, @MappingTarget UserEntity userEntity);

    UserEntity mapDetailsToUser(UserDetailsDto dto);

    @Mapping(target = "teacherDto", source = "teacher")
    @Mapping(target = "studentDto", source = "student")
    UserDetailsDto mapToDetails(UserEntity userEntity);
}
