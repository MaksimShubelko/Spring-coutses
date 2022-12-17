package com.example.springcourses.services.jpa;

import com.example.springcourses.dto.ThemeDto;
import com.example.springcourses.dto.UserDto;
import com.example.springcourses.entity.Theme;
import com.example.springcourses.entity.UserEntity;
import com.example.springcourses.mapper.GroupMapper;
import com.example.springcourses.mapper.ThemeMapperImpl;
import com.example.springcourses.mapper.UserMapper;
import com.example.springcourses.repository.ThemeRepository;
import com.example.springcourses.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ThemeJpaServiceTest {

    @Mock
    private ThemeRepository repository;

    @Mock
    private ThemeMapperImpl mapper;

    @InjectMocks
    private ThemeJpaService themeJpaService;

    @Test
    void findById() {
        Long id = 5L;
        Optional<Theme> theme = Optional.of(Theme.builder().themeId(id).build());
        when(repository.findById(id)).thenReturn(theme);
        ThemeDto themeDto = ThemeDto.builder().themeId(id).build();
        when(mapper.mapToDto(theme.get())).thenReturn(themeDto);

        ThemeDto result = themeJpaService.findById(id);

        assertNotNull(result);
        assertEquals(themeDto, result);
    }

    @Test
    void save() {
        ThemeDto themeDto = ThemeDto.builder().themeId(1L).build();
        Theme theme = Theme.builder().themeId(1L).build();

        when(mapper.map(themeDto)).thenReturn(theme);
        themeJpaService.save(themeDto);

        verify(repository, times(1)).save(theme);
    }

    @Test
    void findAll() {
        Long id = 5L;
        List<Theme> themes = new ArrayList<>(List.of(Theme.builder().themeId(id).build()));
        when(repository.findAll()).thenReturn(themes);
        ThemeDto themeDto = ThemeDto.builder().themeId(id).build();
        when(mapper.mapToDto(any(Theme.class))).thenReturn(themeDto);

        Collection<ThemeDto> result =  themeJpaService.findAll();

        assertNotNull(result);
        assertEquals(themeDto, result.toArray()[0]);
    }

    @Test
    void delete() {

        themeJpaService.delete(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}