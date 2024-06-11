package com.spti.mapper.patient;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.spti.dto.patient.DiagnosisResponseDto;
import com.spti.entity.Diagnosis;

@Component
public class StaticDataMapper {

	 public List<DiagnosisResponseDto> AllHistory(List<Diagnosis> list) {
		 
		 
	        List<DiagnosisResponseDto> transformedHistory = new ArrayList<>();

	        
	        for (Diagnosis diagnosis : list) {
	      
	            DiagnosisResponseDto transformedDiagnosis = new DiagnosisResponseDto();

	            transformedDiagnosis.setId(diagnosis.getId());
	            transformedDiagnosis.setDiagnosis(diagnosis.getDiagnosis());
	            transformedHistory.add(transformedDiagnosis);
	        }

	        return transformedHistory;
	    }
}
