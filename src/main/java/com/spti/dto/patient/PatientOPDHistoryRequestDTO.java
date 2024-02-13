package com.spti.dto.patient;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PatientOPDHistoryRequestDTO {

	private Long id;
	private String seenByDoctor;
	private String diagnosis;
	private String treatment;
	private String bill;
	private String billStatus;
	private Long patientId;
	private int branch;
	private String pendingAmount;
	private String paymentType;

	private LocalDate treatmentDate;
	
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private LocalDateTime dateOfTreatment;

}
