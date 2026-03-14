package com.munibalaji.CourseManagementSystemAPI.services;

import com.munibalaji.CourseManagementSystemAPI.dtos.CourseDto;
import com.munibalaji.CourseManagementSystemAPI.thirdparty_dtos.CourseSecondDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CourseServiceImplementation implements CourseService{

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String CREATE_COURSE = BASE_URL;
    private static final String GETALL_COURSES = BASE_URL;
//    private static final String GETCOURSE_BYID = BASE_URL+"/{id}";
//    private static final String UPDATE_COURSE = BASE_URL+"/{id}";
//    private static final String DELETE_COURSE = BASE_URL+"/{id}";


    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    public CourseServiceImplementation(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {

        RestTemplate restTemplate = restTemplateBuilder.build();

        CourseSecondDto request = new CourseSecondDto();
        request.setId(courseDto.getId());
        request.setTitle(courseDto.getTitle());
        request.setInstructor(courseDto.getInstructor());
        request.setDuration(courseDto.getDuration());
        request.setPrice(courseDto.getPrice());


        ResponseEntity<CourseSecondDto> response = restTemplate.postForEntity(
                CREATE_COURSE,
                request,
                CourseSecondDto.class
                );

        CourseSecondDto courseSecondDto = response.getBody();
        return courseSecondDto;
    }

    @Override
    public List<CourseDto> getAllStudents() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<CourseSecondDto[]> response = restTemplate.getForEntity(
                GETALL_COURSES,
                CourseSecondDto[].class
        );

        CourseSecondDto[] courseSecondDto = response.getBody();

        return Arrays.asList(courseSecondDto);
    }
}
