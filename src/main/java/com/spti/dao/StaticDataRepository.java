package com.spti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spti.entity.Diagnosis;

@Repository
public interface StaticDataRepository  extends CrudRepository<Diagnosis, Long>{
	

	List<Diagnosis> findAll();
}
