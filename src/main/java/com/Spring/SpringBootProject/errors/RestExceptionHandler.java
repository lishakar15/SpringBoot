package com.Spring.SpringBootProject.errors;

import com.Spring.SpringBootProject.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = DepartmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDepartmentNotPresent(DepartmentNotFoundException ex, WebRequest req)
    {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
