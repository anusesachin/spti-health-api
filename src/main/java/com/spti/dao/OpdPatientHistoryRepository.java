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

import com.spti.entity.Patient;
import com.spti.entity.PatientOPDHistory;

@Repository
public interface OpdPatientHistoryRepository extends CrudRepository<PatientOPDHistory, Long> {

	List<PatientOPDHistory> findAllByPatient(Patient patient);

	List<PatientOPDHistory> findByPatientOrderByIdDesc(Patient patient);

	@Query(name = "findPatientOPDHistoryListByTreatmentDate", value = "SELECT p FROM PatientOPDHistory p WHERE p.treatmentDate = :date")
	List<PatientOPDHistory> findPatientOPDHistoryListByTreatmentDate(@Param("date") LocalDate date);

	@Query(name = "findPatientOPDHistoryPageByTreatmentDate", value = "SELECT p FROM PatientOPDHistory p WHERE p.treatmentDate = :date")
	Page<PatientOPDHistory> findPatientOPDHistoryPageByTreatmentDate(@Param("date") LocalDate date, Pageable pageable);
	


	@Query(name = "findPatientOPDHistoryPageBetweenTreatmentDates", value = "SELECT p FROM PatientOPDHistory p WHERE p.treatmentDate BETWEEN :startDate AND :endDate")
	Page<PatientOPDHistory> findPatientOPDHistoryPageBetweenTreatmentDates(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate, Pageable pageable);

	@Query(name = "findPatientOPDHistoryListBetweenTreatmentDates", value = "SELECT p FROM PatientOPDHistory p WHERE p.treatmentDate BETWEEN :startDate AND :endDate")
	List<PatientOPDHistory> findPatientOPDHistoryListBetweenTreatmentDates(@Param("startDate") LocalDate startDate,	@Param("endDate") LocalDate endDate);

	List<PatientOPDHistory>findByTreatmentDate(LocalDate date);

	List<PatientOPDHistory> findPatientOPDHistoryListByTreatmentDateAndPaymentType(LocalDate date, String paymentType);


	List<PatientOPDHistory> findByTreatmentDateBetweenAndPaymentType(LocalDate startDate, LocalDate enddate,String paymentType);

	List<PatientOPDHistory> findByTreatmentDateAndDiagnosis(LocalDate date, String disease);

	List<PatientOPDHistory> findByTreatmentDateBetweenAndDiagnosis(LocalDate startDate, LocalDate endDate,
			String disease);

	



	

}
