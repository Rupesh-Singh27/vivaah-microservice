package com.vivaah.caterer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivaah.caterer.domain.Caterer;

/**
 * @author rupesing
 * The Repository interface is responsible to perform database related operations.
 * It extends JpaRepository in order to use predefined methods.
 */

@Repository
public interface CatererRepository  extends JpaRepository<Caterer, Long>{

	/**
	 * This is custom method which takes the caterer name and search all the caterers with same name
	 *
	 */
	List<Caterer> findByCatererName(String catarerName);

}
