package com.spti.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spti.dto.patient.AdmitPatientResponseDto;
import com.spti.entity.AdmitPatient;
import com.spti.entity.Patient;
import com.spti.entity.PatientOPDHistory;
   
@Repository
public interface AdmitPatientRepository extends CrudRepository<AdmitPatient, Long>{

	Optional<AdmitPatient> findByPatient_id(Long id);



	Page<AdmitPatient> findByAdmitDischargeStatus(String string, Pageable pageable);



    Optional<AdmitPatient> findByPatient_idAndAdmitDischargeStatus(Long id, String string);




    // Discharge Query
    
    @Query(name = "findByAdmissionDateAndAdmitDischargeStatus", value =  "SELECT a FROM AdmitPatient a WHERE DATE(a.admissionDate) = DATE(:date) AND a.admitDischargeStatus = :status")
    List<AdmitPatient> findByAdmissionDateAndAdmitDischargeStatus(@Param("date") LocalDate date, @Param("status") String status);



    @Query(name = "findAdmitPatientListBetweenAdmissionDateAndAdmitDischargeStatus", value = "SELECT p FROM AdmitPatient p WHERE DATE(p.admissionDate) >= DATE(:startDate) AND DATE(p.admissionDate) < DATE(:endDate) AND p.admitDischargeStatus = :status")
     List<AdmitPatient> findAdmitPatientListBetweenAdmissionDateAndAdmitDischargeStatus(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("status") String status);
 





}
