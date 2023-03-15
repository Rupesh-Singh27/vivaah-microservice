package com.vivaah.photography.service;

import java.util.List;

import com.vivaah.photography.domain.Photography;

/**
 * @author rupesing
 *
 */
public interface PhotographyService {
	
	/*
	 * This method is used to save the photography object into database and it all the return the save object
	 *
	 * */
	Photography addPhotography(Photography photography);
	
	/*
	 *  This method is used to find all the object form the database object
	 * 
	 * */
	List<Photography> findAllPhotography();
	
	/*
	 *  This method is used to search the photographer object by the photograp object name
	 *  
	 *   */
	List<Photography> searchByName(String photographyName);
}
