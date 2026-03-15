package com.munibalaji.CourseManagementSystemAPI.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Course extends BaseModel {

    private String courseName;
    private String instructor;
    private Integer duration;
    private Double price;

}
