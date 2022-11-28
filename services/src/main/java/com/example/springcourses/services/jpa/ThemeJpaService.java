package com.example.springcourses.services.jpa;

import com.example.springcourses.dto.ThemeDto;
import com.example.springcourses.entity.Theme;
import com.example.springcourses.mapper.ThemeMapper;
import com.example.springcourses.repository.ThemeRepository;
import com.example.springcourses.services.ThemeService;
import com.example.springcourses.services.config.JpaImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@JpaImplementation
public class ThemeJpaService extends AbstractJpaService<ThemeDto, Theme, Long> implements ThemeService {
    private final ThemeRepository repository;
    private final ThemeMapper mapper;

    @Override
    public ThemeDto findById(Long aLong) {

        return repository
                .findById(aLong)
                .map(mapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public void save(ThemeDto dto) {
        repository.save(mapper.map(dto));
    }

    @Override
    public Collection<ThemeDto> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long aLong) {
        System.out.println("Try to delete");
        repository.deleteById(aLong);
    }

    @Override
    public ThemeDto mapToDto(Theme entity) {
        return mapper.mapToDto(entity);
    }

    @Override
    public Theme mapToEntity(ThemeDto dto) {
        return mapper.map(dto);
    }

    @Override
    public JpaRepository<Theme, Long> getRepository() {
        return repository;
    }
}
