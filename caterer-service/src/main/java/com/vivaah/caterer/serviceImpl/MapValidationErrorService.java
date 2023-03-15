package com.vivaah.caterer.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class MapValidationErrorService {

	public ResponseEntity<?> mapValidationError(BindingResult bindingResult){
		
		
		
		if(bindingResult.hasErrors()) {
			Map<String, String> fieldErrorMap = new HashMap<>();
			
			for(FieldError fieldError : bindingResult.getFieldErrors()) {
				fieldErrorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			
			return new ResponseEntity<Map<String, String>>(fieldErrorMap, HttpStatus.NOT_ACCEPTABLE);
		}
		return null;
	}
}
