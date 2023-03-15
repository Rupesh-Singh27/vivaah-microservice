package com.vivaah.photography.customexceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.vivaah.photography.exceptions.FieldCannotBeEmptyExceptionForPhotography;
import com.vivaah.photography.exceptions.NoPhotographyPresentException;
import com.vivaah.photography.exceptions.PhotographyDoesNotExistException;
import com.vivaah.photography.exceptions.PhotographyNameCannotBeEmptyException;
import com.vivaah.photography.response.ExceptionResponse;

@ControllerAdvice
public class CustomeResponseEntityExceptionHandler {
	
/* Makeup specific exceptions */
	
	@ExceptionHandler(FieldCannotBeEmptyExceptionForPhotography.class)
	public ResponseEntity<?> handleFieldCannotBeEmptyExceptionForPhotography(FieldCannotBeEmptyExceptionForPhotography fieldCannotBeEmptyExceptionForPhotography, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(fieldCannotBeEmptyExceptionForPhotography.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	//For list
	@ExceptionHandler(NoPhotographyPresentException.class)
	public ResponseEntity<?> handleNoPhotographyPresentException(NoPhotographyPresentException noPhotographyPresentException, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(noPhotographyPresentException.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	//for search by ID
	@ExceptionHandler(PhotographyDoesNotExistException.class)
	public ResponseEntity<?> handlePhotographyDoesNotExistException(PhotographyDoesNotExistException photographyDoesNotExistException, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(photographyDoesNotExistException.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * This is the response which is going to get returned when PhotographyNameCannotBeEmptyException is thrown.
	 * This exception is used in public List<Photography> searchByName(String catarerName) method of PhotographyServiceImpl
	 *
	 * @param PhotographyNameCannotBeEmptyException
	 * @return ResponseEntity<ExceptionResponse>
	 *
	 */
	@ExceptionHandler(PhotographyNameCannotBeEmptyException.class)
	public ResponseEntity<?> handlePhotographyNameCannotBeEmptyException(PhotographyNameCannotBeEmptyException photographyNameCannotBeEmptyException, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(photographyNameCannotBeEmptyException.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
