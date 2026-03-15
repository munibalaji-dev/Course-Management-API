package com.munibalaji.CourseManagementSystemAPI.services;

import com.munibalaji.CourseManagementSystemAPI.dtos.CourseDto;
import com.munibalaji.CourseManagementSystemAPI.exceptions.NotFoundException;
import com.munibalaji.CourseManagementSystemAPI.mappers.CourseMapper;
import com.munibalaji.CourseManagementSystemAPI.models.Course;
import com.munibalaji.CourseManagementSystemAPI.repositories.CourseRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static com.munibalaji.CourseManagementSystemAPI.mappers.CourseMapper.entitytoCourseDto;

@Service
public class CourseServiceImplementation implements CourseService{

//    private static final String BASE_URL = "http://localhost:3005/api/courses";
//    private static final String CREATE_COURSE = BASE_URL;
//    private static final String GETALL_COURSES = BASE_URL;
//    private static final String GETCOURSE_BYID = BASE_URL+"/{id}";
//    private static final String UPDATE_COURSE = BASE_URL+"/{id}";
//    private static final String DELETE_COURSE = BASE_URL+"/{id}";


    private RestTemplateBuilder restTemplateBuilder;
    private CourseRepository courseRepository;
    @Autowired
    public CourseServiceImplementation(RestTemplateBuilder restTemplateBuilder,
                                       CourseRepository courseRepository){
        this.restTemplateBuilder = restTemplateBuilder;
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {





//        -----To call an external api I used the rest template-------

//        RestTemplate restTemplate = restTemplateBuilder.build();
//        SecondCourseDto request = CourseMapper.courseDtotoEntity(courseDto);

        // Removed After Mapper Added
//        SecondCourseDto request = new SecondCourseDto();
//        request.setId(courseDto.getId());
//        request.setTitle(courseDto.getTitle());
//        request.setInstructor(courseDto.getInstructor());
//        request.setDuration(courseDto.getDuration());
//        request.setPrice(courseDto.getPrice());

//        ResponseEntity<SecondCourseDto> response = restTemplate.postForEntity(
//                CREATE_COURSE,
//                request,
//                SecondCourseDto.class
//        );
//
//        SecondCourseDto secondCourseDto = response.getBody();
//        return entitytoCourseDto(secondCourseDto);





        // After Connected to my own DB

        Course course = CourseMapper.courseDtotoEntity(courseDto);
        Course savedCourse = courseRepository.save(course);

        return CourseMapper.entitytoCourseDto(savedCourse);

    }

    @Override
    public List<CourseDto> getAllCourses() {

//          -------To call an external api I used the rest template--------


//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<SecondCourseDto[]> response = restTemplate.getForEntity(
//                GETALL_COURSES,
//                SecondCourseDto[].class
//        );
//
//        SecondCourseDto[] secondCourseDto = response.getBody();

//        return Arrays.asList(secondCourseDto);

//        return Arrays.stream(secondCourseDto)
//                .map(CourseMapper::entitytoCourseDto)
//                .toList();


        // After Connected to my own DB
        List<Course> courses = courseRepository.findAll();

        return courses.stream()
                .map(CourseMapper::entitytoCourseDto)
                .toList();



    }

    @Override
    public CourseDto getCourseById(long id) {

//         ------To call an external api I used the rest template-------
//        RestTemplate template = restTemplateBuilder.build();
//
//        ResponseEntity<SecondCourseDto> response = template.getForEntity(
//                GETCOURSE_BYID,
//                SecondCourseDto.class,
//                id
//        );
//
//        SecondCourseDto secondCourseDto = response.getBody();
//
//        return entitytoCourseDto(secondCourseDto);



        // After Connected to my own DB
        Course course = courseRepository.findById(id).orElseThrow(()-> new NotFoundException("Course not found with id : " +id));

        return CourseMapper.entitytoCourseDto(course);




    }

    @Override
    public CourseDto updateCourseById(long id, CourseDto courseDto) {



//       -------- To call an external api I used the rest template----------

//        RestTemplate restTemplate = restTemplateBuilder.build();
//        SecondCourseDto req = CourseMapper.courseDtotoEntity(courseDto);

        // Before To call an external api we use the rest template
        // Removed After Mapper Added
//        SecondCourseDto req = new SecondCourseDto();
//        req.setId(courseDto.getId());
//        req.setTitle(courseDto.getTitle());
//        req.setInstructor(courseDto.getInstructor());
//        req.setPrice(courseDto.getPrice());


//        ResponseEntity<SecondCourseDto> response = restTemplate.exchange(
//                UPDATE_COURSE,
//                HttpMethod.PUT,
//                new HttpEntity<>(req),
//                SecondCourseDto.class,
//                id
//        );
//
//        SecondCourseDto updatedCourse = response.getBody();


        // Removed After Mapper Added
//        CourseDto courseDto1 = new CourseDto();
//        courseDto1.setId(req.getId());
//        courseDto1.setTitle(req.getTitle());
//        courseDto1.setInstructor(req.getInstructor());
//        courseDto1.setDuration(req.getDuration());
//        courseDto1.setPrice(req.getPrice());


//         return entitytoCourseDto(updatedCourse);



        // After Connected to my Own Course Management DataBase
        Course course = courseRepository.findById(id).orElseThrow(()->new RuntimeException("Course Not Found with id : "+id));

        course.setId(courseDto.getId());
        course.setCourseName(courseDto.getCourseName());
        course.setInstructor(courseDto.getInstructor());
        course.setDuration(courseDto.getDuration());
        course.setPrice(courseDto.getPrice());

        Course updatedCourse = courseRepository.save(course);

        return CourseMapper.entitytoCourseDto(updatedCourse);









    }

    @Override
    public CourseDto deleteCourseById(long id) {

//         -------To call an external api I used the rest template--------

//        RestTemplate restTemplate = restTemplateBuilder.build();
//         ResponseEntity<SecondCourseDto> response = restTemplate.exchange(
//                 DELETE_COURSE,
//                 HttpMethod.DELETE,
//                 null,
//                 SecondCourseDto.class,
//                 id
//                 );

        // Removed After Mapper Added
//         SecondCourseDto secondCourseDto = response.getBody();
//
//        return SecondCourseDtoToCourseDto(secondCourseDto);
        //              (or)
//        restTemplate.delete(DELETE_COURSE, id);
//        return null;




        // After Connected to my own database
        Course course = courseRepository.findById(id).orElseThrow(()->new NotFoundException("Course not found with id : "+id));
        courseRepository.delete(course);
        return CourseMapper.entitytoCourseDto(course);




    }
}
