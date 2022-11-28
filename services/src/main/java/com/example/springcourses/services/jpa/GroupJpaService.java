package com.example.springcourses.services.jpa;

import com.example.springcourses.dto.GroupDto;
import com.example.springcourses.entity.Group;
import com.example.springcourses.services.GroupService;
import com.example.springcourses.services.config.JpaImplementation;
import org.springframework.data.jpa.repository.JpaRepository;

/*@JpaImplementation
public class GroupJpaService extends AbstractJpaService<GroupDto, Group, Long> implements GroupService {

    @Override
    public JpaRepository<Group, Long> getRepository() {
        throw new UnsupportedOperationException();
    }

    @Override
    public GroupDto mapToDto(Group entity) {
        return null;
    }

    @Override
    public Group mapToEntity(GroupDto dto) {
        return null;
    }
}*/
