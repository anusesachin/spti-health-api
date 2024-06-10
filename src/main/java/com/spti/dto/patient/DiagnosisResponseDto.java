package com.spti.dto.patient;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.spti.entity.PatientOPDHistory;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DiagnosisResponseDto {

	
	private Long id;
	
	private String diagnosis;
	
}
