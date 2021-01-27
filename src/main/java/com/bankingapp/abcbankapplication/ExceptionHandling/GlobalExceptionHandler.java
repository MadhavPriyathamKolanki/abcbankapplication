package com.bankingapp.abcbankapplication.ExceptionHandling;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice	
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler  {

	@ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<CustomResponse> accountHolderNotFoundException(CustomerNotFoundException ex, WebRequest request) {
		CustomResponse errorDetails = new CustomResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(InvalidAccountNumberException.class)
    public ResponseEntity<CustomResponse> invalidAccountNumberException(InvalidAccountNumberException ex, WebRequest request) {
		CustomResponse errorDetails = new CustomResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        
    }
	@ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<CustomResponse> insufficientFundsException(InsufficientFundsException ex, WebRequest request) {
		CustomResponse errorDetails = new CustomResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<CustomResponse> AdminNotFoundException(AdminNotFoundException ex, WebRequest request) {
		CustomResponse errorDetails = new CustomResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
	@ExceptionHandler(Exception.class)
    public ResponseEntity<CustomResponse> globleExcpetionHandler(Exception ex, WebRequest request) {
		CustomResponse errorDetails = new CustomResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
