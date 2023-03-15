package com.vivaah.caterer.web;

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

import com.vivaah.caterer.domain.Caterer;
import com.vivaah.caterer.service.CatererService;
import com.vivaah.caterer.serviceImpl.MapValidationErrorService;

/**
 * This Controller is webservice which is used to handle the REST API's to manage oprations on Caterer.
 * @author rupesing
 *
 */
@RestController
@RequestMapping("/caterer")
//@CrossOrigin(origins = "http://localhost:3000",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST})
public class CatererController {
	
	Logger logger = LoggerFactory.getLogger(CatererController.class);
	
	/**
	 * Here we have asked Spring to inject the CatererService bean from the Spring Container.
	 *
	 */
	@Autowired
	private CatererService caterersService;
	
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
		logger.info("Request Received in Caterer");
	}
	
	/**
	 * @apiNote This API is used to add the Caterer object into the database after validating it.
	 * 
	 * @param Caterer object
	 * 
	 * @return ResponseEntity<Caterer>
	 *
	 */
	@PostMapping("/addCaterer")
	public ResponseEntity<?> addCaterer(@Valid @RequestBody Caterer catarer, BindingResult bindingResult) {
		
			ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(bindingResult);
			if(errorMap != null) {
				return errorMap;
			}
			
			Caterer savedCaterer = caterersService.addCaterer(catarer);
			
			return new ResponseEntity<Caterer>(savedCaterer, HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @apiNote This API is used to fetch list of Caterer objects from the database.
	 *
	 * @return ResponseEntity<List<Caterer>>
	 *
	 */
	@GetMapping("/getAllCaterers")
	public ResponseEntity<?> findAllCaterer(){
		
		 List<Caterer> catererList = caterersService.findAllCaterer();
		 
		 return new ResponseEntity<List<Caterer>>(catererList, HttpStatus.FOUND);
	}
	
	/**
	 *
	 * @apiNote This API is used to fetch Caterer object from the database based on the catererName.
	 * 
	 * @param catererName
	 * 
	 * @return ResponseEntity<Caterer>
	 *
	 */
    @GetMapping("/searchByCatererName/{catererName}")
    public List<Caterer> searchByName(@PathVariable("catererName") String catererName){
    	logger.info("inside caterer controller");
    	return caterersService.searchByName(catererName);
    }
}