package com.munibalaji.CourseManagementSystemAPI.services;

import com.munibalaji.CourseManagementSystemAPI.dtos.CourseRequestDto;
import com.munibalaji.CourseManagementSystemAPI.dtos.CourseResponseDto;
import com.munibalaji.CourseManagementSystemAPI.exceptions.NotFoundException;
import com.munibalaji.CourseManagementSystemAPI.mappers.CourseMapper;
import com.munibalaji.CourseManagementSystemAPI.models.Course;
import com.munibalaji.CourseManagementSystemAPI.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public CourseResponseDto createCourse(CourseRequestDto courseRequestDto) {





//        -----To call an external api I used the rest template-------

//        RestTemplate restTemplate = restTemplateBuilder.build();
//        Course saved = CourseMapper.courseRequestDtoToEntity(courseRequestDto);

        // Removed After Mapper Added
//        Course request = new Course();

//        request.setTitle(courseRequestDto.getTitle());
//        request.setInstructor(courseRequestDto.getInstructor());
//        request.setDuration(courseRequestDto.getDuration());
//        request.setPrice(courseRequestDto.getPrice());

//        ResponseEntity<CourseResponseDto> response = restTemplate.postForEntity(
//                CREATE_COURSE,
//                saved,
//                CourseResponseDto.class
//        );
//
//        CourseResponseDto courseres = response.getBody();
//        return courseres;





        // After Connected to my own DB

        Course course = CourseMapper.courseRequestDtotoEntity(courseRequestDto);
        Course savedCourse = courseRepository.save(course);

        return CourseMapper.entitytoCourseResponseDto(savedCourse);

    }

    @Override
    public List<CourseResponseDto> getAllCourses() {

//          -------To call an external api I used the rest template--------


//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<CourseResponseDto[]> response = restTemplate.getForEntity(
//                GETALL_COURSES,
//                CourseResponseDto[].class
//        );
//
//        CourseResponseDto[] courses = response.getBody();

//        return Arrays.asList(courses);


        // After Connected to my own DB
        List<Course> courses = courseRepository.findAll();

        return courses.stream()
                .map(CourseMapper::entitytoCourseResponseDto)
                .toList();



    }

    @Override
    public CourseResponseDto getCourseById(Long id) {

//         ------To call an external api I used the rest template-------
//        RestTemplate template = restTemplateBuilder.build();
//
//        ResponseEntity<CourseResponseDto> response = template.getForEntity(
//                GETCOURSE_BYID,
//                CourseResponseDto.class,
//                id
//        );
//
//        CourseResponseDto getById = response.getBody();
//
//        return getById;



        // After Connected to my own DB
        Course course = courseRepository.findById(id).orElseThrow(()-> new NotFoundException("Course not found with id : " +id));

        return CourseMapper.entitytoCourseResponseDto(course);




    }

    @Override
    public CourseResponseDto updateCourseById(Long id, CourseRequestDto courseRequestDto) {



//       -------- To call an external api I used the rest template----------

//        RestTemplate restTemplate = restTemplateBuilder.build();
//        CourseResponseDto saved = CourseMapper.courseRequestDtoToEntity(courseRequestDto);

        // Before To call an external api we use the rest template
        // Removed After Mapper Added
//        Course req = new Course();

//        req.setTitle(courseRequestDto.getTitle());
//        req.setInstructor(courseRequestDto.getInstructor());
//        req.setPrice(courseRequestDto.getPrice());


//        ResponseEntity<CourseResponseDto> response = restTemplate.exchange(
//                UPDATE_COURSE,
//                HttpMethod.PUT,
//                new HttpEntity<>(saved),
//                CourseResponseDto.class,
//                id
//        );
//
//        CourseResponseDto updatedCourse = response.getBody();

//        return updatedCourse;


        // After Connected to my Own Course Management DataBase
        Course course = courseRepository.findById(id).orElseThrow(()->new NotFoundException("Course Not Found to update with id : "+id));


        course.setCourseName(courseRequestDto.getCoursename());
        course.setInstructor(courseRequestDto.getInstructor());
        course.setDuration(courseRequestDto.getDuration());
        course.setPrice(courseRequestDto.getPrice());

        Course updatedCourse = courseRepository.save(course);

        return CourseMapper.entitytoCourseResponseDto(updatedCourse);









    }

    @Override
    public CourseResponseDto deleteCourseById(Long id) {

//         -------To call an external api I used the rest template--------

//        RestTemplate restTemplate = restTemplateBuilder.build();
//         ResponseEntity<CourseResponseDto> response = restTemplate.exchange(
//                 DELETE_COURSE,
//                 HttpMethod.DELETE,
//                 null,
//                 CourseResponseDto.class,
//                 id
//                 );

        // Removed After Mapper Added
//         CourseResponseDto deleted = response.getBody();
//
//        return deleted;
        //              (or)
//        restTemplate.delete(DELETE_COURSE, id); // here I send the null
//        return null;




        // After Connected to my own database
        Course course = courseRepository.findById(id).orElseThrow(()->new NotFoundException("Course not found to delete with id : "+id));
        courseRepository.delete(course);
        return CourseMapper.entitytoCourseResponseDto(course);




    }
}
