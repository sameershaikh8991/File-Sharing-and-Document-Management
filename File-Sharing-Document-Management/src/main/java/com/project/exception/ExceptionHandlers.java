package com.project.exception;

import com.project.domain.response.AppResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ExceptionHandlers {

    @ExceptionHandler(ValidatorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public AppResponse handleValidatorException(final ValidatorException ex) {
        log.error("Validation error: {} ",ex.getMessage());
        return new AppResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(),
                ex.getMessage(), null, ex.getMessage());
    }
}
