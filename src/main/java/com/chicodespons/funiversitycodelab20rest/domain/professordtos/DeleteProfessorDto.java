package com.chicodespons.funiversitycodelab20rest.domain.professordtos;

public class DeleteProfessorDto {

    private String firstname;

    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public DeleteProfessorDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public DeleteProfessorDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
}
