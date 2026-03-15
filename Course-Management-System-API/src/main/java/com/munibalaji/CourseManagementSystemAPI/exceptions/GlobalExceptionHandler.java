package com.munibalaji.CourseManagementSystemAPI.exceptions;

import com.munibalaji.CourseManagementSystemAPI.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException){
//        return new ResponseEntity<>(new ExceptionDto(notFoundException.getMessage(),HttpStatus.NOT_FOUND.value());

        ExceptionDto exceptionDto = new ExceptionDto(notFoundException.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);

    }


}
