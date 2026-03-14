package com.munibalaji.CourseManagementSystemAPI.services;

import com.munibalaji.CourseManagementSystemAPI.dtos.CourseDto;
import com.munibalaji.CourseManagementSystemAPI.models.Course;

import java.util.List;

public interface CourseService {
    CourseDto createCourse(CourseDto courseDto);

    List<CourseDto> getAllStudents();

    CourseDto getCourseById(long id);

    CourseDto updateCourseById(long id, CourseDto courseDto);
}
