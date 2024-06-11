package com.spti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spti.dto.patient.DiagnosisResponseDto;
import com.spti.dto.patient.PatientResponseDto;
import com.spti.service.StaticDataService;

@RestController
@RequestMapping("/diagnosiss")
public class StaticDataController {

	@Autowired
	private StaticDataService staticservice;
	
	
	
	@GetMapping( "/getAllDiagnosis" )
	public ResponseEntity<List<DiagnosisResponseDto>> getAllDiagnosis() {
		
	   List<DiagnosisResponseDto> diagnosisHistory = staticservice.getAllDiagnosis();
			if (diagnosisHistory != null)
				return ResponseEntity.status(HttpStatus.OK).body(diagnosisHistory);
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(diagnosisHistory);
		
    }
}
