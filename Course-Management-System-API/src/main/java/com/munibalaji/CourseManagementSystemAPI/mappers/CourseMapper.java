package com.munibalaji.CourseManagementSystemAPI.mappers;

import com.munibalaji.CourseManagementSystemAPI.dtos.CourseRequestDto;
import com.munibalaji.CourseManagementSystemAPI.dtos.CourseResponseDto;
import com.munibalaji.CourseManagementSystemAPI.models.Course;

public class CourseMapper {

    public static Course courseRequestDtotoEntity(CourseRequestDto courseRequestDto){

        if (courseRequestDto == null){
            return null;
        }
        // when i am using the rest template I wrote this mapping
//        SecondCourseDto secondCourseDto = new SecondCourseDto();
//        secondCourseDto.setId(courseResponseDto.getId());
//        secondCourseDto.setTitle(courseResponseDto.getTitle());
//        secondCourseDto.setInstructor(courseResponseDto.getInstructor());
//        secondCourseDto.setDuration(courseResponseDto.getDuration());
//        secondCourseDto.setPrice(courseResponseDto.getPrice());

//        return secondCourseDto;

        Course course = new Course();
//        course.setId(courseRequestDto.getId());
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
        // when i am using the rest template I wrote this mapping
//        CourseResponseDto courseResponseDto = new CourseResponseDto();
//        courseResponseDto.setId(secondCourseDto.getId());
//        courseResponseDto.setTitle(secondCourseDto.getTitle());
//        courseResponseDto.setInstructor(secondCourseDto.getInstructor());
//        courseResponseDto.setDuration(secondCourseDto.getDuration());
//        courseResponseDto.setPrice(secondCourseDto.getPrice());


        CourseResponseDto courseResponseDto = new CourseResponseDto();
        courseResponseDto.setId(course.getId());
        courseResponseDto.setCourseName(course.getCourseName());
        courseResponseDto.setInstructor(course.getInstructor());
        courseResponseDto.setDuration(course.getDuration());
        courseResponseDto.setPrice(course.getPrice());

        return courseResponseDto;
    }


}
