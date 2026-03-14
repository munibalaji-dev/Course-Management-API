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

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable("id") long id){
        return new ResponseEntity<>(courseService.getCourseById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CourseDto> updateCourseById(@PathVariable("id") long id, @RequestBody CourseDto courseDto){
        return new ResponseEntity<>(courseService.updateCourseById(id, courseDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CourseDto> deleteCourseById(@PathVariable("id") long id){
        return new ResponseEntity<>(courseService.deleteCourseById(id), HttpStatus.OK);
    }
}
