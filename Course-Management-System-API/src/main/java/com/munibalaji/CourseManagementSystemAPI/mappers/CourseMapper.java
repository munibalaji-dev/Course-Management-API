package com.munibalaji.CourseManagementSystemAPI.mappers;

import com.munibalaji.CourseManagementSystemAPI.dtos.CourseRequestDto;
import com.munibalaji.CourseManagementSystemAPI.dtos.CourseResponseDto;
import com.munibalaji.CourseManagementSystemAPI.models.Course;

public class CourseMapper {

    public static Course courseRequestDtotoEntity(CourseRequestDto courseRequestDto){

        if (courseRequestDto == null){
            return null;
        }

        Course course = new Course();

        course.setCourseName(courseRequestDto.getCoursename());
        course.setInstructor(courseRequestDto.getInstructor());
        course.setDuration(courseRequestDto.getDuration());
        course.setPrice(courseRequestDto.getPrice());

        return course;
    }
    public static CourseResponseDto entitytoCourseResponseDto(Course course){

        if (course == null){
            return null;
        }


        CourseResponseDto courseResponseDto = new CourseResponseDto();
        courseResponseDto.setId(course.getId());
        courseResponseDto.setCourseName(course.getCourseName());
        courseResponseDto.setInstructor(course.getInstructor());
        courseResponseDto.setDuration(course.getDuration());
        courseResponseDto.setPrice(course.getPrice());

        return courseResponseDto;
    }


}
