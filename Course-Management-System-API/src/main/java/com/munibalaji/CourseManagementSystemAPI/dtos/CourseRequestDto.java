package com.munibalaji.CourseManagementSystemAPI.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequestDto {

    @NotBlank(message = "Course name cannot be empty")
    private String coursename;
    @NotBlank(message = "Instructor cannot be empty")
    private String instructor;
    private Integer duration;
    @Positive
    private Double price;
}
