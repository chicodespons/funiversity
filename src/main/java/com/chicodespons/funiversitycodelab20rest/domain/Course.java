package com.chicodespons.funiversitycodelab20rest.domain;

import com.chicodespons.funiversitycodelab20rest.exceptions.UnvalidStudyPointsException;

import java.util.Objects;
import java.util.UUID;

public class Course {

    private final String id;
    private String name;
    private int amountOfStudyPoints;

    private static final int MAX_AMOUNT_OF_STUDYPOINTS = 6;
    private static final int MIN_AMOUNT_OF_STUDYPOINTS = 1;
    private String professorId;


    public Course(String name, int amountOfStudyPoints, String professorId) {

        this.id = UUID.randomUUID().toString();
        this.name = name;
        setAmountOfStudyPoints(amountOfStudyPoints);
        setProfessorId(professorId);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfStudyPoints() {
        return amountOfStudyPoints;
    }

    public void setAmountOfStudyPoints(int amountOfStudyPoints) {
        if (amountOfStudyPoints>= MIN_AMOUNT_OF_STUDYPOINTS || amountOfStudyPoints<=MAX_AMOUNT_OF_STUDYPOINTS) {
            this.amountOfStudyPoints = amountOfStudyPoints;
        }
        else throw new UnvalidStudyPointsException("Amount of studypoints has to be between(and including) 1 and 6");


    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return amountOfStudyPoints == course.amountOfStudyPoints && Objects.equals(id, course.id) && Objects.equals(name, course.name) && Objects.equals(professorId, course.professorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amountOfStudyPoints, professorId);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", amountOfStudyPoints=" + amountOfStudyPoints +
                ", professorId='" + professorId + '\'' +
                '}';
    }
}
