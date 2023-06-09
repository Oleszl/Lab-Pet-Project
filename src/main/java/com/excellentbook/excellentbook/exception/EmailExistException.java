package com.excellentbook.excellentbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailExistException extends RuntimeException {

    public EmailExistException(String emailValue) {
        super(String.format("Email: '%s' already exists in the system", emailValue));
    }

}
