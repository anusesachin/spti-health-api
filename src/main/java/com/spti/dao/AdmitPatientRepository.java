package com.spti.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spti.dto.patient.AdmitPatientResponseDto;
import com.spti.entity.AdmitPatient;
import com.spti.entity.Patient;

@Repository
public interface AdmitPatientRepository extends CrudRepository<AdmitPatient, Long>{

	Optional<AdmitPatient> findByPatient_id(Long id);



	Page<AdmitPatient> findByAdmitDischargeStatus(String string, Pageable pageable);

}
