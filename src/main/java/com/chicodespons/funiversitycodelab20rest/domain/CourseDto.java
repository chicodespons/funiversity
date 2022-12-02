package com.chicodespons.funiversitycodelab20rest.domain;

public class CourseDto {

    private  String id;
    private String name;
    private int amountOfStudyPoints;

    private String professorId;

    public String getId() {
        return id;
    }

    public CourseDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CourseDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getAmountOfStudyPoints() {
        return amountOfStudyPoints;
    }

    public CourseDto setAmountOfStudyPoints(int amountOfStudyPoints) {
        this.amountOfStudyPoints = amountOfStudyPoints;
        return this;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }
}
