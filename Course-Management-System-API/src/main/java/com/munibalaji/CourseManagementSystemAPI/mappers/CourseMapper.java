package com.munibalaji.CourseManagementSystemAPI.mappers;

import com.munibalaji.CourseManagementSystemAPI.dtos.CourseDto;
import com.munibalaji.CourseManagementSystemAPI.models.Course;
import com.munibalaji.CourseManagementSystemAPI.thirdparty_dtos.SecondCourseDto;

public class CourseMapper {

    public static Course courseDtotoEntity(CourseDto courseDto){

        if (courseDto == null){
            return null;
        }
//        SecondCourseDto secondCourseDto = new SecondCourseDto();
//        secondCourseDto.setId(courseDto.getId());
//        secondCourseDto.setTitle(courseDto.getTitle());
//        secondCourseDto.setInstructor(courseDto.getInstructor());
//        secondCourseDto.setDuration(courseDto.getDuration());
//        secondCourseDto.setPrice(courseDto.getPrice());

//        return secondCourseDto;

        Course course = new Course();
        course.setId(courseDto.getId());
        course.setCourseName(courseDto.getCourseName());
        course.setInstructor(courseDto.getInstructor());
        course.setDuration(courseDto.getDuration());
        course.setPrice(courseDto.getPrice());

        return course;
    }
    public static CourseDto entitytoCourseDto(Course course){

        if (course == null){
            return null;
        }
//        CourseDto courseDto = new CourseDto();
//        courseDto.setId(secondCourseDto.getId());
//        courseDto.setTitle(secondCourseDto.getTitle());
//        courseDto.setInstructor(secondCourseDto.getInstructor());
//        courseDto.setDuration(secondCourseDto.getDuration());
//        courseDto.setPrice(secondCourseDto.getPrice());


        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setCourseName(course.getCourseName());
        courseDto.setInstructor(course.getInstructor());
        courseDto.setDuration(course.getDuration());
        courseDto.setPrice(course.getPrice());

        return courseDto;
    }


}
