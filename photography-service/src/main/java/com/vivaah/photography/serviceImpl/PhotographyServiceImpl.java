package com.vivaah.photography.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivaah.photography.domain.Photography;
import com.vivaah.photography.exceptions.FieldCannotBeEmptyExceptionForPhotography;
import com.vivaah.photography.exceptions.NoPhotographyPresentException;
import com.vivaah.photography.exceptions.PhotographyNameCannotBeEmptyException;
import com.vivaah.photography.repository.PhotographyRepository;
import com.vivaah.photography.service.PhotographyService;

/**
 * @author rupesing
 *This is the implementation of PhotographyService Interface where we will put all the Business Logic.
 */
@Service
public class PhotographyServiceImpl implements PhotographyService{
	
	/**
	 * Here we have asked Spring to inject the PhotographyRepository bean from the Spring Container.
	 * In order to interact with repository.
	 *
	 */
	@Autowired
	private PhotographyRepository photographyRepository;

	
	/**
	 * 
	 * This is an overridden method where we have wrote the business logic to validate the object and throwing exception if there is any problem
	 * otherwise, if the object does not throw any exception it will be passed to repository.
	 * 
	 * @exception FieldCannotBeEmptyExceptionForPhotography
	 * @exception RuntimeException
	 */
	@Override
	public Photography addPhotography(Photography photography) {
		try {
			if(photography.getPhotographyDescription() == null || photography.getPhotographyDescription().isEmpty() || photography.getPhotographyName() == null || photography.getPhotographyName().isEmpty() || photography.getImagepath() == null || photography.getImagepath().isEmpty()) {
				throw new FieldCannotBeEmptyExceptionForPhotography("Please fill every field appropriately");
			}
			return photographyRepository.save(photography);
		}catch(FieldCannotBeEmptyExceptionForPhotography exception) {
			throw exception;
		}catch(RuntimeException exception) {
			throw new RuntimeException(exception.getMessage());
		}
	}

	/**
	 * 
	 * This is an overridden method where we have wrote the business logic to fetch all the Photography objects from database and throwing exception if there is any problem
	 * otherwise, if there is no exception List of Photography object will be fetched.
	 * 
	 * @exception NoPhotographyPresentException
	 * @exception RuntimeException
	 */
	@Override
	public List<Photography> findAllPhotography() {
        try {
        	
        	List<Photography> photographyList=photographyRepository.findAll();
            
            if(photographyList.isEmpty()) {
    			throw new NoPhotographyPresentException("There in no photography present in database");
    		}
    		return photographyList;
        	
        }catch(NoPhotographyPresentException exception) {
        	throw exception;
        }catch(RuntimeException exception) {
        	throw new RuntimeException(exception.getMessage());
        }
	}

	/**
	 * 
	 * This is an overridden method where we have wrote the business logic to fetch all the Photography object from database by name and throwing exception if there is any problem
	 * otherwise, if there is no exception List of Photography object with same name will be fetched.
	 * 
	 * @exception CatererNameCannotBeEmptyException
	 * @exception RuntimeException
	 */
	@Override
	public List<Photography> searchByName(String photographyName) {
		
		try {
			if(photographyName.isEmpty() || photographyName == null || photographyName.isBlank() ) {
				throw new PhotographyNameCannotBeEmptyException("Please provide the catarer name");
			}
			return photographyRepository.findByPhotographyName(photographyName);
		}catch (PhotographyNameCannotBeEmptyException exception) {
			throw exception;
		}catch(RuntimeException exception) {
			throw new RuntimeException(exception.getMessage());
		}
	}


}
