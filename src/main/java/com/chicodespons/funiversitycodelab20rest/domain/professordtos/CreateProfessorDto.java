package com.chicodespons.funiversitycodelab20rest.domain.professordtos;

public class CreateProfessorDto {

    private String firstname;

    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public CreateProfessorDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public CreateProfessorDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
}
