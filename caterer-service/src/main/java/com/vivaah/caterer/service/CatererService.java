package com.vivaah.caterer.service;

import java.util.List;

import com.vivaah.caterer.domain.Caterer;

/**
 * @author rupesing
 * 
 * Caterer Service Interface, It is used to implement loose coupling in our project
 *
 */

public interface CatererService {
	
	/**
	 *This method is used to add the caterer object in database.
	 */
	Caterer addCaterer(Caterer caterer);
	
	
	/**
	 *This method is used to fetch list of caterer object from database.
	 */
	List<Caterer> findAllCaterer();
	
	
	/**
	 *This method is used to fetch the caterer object from database based on name.
	 */
	List<Caterer> searchByName(String catererName);
}
