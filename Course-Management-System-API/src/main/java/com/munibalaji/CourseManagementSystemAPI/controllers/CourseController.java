package com.munibalaji.CourseManagementSystemAPI.controllers;
import com.munibalaji.CourseManagementSystemAPI.dtos.CourseRequestDto;
import com.munibalaji.CourseManagementSystemAPI.dtos.CourseResponseDto;
import com.munibalaji.CourseManagementSystemAPI.responses.ApiResponse;
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
    public ResponseEntity<ApiResponse<CourseResponseDto>>createCourse(@Valid @RequestBody CourseRequestDto courseRequestDto){

//        return new ResponseEntity<>(courseService.createCourse(courseResponseDto), HttpStatus.CREATED);

        CourseResponseDto saved = courseService.createCourse(courseRequestDto);
        ApiResponse<CourseResponseDto> response = new ApiResponse<>(true, "Course created successfully",saved);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @Operation(summary = "Get all courses")
    @GetMapping
    public ResponseEntity<ApiResponse<List<CourseResponseDto>>>getALlCourses(){

//        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);

        List<CourseResponseDto> fetching = courseService.getAllCourses();
        ApiResponse<List<CourseResponseDto>> apiResponse = new ApiResponse(true, "Courses fetched successfully", fetching);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @Operation(summary = "Get course by using course id")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDto>> getCourseById(@PathVariable("id") Long id){

//        return new ResponseEntity<>(courseService.getCourseById(id), HttpStatus.OK);

        CourseResponseDto fetch = courseService.getCourseById(id);
        ApiResponse<CourseResponseDto> apiResponse = new ApiResponse<>(true, "Course fetched successfully", fetch);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @Operation(summary = "Update Course by using course id")
    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<CourseResponseDto>> updateCourseById(@PathVariable("id") Long id, @RequestBody CourseRequestDto courseRequestDto){
//        return new ResponseEntity<>(courseService.updateCourseById(id, courseResponseDto), HttpStatus.OK);

        CourseResponseDto courseResponseDto1 = courseService.updateCourseById(id, courseRequestDto);
        ApiResponse<CourseResponseDto> courseDtoApiResponse = new ApiResponse<>(true, "Course updated successfully", courseResponseDto1);
        return new ResponseEntity<>(courseDtoApiResponse, HttpStatus.OK);

    }

    @Operation(summary = "Delete course by using course id")
    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCourseById(@PathVariable("id") Long id){
//        return new ResponseEntity<>(courseService.deleteCourseById(id), HttpStatus.OK);

        courseService.deleteCourseById(id);
        ApiResponse<Void> deleted = new ApiResponse<>(true, "Course deleted successfully",null);
        return new ResponseEntity<>(deleted, HttpStatus.OK);


    }

}
