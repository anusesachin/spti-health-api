package com.spti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spti.dto.patient.PatientOPDHistoryRequestDTO;
import com.spti.dto.patient.PatientOPDHistoryResponseDto;
import com.spti.dto.patient.PatientResponseDto;

public interface OpdPatientHistoryService {
	public List<PatientOPDHistoryResponseDto> getPatientOpdHistory( Long patientId );

	public boolean addOpdHistory( PatientOPDHistoryRequestDTO dto );

	PatientOPDHistoryResponseDto opdPatienBill(String todayrecord);

	public List<PatientOPDHistoryResponseDto> GetTodayOpdPatient(String todayrecord);

	public PatientOPDHistoryResponseDto getOpdRecordByid(Long id);

	PatientOPDHistoryResponseDto opdPatienBillOnlineDashbord(String todayrecord);

	PatientOPDHistoryResponseDto opdPatienBillCashDashbord(String todayrecord);

	public boolean updatePaidBill(PatientOPDHistoryRequestDTO dto);

	public List<PatientOPDHistoryResponseDto> OpdPatientHistory(String disease, String todayrecord);
	


	
}
