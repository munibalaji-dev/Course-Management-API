package com.munibalaji.CourseManagementSystemAPI.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Course extends BaseModel {

    private String title;
    private String instructor;
    private int duration;
    private double price;

}
