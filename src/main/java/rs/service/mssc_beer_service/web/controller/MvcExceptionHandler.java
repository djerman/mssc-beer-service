package rs.service.mssc_beer_service.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException e){
	List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

	e.getConstraintViolations().forEach(constraintViolations -> {
	    errors.add(constraintViolations.toString());
	});

	return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
