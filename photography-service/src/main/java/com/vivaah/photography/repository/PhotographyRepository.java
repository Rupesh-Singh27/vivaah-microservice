package com.vivaah.photography.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivaah.photography.domain.Photography;

@Repository

public interface PhotographyRepository extends JpaRepository<Photography, Long>{
	
	List<Photography> findByPhotographyName(String photographyName);
	
}
