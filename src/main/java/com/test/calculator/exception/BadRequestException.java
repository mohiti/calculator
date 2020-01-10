package com.test.calculator.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Enter a valid input please")
@NoArgsConstructor
public class BadRequestException extends NumberFormatException {

    private static final long serialVersionUID = 1L;

}