package com.clement.fokuz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class customExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ProblemDetail> handleGenericException(Exception e) {
        return problemDetailBuild(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    private ResponseEntity<ProblemDetail> problemDetailBuild(HttpStatus httpStatus, String message) {
        ProblemDetail pd = ProblemDetail.forStatus(httpStatus);
        pd.setDetail(message);

        return ResponseEntity.status(httpStatus).body(pd);
    }

}
