package com.spti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spti.dto.patient.DiagnosisResponseDto;

@Service
public interface StaticDataService {

	
	List<DiagnosisResponseDto> getAllDiagnosis();


}
