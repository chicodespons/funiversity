package com.chicodespons.funiversitycodelab20rest.domain;

import com.chicodespons.funiversitycodelab20rest.domain.professordtos.CreateProfessorDto;
import com.chicodespons.funiversitycodelab20rest.domain.professordtos.ProfessorDto;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public ProfessorDto mapToProfessorDTO(Professor professor) {

        return new ProfessorDto().setId(professor.getId())
                .setFirstname(professor.getFirstname())
                .setLastname(professor.getLastname());
    }

    public Professor mapToProfessor(CreateProfessorDto createProfessorDto) {

        return new Professor(createProfessorDto.getFirstname(), createProfessorDto.getLastname());
    }

}
