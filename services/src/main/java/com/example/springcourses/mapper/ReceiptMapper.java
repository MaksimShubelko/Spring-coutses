package com.example.springcourses.mapper;

import com.example.springcourses.dto.ReceiptDto;
import com.example.springcourses.entity.Receipt;
import org.mapstruct.Mapper;

@Mapper(uses = {StudentMapper.class, RequestMapper.class})
public interface ReceiptMapper {

    Receipt map(ReceiptDto dto);

    ReceiptDto mapToDto(Receipt entity);
}
