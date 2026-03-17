package com.munibalaji.CourseManagementSystemAPI.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseResponseDto {

        private long id;
        private String courseName;
        private String instructor;
        private Integer duration;
        private Double price;
}
