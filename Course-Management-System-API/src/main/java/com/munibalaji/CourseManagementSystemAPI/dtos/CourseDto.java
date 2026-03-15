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
        @NotBlank(message = "Title cannot be empty")
        private String title;
        @NotBlank(message = "Instructor name cannot be empty")
        private String instructor;
        @NotNull(message = "Duration is required")
        private Integer duration;
        @Positive(message = "Price must be greater than 0")
        private Double price;
}
