package com.munibalaji.CourseManagementSystemAPI.services;

import com.munibalaji.CourseManagementSystemAPI.dtos.CourseRequestDto;
import com.munibalaji.CourseManagementSystemAPI.dtos.CourseResponseDto;

import java.util.List;

public interface CourseService {
    CourseResponseDto createCourse(CourseRequestDto courseRequestDto);

    List<CourseResponseDto> getAllCourses();

    CourseResponseDto getCourseById(Long id);

    CourseResponseDto updateCourseById(Long id, CourseRequestDto courseRequestDto);

    CourseResponseDto deleteCourseById(Long id);
}
