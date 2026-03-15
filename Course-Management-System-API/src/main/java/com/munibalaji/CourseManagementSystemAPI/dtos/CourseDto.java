package com.munibalaji.CourseManagementSystemAPI.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {

        private long id;
        @NotBlank
        private String courseName;
        @NotBlank
        private String instructor;
        @NotNull
        private Integer duration;
        @Positive
        private Double price;
}
