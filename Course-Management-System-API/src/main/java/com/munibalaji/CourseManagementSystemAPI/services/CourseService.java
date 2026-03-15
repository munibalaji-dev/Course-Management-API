package com.munibalaji.CourseManagementSystemAPI.services;

import com.munibalaji.CourseManagementSystemAPI.dtos.CourseDto;

import java.util.List;

public interface CourseService {
    CourseDto createCourse(CourseDto courseDto);

    List<CourseDto> getAllCourses();

    CourseDto getCourseById(long id);

    CourseDto updateCourseById(long id, CourseDto courseDto);

    CourseDto deleteCourseById(long id);
}
