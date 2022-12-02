package com.chicodespons.funiversitycodelab20rest.service;

import com.chicodespons.funiversitycodelab20rest.domain.Professor;
import com.chicodespons.funiversitycodelab20rest.domain.ProfessorMapper;
import com.chicodespons.funiversitycodelab20rest.domain.ProfessorRepository;
import com.chicodespons.funiversitycodelab20rest.domain.professordtos.ProfessorDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorService(ProfessorRepository professorRepository, ProfessorMapper professorMapper) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    public ProfessorDto patchProfessor(String id, JsonPatch patch) throws JsonPatchException,JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        ProfessorDto professorToPatch = professorMapper.mapToProfessorDTO(professorRepository.getProfessorById(id));
        JsonNode patched = patch.apply(objectMapper.convertValue(professorToPatch, JsonNode.class));

        ProfessorDto professorIsPatched = objectMapper.treeToValue(patched, ProfessorDto.class);
        professorToPatch.setLastname(professorIsPatched.getLastname());
        professorToPatch.setFirstname(professorIsPatched.getFirstname());
        Professor professorFromDataBase = professorRepository.getProfessorById(id);
        professorFromDataBase.setFirstname(professorIsPatched.getFirstname());
        professorFromDataBase.setLastname(professorIsPatched.getLastname());
        return professorToPatch;

    }

}
