package com.munibalaji.CourseManagementSystemAPI.controllers;
import com.munibalaji.CourseManagementSystemAPI.dtos.CourseDto;
import com.munibalaji.CourseManagementSystemAPI.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }


    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto){
        return new ResponseEntity<>(courseService.createCourse(courseDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllStudents(){
        return new ResponseEntity<>(courseService.getAllStudents(), HttpStatus.OK);
    }
}
