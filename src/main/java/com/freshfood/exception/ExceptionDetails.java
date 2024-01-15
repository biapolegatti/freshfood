package com.freshfood.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ExceptionDetails {

    private String title;

    private Integer status;

    private String message;

    private LocalDateTime timestamp;
}
