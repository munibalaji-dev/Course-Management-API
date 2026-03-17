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
//        SecondCourseDto request = CourseMapper.courseDtotoEntity(courseResponseDto);

        // Removed After Mapper Added
//        SecondCourseDto request = new SecondCourseDto();
//        request.setId(courseResponseDto.getId());
//        request.setTitle(courseResponseDto.getTitle());
//        request.setInstructor(courseResponseDto.getInstructor());
//        request.setDuration(courseResponseDto.getDuration());
//        request.setPrice(courseResponseDto.getPrice());

//        ResponseEntity<SecondCourseDto> response = restTemplate.postForEntity(
//                CREATE_COURSE,
//                request,
//                SecondCourseDto.class
//        );
//
//        SecondCourseDto secondCourseDto = response.getBody();
//        return entitytoCourseDto(secondCourseDto);





        // After Connected to my own DB

        Course course = CourseMapper.courseRequestDtotoEntity(courseRequestDto);
        Course savedCourse = courseRepository.save(course);

        return CourseMapper.entitytoCourseResponseDto(savedCourse);

    }

    @Override
    public List<CourseResponseDto> getAllCourses() {

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
                .map(CourseMapper::entitytoCourseResponseDto)
                .toList();



    }

    @Override
    public CourseResponseDto getCourseById(Long id) {

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

        return CourseMapper.entitytoCourseResponseDto(course);




    }

    @Override
    public CourseResponseDto updateCourseById(Long id, CourseRequestDto courseRequestDto) {



//       -------- To call an external api I used the rest template----------

//        RestTemplate restTemplate = restTemplateBuilder.build();
//        SecondCourseDto req = CourseMapper.courseDtotoEntity(courseResponseDto);

        // Before To call an external api we use the rest template
        // Removed After Mapper Added
//        SecondCourseDto req = new SecondCourseDto();
//        req.setId(courseResponseDto.getId());
//        req.setTitle(courseResponseDto.getTitle());
//        req.setInstructor(courseResponseDto.getInstructor());
//        req.setPrice(courseResponseDto.getPrice());


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
//        CourseResponseDto courseDto1 = new CourseResponseDto();
//        courseDto1.setId(req.getId());
//        courseDto1.setTitle(req.getTitle());
//        courseDto1.setInstructor(req.getInstructor());
//        courseDto1.setDuration(req.getDuration());
//        courseDto1.setPrice(req.getPrice());


//         return entitytoCourseDto(updatedCourse);



        // After Connected to my Own Course Management DataBase
        Course course = courseRepository.findById(id).orElseThrow(()->new RuntimeException("Course Not Found with id : "+id));

//        course.setId(courseRequestDto.getId());
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
//        return SecondCourseDtoToCourseDto(secondCourseDto); // I provide data in return even delete happen
        //              (or)
//        restTemplate.delete(DELETE_COURSE, id); // here I send the null
//        return null;




        // After Connected to my own database
        Course course = courseRepository.findById(id).orElseThrow(()->new NotFoundException("Course not found with id : "+id));
        courseRepository.delete(course);
        return CourseMapper.entitytoCourseResponseDto(course);




    }
}
