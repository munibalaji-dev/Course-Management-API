package com.munibalaji.CourseManagementSystemAPI.controllers;
import com.munibalaji.CourseManagementSystemAPI.dtos.CourseDto;
import com.munibalaji.CourseManagementSystemAPI.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Course API", description = "Operations related to courses")
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }


    @Operation(summary = "Create a new course")
    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CourseDto courseDto){
        return new ResponseEntity<>(courseService.createCourse(courseDto), HttpStatus.CREATED);

    }

    @Operation(summary = "Get all courses")
    @GetMapping
    public ResponseEntity<List<CourseDto>> getALlCourses(){
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @Operation(summary = "Get course by using course id")
    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable("id") long id){
        return new ResponseEntity<>(courseService.getCourseById(id), HttpStatus.OK);
    }

    @Operation(summary = "Update Course by using course id")
    @PutMapping("{id}")
    public ResponseEntity<CourseDto> updateCourseById(@PathVariable("id") long id, @RequestBody CourseDto courseDto){
        return new ResponseEntity<>(courseService.updateCourseById(id, courseDto), HttpStatus.OK);
    }

    @Operation(summary = "Delete course by using course id")
    @DeleteMapping("{id}")
    public ResponseEntity<CourseDto> deleteCourseById(@PathVariable("id") long id){
        return new ResponseEntity<>(courseService.deleteCourseById(id), HttpStatus.OK);
//        courseService.deleteCourseById(id);
//        return ResponseEntity.noContent().build();
    }

}
