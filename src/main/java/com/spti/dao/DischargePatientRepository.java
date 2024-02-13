package com.spti.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spti.entity.AdmitPatient;
import com.spti.entity.DischargePatient;

@Repository
public interface DischargePatientRepository extends CrudRepository<DischargePatient, Long> {
	
	

}
