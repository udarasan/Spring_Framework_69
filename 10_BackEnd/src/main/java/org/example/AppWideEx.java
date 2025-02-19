package org.example;

@RestControllerAdvice
public class AppWideExceptionHandler {

    // Handle a generic exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> handleGlobalException(Exception ex) {
        ResponseDTO response = new ResponseDTO("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
