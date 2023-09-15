package com.ticket.concertticketmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DuplicateUserException extends RuntimeException {
    private String resourceName;
    private Object fieldValue;

    public DuplicateUserException( String resourceName, Object fieldValue) {
        super(String.format("%s user with %s already exist", resourceName, fieldValue));
        this.resourceName = resourceName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}