package com.spti.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spti.dto.patient.AdmitPatientRequestDto;
import com.spti.dto.patient.AdmitPatientResponseDto;
import com.spti.dto.treatment.TreatmentRequest;
import com.spti.dto.treatment.TreatmentResponse;

public interface AdmitPatientService {

	boolean AdmitPatientAdd(@Valid AdmitPatientRequestDto dto);

	AdmitPatientResponseDto getAdmitPatientBypatienId(Long id);

	Page<AdmitPatientResponseDto> allAdmitPatients(Pageable pageable);

	boolean addAdmittedPatientTreatmentDetails(List<TreatmentRequest> treatmentRequestdto);

	List<TreatmentResponse> getTreatmentDetailsByAdmittanceId(Long id);

	List<AdmitPatientResponseDto> GetTodayAdmitPatient(String todayrecord);

	List<AdmitPatientResponseDto> GetTodayDischargePatient(String todayrecord);

}
