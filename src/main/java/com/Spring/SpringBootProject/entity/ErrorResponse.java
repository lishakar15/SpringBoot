package com.Spring.SpringBootProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * This class is created to show custom error JSON object
 */
public class ErrorResponse {
    private HttpStatus httpStatus;
    private String errMsg;
}
