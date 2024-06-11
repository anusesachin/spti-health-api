package com.spti.mapper.patient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spti.dto.patient.DiagnosisResponseDto;
import com.spti.dto.patient.PatientOPDHistoryRequestDTO;
import com.spti.dto.patient.PatientOPDHistoryResponseDto;
import com.spti.dto.patient.PatientResponseDto;
import com.spti.entity.Diagnosis;
import com.spti.entity.Patient;
import com.spti.entity.PatientOPDHistory;

@Component
public class PatientOPDHistoryMapper {

	public PatientOPDHistoryRequestDTO toRequestDTO(PatientOPDHistory entity) {
		PatientOPDHistoryRequestDTO dto = new PatientOPDHistoryRequestDTO();

		dto.setPatientId(entity.getPatient().getId());
		dto.setBill(entity.getBill());
		dto.setBillStatus(entity.getBillStatus());
		dto.setPendingAmount(entity.getPendingAmount());
		dto.setSeenByDoctor(entity.getSeenByDoctor());
		dto.setTreatment(entity.getTreatment());

		return dto;
	}
	
	  public PatientResponseDto toPtientDto(Patient entity) { 
		  
	  PatientResponseDto patient = new PatientResponseDto();
	  patient.setId(entity.getId());
	  patient.setFirstName(entity.getFirstName());
	  patient.setLastName(entity.getLastName());
	  patient.setPhoneNumber(entity.getPhoneNumber());
	  
	  return patient;
	  
	  }
	  
	  public DiagnosisResponseDto toDiagnosisDto(Diagnosis entity) { 
		  
		  DiagnosisResponseDto diagnosis = new DiagnosisResponseDto();
		  diagnosis.setId(entity.getId());
		  diagnosis.setDiagnosis(entity.getDiagnosis());

		  return diagnosis;  
		  }
	  
	public PatientOPDHistoryResponseDto toResponseDTO( PatientOPDHistory entity ) {
		PatientOPDHistoryResponseDto dto = new PatientOPDHistoryResponseDto();
		dto.setId( entity.getId() );
		dto.setBill( entity.getBill() );
		dto.setBillStatus( entity.getBillStatus() );
		dto.setPendingAmount( entity.getPendingAmount() );
		dto.setSeenByDoctor( entity.getSeenByDoctor() );
		dto.setTreatment( entity.getTreatment() );
		dto.setTreatmentDate(entity.getTreatmentDate());;
		dto.setDateOfTreatment( entity.getDateOfTreatment() );
		dto.setPaymentType( entity.getPaymentType() );
		dto.setPatient(toPtientDto(entity.getPatient()));
		dto.setDiagnosis(toDiagnosisDto(entity.getDiagnosis()));		
		
		return dto;
	}
	
	

	public List<PatientOPDHistoryResponseDto> toResponseList(List<PatientOPDHistory> list) {
		List<PatientOPDHistoryResponseDto> reslist = new ArrayList<>();
		for (PatientOPDHistory dto : list) {
			reslist.add(toResponseDTO(dto));
		}
		return reslist;
	}
	

	public PatientOPDHistory toEntity(PatientOPDHistoryRequestDTO dto) {
		if (dto == null) {
			return null;
		}

		PatientOPDHistory history = new PatientOPDHistory();
		history.setId(dto.getId());
		history.setSeenByDoctor(dto.getSeenByDoctor());
		history.setTreatment(dto.getTreatment());
		history.setBill(dto.getBill());
		history.setBillStatus(dto.getBillStatus());
		history.setPendingAmount(dto.getPendingAmount());
		history.setTreatmentDate(LocalDate.now());
		history.setDateOfTreatment(LocalDateTime.now());
		history.setPaymentType(dto.getPaymentType());
		history.setNote(dto.getNote());
	    history.setDiagnosis(dto.getDiagnosis());

		
		return history;
	}

	public PatientOPDHistoryRequestDTO dtosetValue(PatientOPDHistoryRequestDTO dto,
			PatientOPDHistoryResponseDto patientOPDHistoryResponseDto) {
		
		dto.setSeenByDoctor(patientOPDHistoryResponseDto.getSeenByDoctor());
	//	dto.setDiagnosis(toDiagnosisDto(patientOPDHistoryResponseDto.getDiagnosis()));
		dto.setTreatment(patientOPDHistoryResponseDto.getTreatment());
		dto.setTreatmentDate(patientOPDHistoryResponseDto.getTreatmentDate());
		dto.setDateOfTreatment(patientOPDHistoryResponseDto.getDateOfTreatment());
		dto.setPatientId(patientOPDHistoryResponseDto.getPatient().getId());
		return dto;
	}

	public List<PatientOPDHistoryResponseDto>  gettoResponseList(List<PatientOPDHistory> entityPage) {
		List<PatientOPDHistoryResponseDto> reslist = new ArrayList<>();
		for (PatientOPDHistory dto : entityPage) {
			reslist.add(toResponseDTO(dto));
		}
		return reslist;

	}

}
	


