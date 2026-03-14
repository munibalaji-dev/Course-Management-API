package com.munibalaji.CourseManagementSystemAPI.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {

        private long id;
        private String title;
        private String instructor;
        private int duration;
        private double price;
}
