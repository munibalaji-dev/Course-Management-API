package com.munibalaji.CourseManagementSystemAPI.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {

    private String title;
    private String instructor;
    private int duration;
    private double price;

}
