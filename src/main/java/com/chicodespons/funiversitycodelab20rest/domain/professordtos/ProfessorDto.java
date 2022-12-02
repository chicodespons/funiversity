package com.chicodespons.funiversitycodelab20rest.domain.professordtos;

public class ProfessorDto {

private String id;
private String firstname;
private String lastname;

    public String getId() {
        return id;
    }

    public ProfessorDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public ProfessorDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public ProfessorDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
}
