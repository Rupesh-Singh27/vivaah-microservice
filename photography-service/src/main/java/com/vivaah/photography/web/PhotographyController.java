package com.vivaah.photography.web;

import java.util.List;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivaah.photography.domain.Photography;
import com.vivaah.photography.service.PhotographyService;
import com.vivaah.photography.serviceImpl.MapValidationErrorService;

/**
 * This Controller is used to create Web Services and execute the REST API's
 * @author rupesing
 *
 */


@RestController
@RequestMapping("/photography")
//@SecurityRequirement(name = "Vivaah")
//@CrossOrigin(origins = "http://localhost:3000",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST})
public class PhotographyController {

	Logger logger = LoggerFactory.getLogger(PhotographyController.class);
	
	
	/**
	 * Here we have asked Spring to inject the CatererService bean from the Spring Container.
	 *
	 */
	@Autowired
	private PhotographyService photographyService;
	
	/**
	 * Here we have asked Spring to inject the MapValidationErrorService bean from the Spring Container.
	 * We are validating the Caterer object against the Validation in Entity and passing the binding result to MapValidationErrorService.
	 *
	 */
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	
	/**
	 * Testing purpose
	 *
	 */
	@GetMapping("/test")
	public void testingMethod() {
		logger.info("Request Received in Photography");
	}
	
	/**
	 * 
	 * @apiNote This API handles HTTP POST method to save the photographer in the database
	 * 
	 * @return ResponseEntity<Photography, HttpStatus.CREATED>
	 * 
	 * @param  photography object
	 * 
	 */
	@PostMapping("/addPhotography")
	public ResponseEntity<?> addPhotography(@Valid @RequestBody Photography photography, BindingResult bindingResult) {
		
		logger.info("Inside addPhotography method of Photogrpahy Controller");
		
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(bindingResult);
		if(errorMap != null) {
			return errorMap;
		}
	   
		Photography savedPhotography = photographyService.addPhotography(photography);
	   
		return new ResponseEntity<Photography>(savedPhotography, HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @apiNote This API handles HTTP GET method to return the list of photographers
	 * 
	 * @return ResponseEntity<List<Photography>>, HttpStatus.OK>
	 * 
	 */
	@GetMapping("/getAllPhotography")
	public ResponseEntity<?> findAllPhotography(){
		
		logger.info("Inside findAllPhotography method of Photogrpahy Controller");
		 
		List<Photography> photographers = photographyService.findAllPhotography();
		 
		return new ResponseEntity<List<Photography>>(photographers, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @apiNote This API handles HTTP GET method to return the list photography based on the name
	 * 
	 * @param photography name
	 * 
	 * @return ResponseEntity<List<Photography>>, HttpStatus.OK>
	 * 
	 */
    @GetMapping("/searchByPhotographyName/{photographyName}")
    public ResponseEntity<?> searchByName(@PathVariable("photographyName") String photographyName){
    	
		logger.info("Inside searchByName method of Photogrpahy Controller for photographer: " + photographyName);
    	
		List<Photography> photographers = photographyService.searchByName(photographyName);
    	
		return new ResponseEntity<List<Photography>>(photographers, HttpStatus.OK);
    }
}
