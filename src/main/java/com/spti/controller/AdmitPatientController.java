package com.spti.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spti.constants.MessageConstants;
import com.spti.dto.patient.AdmitPatientRequestDto;
import com.spti.dto.patient.AdmitPatientResponseDto;
import com.spti.dto.patient.PatientOPDHistoryResponseDto;
import com.spti.dto.patient.PatientResponseDto;
import com.spti.dto.treatment.TreatmentRequest;
import com.spti.dto.treatment.TreatmentResponse;
import com.spti.service.AdmitPatientService;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/admits")
public class AdmitPatientController {

	@Autowired
	private AdmitPatientService admitPatientService;

	@PostMapping
	public ResponseEntity<String> AdmitPatientAdd(  @RequestBody AdmitPatientRequestDto dto ) {
		boolean isAdded = admitPatientService.AdmitPatientAdd( dto );
		if ( isAdded )
			return ResponseEntity.status( HttpStatus.CREATED ).body( MessageConstants.ADD_ADMISSION_SUCCESS_MESSAGE );

		else
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( MessageConstants.ADD_ADMISSION_ERROR_MESSAGE );
		
	}
	
	@GetMapping( "/patient/id/{id}" )
	public ResponseEntity<AdmitPatientResponseDto> getAdmitPatientBypatienId( @PathVariable Long id ) {
		return ResponseEntity.status( HttpStatus.OK ).body( admitPatientService.getAdmitPatientBypatienId( id ) );
	}
	
	@GetMapping
	public ResponseEntity<Page<AdmitPatientResponseDto>> allAdmitPatients(@RequestBody  @RequestParam int pageNo, Pageable pageable ) {
		return ResponseEntity.status( HttpStatus.OK ).body( admitPatientService.allAdmitPatients( PageRequest.of( pageNo, 50 ) ) );
	}
	
	@PostMapping("/treatment/{id}")
	public ResponseEntity<String> addAdmittedPatientTreatmentDetails(@RequestBody List<TreatmentRequest> treatmentRequestdto,@PathVariable Long id) {
		AdmitPatientResponseDto admitPatientResponseDto = admitPatientService.getAdmitPatientBypatienId(id);
		treatmentRequestdto.forEach(treatment->{
			treatment.setAdmittanceId(admitPatientResponseDto.getId());
		});
		
		boolean isTreatmentDetailsAdded=admitPatientService.addAdmittedPatientTreatmentDetails(treatmentRequestdto);
		if(isTreatmentDetailsAdded)
			return ResponseEntity.status(HttpStatus.CREATED).body(MessageConstants.ADD_Treatment_SUCCESS_MESSAGE);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.ADD_Treatment_ERROR_MESSAGE);
		
	}
	
	@GetMapping("/treatment/{id}")
	public ResponseEntity<List<TreatmentResponse>> getTreatmentDetails(@PathVariable Long id) {
		AdmitPatientResponseDto admitPatientResponseDto = admitPatientService.getAdmitPatientBypatienId(id);
		List<TreatmentResponse> treatmentResponseList = admitPatientService.getTreatmentDetailsByAdmittanceId(admitPatientResponseDto.getId());
		
			return ResponseEntity.status(HttpStatus.OK).body(treatmentResponseList);
		
	}
	
	@GetMapping( "/todayAdmitPatientDashbord/{todayrecord}" )
	public List<AdmitPatientResponseDto> GetTodayAdmitPatient(@PathVariable String todayrecord  ) {
		
		return  admitPatientService.GetTodayAdmitPatient(todayrecord);
	}
	
	@GetMapping( "/disacharge/todayDischargePatientDashbord/{todayrecord}" )
	public List<AdmitPatientResponseDto> GetTodayDischargePatient(@PathVariable String todayrecord  ) {
		System.out.println("Work");
		return  admitPatientService. GetTodayDischargePatient(todayrecord);
		
	}
}
