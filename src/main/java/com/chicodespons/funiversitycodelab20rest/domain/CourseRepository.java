package com.chicodespons.funiversitycodelab20rest.domain;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CourseRepository {

    private final Map<String, Course> coursesById;

   public CourseRepository(){
       this.coursesById = new HashMap<>();
   }

    public Collection<Course> getAllCourses() {
        return coursesById.values();
    }

    public void addCourse(Course course) {

       coursesById.put(course.getId(), course);
    }
}
