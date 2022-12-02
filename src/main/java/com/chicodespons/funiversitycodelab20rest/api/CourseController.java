package com.chicodespons.funiversitycodelab20rest.api;

import com.chicodespons.funiversitycodelab20rest.domain.Course;
import com.chicodespons.funiversitycodelab20rest.domain.CourseDto;
import com.chicodespons.funiversitycodelab20rest.domain.CourseMapper;
import com.chicodespons.funiversitycodelab20rest.domain.CourseRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/courses")
public class CourseController {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseController(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CourseDto> getAllCourses(){

        return courseRepository.getAllCourses().stream().map(courseMapper::mapToCourseDto)
                .collect(Collectors.toList());

    }

    @PostMapping(path = "/createcourse", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Course createCourse(@RequestBody CourseDto courseDto) {

        Course course = courseMapper.mapToCourse(courseDto);
        courseRepository.addCourse(course);
        return course;
    }






}
