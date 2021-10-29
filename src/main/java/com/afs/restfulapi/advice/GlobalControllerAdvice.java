package com.afs.restfulapi.advice;

import com.afs.restfulapi.exception.CompanyNotFoundException;
import com.afs.restfulapi.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GlobalControllerAdvice {
    @ExceptionHandler({CompanyNotFoundException.class, EmployeeNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFoundExceptionHandler(Exception exception){
        return new ErrorResponse(404, exception.getMessage());
    }
}
