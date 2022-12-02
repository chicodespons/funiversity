package com.chicodespons.funiversitycodelab20rest.api;

import com.chicodespons.funiversitycodelab20rest.domain.*;
import com.chicodespons.funiversitycodelab20rest.domain.professordtos.CreateProfessorDto;
import com.chicodespons.funiversitycodelab20rest.domain.professordtos.ProfessorDto;
import com.chicodespons.funiversitycodelab20rest.domain.professordtos.UpdateProfessorDto;
import com.chicodespons.funiversitycodelab20rest.professorsecurity.Feature;
import com.chicodespons.funiversitycodelab20rest.service.ProfessorService;
import com.chicodespons.funiversitycodelab20rest.professorsecurity.SecurityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/professors")
public class ProfessorController {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    private final ProfessorService professorService;

    private final SecurityService securityService;

    public ProfessorController(ProfessorRepository professorRepository, ProfessorMapper professorMapper, ProfessorService professorService, SecurityService securityService) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
        this.professorService = professorService;
        this.securityService = securityService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<ProfessorDto> getAllProfessors(@RequestHeader String authorization) {
        securityService.validateAuthorization(authorization, Feature.GET_ALL_PROFESSORS);
        return professorRepository.getAll().stream()
                .map(professorMapper::mapToProfessorDTO)
                .collect(Collectors.toList());
    }

    @PostMapping(path = "/createprofessor" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProfessorDto createNewProfessor(@RequestBody CreateProfessorDto createProfessorDto){

        Professor professor = professorMapper.mapToProfessor(createProfessorDto);
        professorRepository.add(professor);
        return professorMapper.mapToProfessorDTO(professor);

    }

    @GetMapping(path = "/getprofessorbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDto getProfessorById(@PathVariable String id) {
//        try {
            Professor professor = professorRepository.getProfessorById(id);
            return professorMapper.mapToProfessorDTO(professor);
//        } catch (UnvalidIdException exception){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage(), exception);
//        }

    }

    @PutMapping(path = "/updateprofessor/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProfessorDto updateProfessorGivenId(@RequestBody UpdateProfessorDto updateProfessorDto, @PathVariable String id){

        Professor professor = professorRepository.getProfessorById(id);
        professor.setFirstname(updateProfessorDto.getFirstname());
        professor.setLastname(updateProfessorDto.getLastname());
        return professorMapper.mapToProfessorDTO(professor);

    }

    @DeleteMapping(path = "/deleteprofessor/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProfessorGivenId(@PathVariable String id) {

        professorRepository.deleteProfessorById(id);
    }

    //handige patch => moet niet heel het object doorgeven om iets te veranderen!!!!
    @PatchMapping(path = "/changeprofessor/{id}", consumes = "application/json-patch+json")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDto changeProfessor(@PathVariable String id, @RequestBody JsonPatch patch) throws JsonPatchException, JsonProcessingException {

        return professorService.patchProfessor(id, patch);

    }




//    @ExceptionHandler(UnvalidIdException.class)
//    protected void UnvalidIdException(UnvalidIdException ex, HttpServletResponse response) throws
//            IOException {
//        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
//    }


}
