package com.vivaah.caterer.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivaah.caterer.domain.Caterer;
import com.vivaah.caterer.exceptions.CatererNameCannotBeEmptyException;
import com.vivaah.caterer.exceptions.FieldCannotBeEmptyException;
import com.vivaah.caterer.exceptions.NoCatererPresentException;
import com.vivaah.caterer.repository.CatererRepository;
import com.vivaah.caterer.service.CatererService;


/**
 * @author rupesing
 *This is the implementation of CatererService Interface where we will put all the Business Logic.
 */
@Service
public class CatererServiceImpl implements CatererService{
	
	/**
	 * Here we have asked Spring to inject the CaterersRepository bean from the Spring Container.
	 * In order to interact with repository.
	 *
	 */
	@Autowired
	private CatererRepository caterersRepository;

	/**
	 * 
	 * This is an overridden method where we have wrote the business logic to validate the object and throwing exception if there is any problem
	 * otherwise, if the object does not throw any exception it will be passed to repository.
	 * 
	 * @exception FieldCannotBeEmptyException
	 * @exception RuntimeException
	 */
	@Override
	public Caterer addCaterer(Caterer caterer) {
		try {
			if(caterer.getCatererDescription() == null || caterer.getCatererDescription().isEmpty() || caterer.getCatererName() == null || caterer.getCatererName().isEmpty() || caterer.getImagepath() == null || caterer.getImagepath().isEmpty()) {
				throw new FieldCannotBeEmptyException("Please fill every field appropriately");
			}
			return caterersRepository.save(caterer);
		}catch(FieldCannotBeEmptyException exception) {
			throw exception;
		}catch(RuntimeException exception) {
			throw new RuntimeException(exception.getMessage());
		}
	}

	
	/**
	 * 
	 * This is an overridden method where we have wrote the business logic to fetch all the caterer objects from database and throwing exception if there is any problem
	 * otherwise, if there is no exception List of caterer object will be fetched.
	 * 
	 * @exception NoCatererPresentException
	 * @exception RuntimeException
	 */
	@Override
	public List<Caterer> findAllCaterer() {
		
		try {
			List<Caterer> caterersList = caterersRepository.findAll();
			
			if(caterersList.isEmpty()) {
				throw new NoCatererPresentException("There in no caterers present in database");
			}
			return caterersList;
		}catch (NoCatererPresentException exception) {
			throw exception;
		}catch(RuntimeException exception) {
			throw new RuntimeException(exception.getMessage());
		}
	}
	
	/**
	 * 
	 * This is an overridden method where we have wrote the business logic to fetch all the caterer object from database by name and throwing exception if there is any problem
	 * otherwise, if there is no exception List of caterer object with same name will be fetched.
	 * 
	 * @exception CatererNameCannotBeEmptyException
	 * @exception RuntimeException
	 */
	@Override
	public List<Caterer> searchByName(String catarerName) {
		try {
			if(catarerName.isEmpty() || catarerName == null || catarerName.isBlank() ) {
				throw new CatererNameCannotBeEmptyException("Please provide the catarer name");
			}
			return caterersRepository.findByCatererName(catarerName);
		}catch (CatererNameCannotBeEmptyException exception) {
			throw exception;
		}catch(RuntimeException exception) {
			throw new RuntimeException(exception.getMessage());
		}
	}
	
}
