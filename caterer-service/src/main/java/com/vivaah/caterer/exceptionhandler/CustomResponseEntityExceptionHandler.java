package com.vivaah.caterer.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.vivaah.caterer.exceptions.CatererDoesNotExistException;
import com.vivaah.caterer.exceptions.CatererNameCannotBeEmptyException;
import com.vivaah.caterer.exceptions.FieldCannotBeEmptyException;
import com.vivaah.caterer.exceptions.NoCatererPresentException;
import com.vivaah.caterer.response.ExceptionResponse;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler {

/* Caterer specific exceptions */
	
	//For search by id
	@ExceptionHandler(CatererDoesNotExistException.class)
	public ResponseEntity<?> handleVendorDoesNotExistException(CatererDoesNotExistException vendorDoesNotExistException, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(vendorDoesNotExistException.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FieldCannotBeEmptyException.class)
	public ResponseEntity<?> handleFieldCannotBeEmptyException(FieldCannotBeEmptyException fieldCannotBeEmptyException, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(fieldCannotBeEmptyException.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	//for list
	@ExceptionHandler(NoCatererPresentException.class)
	public ResponseEntity<?> handleNoCatererPresentException(NoCatererPresentException noCatererPresentException, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(noCatererPresentException.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * This is the response which is going to get returned when CatererNameCannotBeEmptyException is thrown.
	 * This exception is used in public List<Caterer> searchByName(String catarerName) method of CatererServiceImpl
	 *
	 * @param CatererNameCannotBeEmptyException
	 * 
	 * @return ResponseEntity<ExceptionResponse>
	 */
	@ExceptionHandler(CatererNameCannotBeEmptyException.class)
	public ResponseEntity<?> handleCatererNameCannotBeEmptyException(CatererNameCannotBeEmptyException catererNameCannotBeEmptyException, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(catererNameCannotBeEmptyException.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
