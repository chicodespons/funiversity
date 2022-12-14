package com.chicodespons.funiversitycodelab20rest.api;

import com.chicodespons.funiversitycodelab20rest.exceptions.UnvalidIdException;
import com.chicodespons.funiversitycodelab20rest.exceptions.UnvalidStudyPointsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UnvalidIdException.class)
    protected void UnvalidIdException(UnvalidIdException ex, HttpServletResponse response) throws
            IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(UnvalidStudyPointsException.class)
    protected void UnvalidStudyPointsException(UnvalidStudyPointsException ex, HttpServletResponse response) throws
            IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

}
