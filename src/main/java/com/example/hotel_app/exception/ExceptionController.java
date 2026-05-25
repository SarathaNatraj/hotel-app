package com.example.hotel_app.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class ExceptionController {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> customerNotFound(CustomerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<String> roomNotFound(RoomNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handle(Exception ex, WebRequest req) throws Exception {

        String path = req.getDescription(false); // e.g. "uri=/api/rooms"

        // Never catch Swagger exceptions
        if (path.contains("/swagger-ui") || path.contains("/v3/api-docs")) {
            throw ex; // allow swagger to work normally
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error from Global Handler");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<String> noHandlerFound(NoHandlerFoundException ex) throws Exception {

        String url = ex.getRequestURL();

        // Dont block swagger
        if (url.contains("/swagger-ui") || url.contains("/v3/api-docs")) {
            throw ex;
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("URL Not Found: " + url);
    }
}
