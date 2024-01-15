package com.freshfood.exception.handler;

import com.freshfood.exception.BadRequestException;
import com.freshfood.exception.ExceptionDetails;
import com.freshfood.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ExceptionDetails handlerNotFoundException(Exception ex) {
        return ExceptionDetails.builder()
                .title("Not found")
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    public ExceptionDetails handlerBadRequestException(Exception ex) {
        return ExceptionDetails.builder()
                .title("Bad request")
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
