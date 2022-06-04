package com.demo.rest.webservices.restfulwebservices.handler;

import com.demo.rest.webservices.restfulwebservices.exception.ServiceException;
import com.demo.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ServiceResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ServiceException serviceException = new ServiceException(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(serviceException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex, WebRequest request) {
        ServiceException serviceException = new ServiceException(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(serviceException, HttpStatus.NOT_FOUND);
    }

}
