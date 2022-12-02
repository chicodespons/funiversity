package com.chicodespons.funiversitycodelab20rest.domain;

import com.chicodespons.funiversitycodelab20rest.exceptions.UnvalidIdException;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    private final ProfessorRepository professorRepository;

    public CourseMapper(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public CourseDto mapToCourseDto(Course course) {

        return new CourseDto().setId(course.getId())
                .setName(course.getName())
                .setAmountOfStudyPoints(course.getAmountOfStudyPoints());
    }

    public Course mapToCourse(CourseDto courseDto) {

        if(professorRepository.getProfessorById(courseDto.getProfessorId()) == null) {
            throw new UnvalidIdException("No Professor found with this id " + courseDto.getProfessorId());
        } else
            return new Course(courseDto.getName(), courseDto.getAmountOfStudyPoints(), courseDto.getProfessorId());

    }


}
