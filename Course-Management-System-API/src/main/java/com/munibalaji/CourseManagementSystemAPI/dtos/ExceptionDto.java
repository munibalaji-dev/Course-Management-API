package com.munibalaji.CourseManagementSystemAPI.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Getter
@Setter
public class ExceptionDto{

    private String message;
    private int httpStatus;
    private LocalDate timestamp;

    public ExceptionDto(String message, int httpStatus){ // here why I shouldn't pass timestamp Because timestamp should be generated automatically, not passed manually
        this.httpStatus = httpStatus;
        this.message = message;
        this.timestamp = LocalDate.now();

    }

}
