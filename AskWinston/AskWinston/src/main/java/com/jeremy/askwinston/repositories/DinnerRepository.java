package com.jeremy.askwinston.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jeremy.askwinston.models.Dinner;

public interface DinnerRepository extends CrudRepository<Dinner, Long>{
	List<Dinner> findAll();
	
	@Query(nativeQuery=true, value="SELECT * FROM dinner ORDER BY RAND() LIMIT 1")
	public List<Dinner> findRandomDinner();	
}



