package com.application.quizgenbackend.infrastructure.exception;

import com.application.quizgenbackend.quiz.exception.BadAnswerRequestException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CommonControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleInvalidForms(MethodArgumentNotValidException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        List<String> errorMessages = getErrorMessages(ex);
        ApiError error = new ApiError(ZonedDateTime.now(ZoneId.of("Z")), status.value(), status, ex.getMessage(), errorMessages, request.getServletPath());
        return generateDefaultResponse(error, status);
    }

    @ExceptionHandler(BadAnswerRequestException.class)
    public ResponseEntity<Object> handleBadAnswerRequests(ApiLevelException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ApiError error = new ApiError(ZonedDateTime.now(ZoneId.of("Z")), status.value(), status, ex.getMessage(), request.getServletPath());
        return generateDefaultResponse(error, status);
    }

    private List<String> getErrorMessages(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                 .getAllErrors()
                 .stream()
                 .map(DefaultMessageSourceResolvable::getDefaultMessage)
                 .collect(Collectors.toList());
    }

    private ResponseEntity<Object> generateDefaultResponse(ApiError error, HttpStatus status) {
        return new ResponseEntity<>(error, new HttpHeaders(), status);
    }

}
