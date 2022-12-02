package com.chicodespons.funiversitycodelab20rest.domain;

import com.chicodespons.funiversitycodelab20rest.exceptions.UnvalidIdException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class ProfessorRepository {

    private final Map<String, Professor> professorsById;

    public ProfessorRepository() {
        this.professorsById = new HashMap<>();
    }

    public Collection<Professor> getAll(){
        return professorsById.values();
    }


    public void add(Professor professor) {

        professorsById.put(professor.getId(), professor);
    }

    public Professor getProfessorById(String id) {

        Professor professor = professorsById.get(id);
        if(professor== null) {
            throw new UnvalidIdException("No Professor found with this id " + id);
        }
        return professor;
    }

    public void deleteProfessorById(String id) {

        professorsById.remove(id);

    }





}
