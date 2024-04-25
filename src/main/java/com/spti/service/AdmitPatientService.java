package com.spti.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.spti.dto.patient.AdmitPatientRequestDto;
import com.spti.dto.patient.AdmitPatientResponseDto;
import com.spti.dto.patient.PatientOPDHistoryResponseDto;
import com.spti.dto.patient.PatientResponseDto;
import com.spti.dto.treatment.TreatmentRequest;
import com.spti.dto.treatment.TreatmentResponse;
import com.spti.entity.AdmitPatient;

public interface AdmitPatientService {

	boolean AdmitPatientAdd(@Valid AdmitPatientRequestDto dto);

	AdmitPatientResponseDto getAdmitPatientBypatienId(Long id);

	Page<AdmitPatientResponseDto> allAdmitPatients(Pageable pageable);

	boolean addAdmittedPatientTreatmentDetails(List<TreatmentRequest> treatmentRequestdto);

	List<TreatmentResponse> getTreatmentDetailsByAdmittanceId(Long id);

	List<PatientResponseDto> findByAdmissionDate(LocalDate admissionDate);

	List<PatientResponseDto> findByYear(int year);

	List<PatientResponseDto> getPatientsBetweenDates(LocalDate startDate, LocalDate endDate);

	List<PatientResponseDto> findAllPatient();

	List<PatientResponseDto> getListOfPatient(String todayrecord);

	
}
