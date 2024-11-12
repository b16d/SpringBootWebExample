package com.training.web.rest;

import com.training.web.domain.exception.BadUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@RestControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);


    @ExceptionHandler(BadUserException.class)
    public ProblemDetail handelBadUser(BadUserException badUserException) {
        logger.error(badUserException.getMessage());

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, badUserException.getMessage());
        problemDetail.setTitle("User Not Found");
        problemDetail.setProperty("errorCategory", "User not found");
        problemDetail.setProperty("timestamp", Instant.now());

       return problemDetail;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception exception) {
        logger.error(exception.getMessage());

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        problemDetail.setTitle("Internal Error");
        problemDetail.setProperty("errorCategory", "Internal Error");
        problemDetail.setProperty("timestamp", Instant.now());

        return problemDetail;
    }
}
