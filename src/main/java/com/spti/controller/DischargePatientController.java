package com.spti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spti.constants.MessageConstants;
import com.spti.dto.patient.AdmitPatientRequestDto;
import com.spti.dto.patient.DischargePatientRequestDto;
import com.spti.service.DischargePatientService;

@RestController
@RequestMapping("/discharge")
public class DischargePatientController {
	
	@Autowired
	private DischargePatientService dischargePatientService;
	
	@PostMapping
	public ResponseEntity<String> dischargePatienAdd(  @RequestBody DischargePatientRequestDto dto ) {
		boolean isAdded = dischargePatientService.dischargePatienAdd( dto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_ADMISSION_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_ADMISSION_ERROR_MESSAGE );
		
	}

}
