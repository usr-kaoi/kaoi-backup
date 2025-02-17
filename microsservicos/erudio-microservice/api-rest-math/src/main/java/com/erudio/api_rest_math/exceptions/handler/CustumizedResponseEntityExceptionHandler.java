package com.erudio.api_rest_math.exceptions.handler;

import com.erudio.api_rest_math.exceptions.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustumizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    public final ResponseEntity<ExceptionResponse> handlerAllExceptions(Exception ex, WebRequest request) {

    }
}
