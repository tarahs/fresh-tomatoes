package com.slalom.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by tara
 */
public class BadRequestException extends ActionFailureException {


    public BadRequestException( String message )
    {
        super(message, HttpStatus.BAD_REQUEST.value());
    }

    public BadRequestException( String message, Object value )
    {
        super(message, value);
    }

    @Override
    public Integer getStatus()
    {
        return HttpStatus.BAD_REQUEST.value();
    }
}
