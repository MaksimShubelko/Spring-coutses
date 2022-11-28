package com.example.springcourses.dto;

import com.example.springcourses.entity.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class StudentDto {

    private Long studentId;

    private List<AcademicPerformanceDto> academicPerformancesDtos;

    private GroupDto groupDto;

    private List<ReceiptDto> receiptsDtos;

    private Double totalMark;

    private List<RequestDto> requests;

}
