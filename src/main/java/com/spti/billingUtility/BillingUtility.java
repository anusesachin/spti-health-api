package com.spti.billingUtility;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spti.dto.patient.PatientOPDHistoryRequestDTO;
import com.spti.dto.patient.PatientOPDHistoryResponseDto;

@Component
public class BillingUtility {

	
	public PatientOPDHistoryResponseDto totalBillOfOPDPatient(List<PatientOPDHistoryResponseDto> dtoList) {
		
		  float totalBillOpd = 0.0f;
		  float totalpaidBill = 0.0f;
		  float totalpendingBill = 0.0f;
		  
		  for (PatientOPDHistoryResponseDto dto : dtoList) {
			  
			  float totalBill = Float.parseFloat(dto.getBill()); 
			  float pendingBill =  Float.parseFloat(dto.getPendingAmount());
			  float paidBill = totalBill - pendingBill;
			  totalBillOpd = totalBillOpd+Float.parseFloat(dto.getBill());
			  totalpaidBill = totalpaidBill + paidBill ;
			  totalpendingBill = totalpendingBill + Float.parseFloat(dto.getPendingAmount());
		  
		  } 
		  
		  PatientOPDHistoryResponseDto patientOPDHistoryResponseDto = new PatientOPDHistoryResponseDto();
		  patientOPDHistoryResponseDto.setTotalBillOpd(totalBillOpd);
		  patientOPDHistoryResponseDto.setTotalPaidBill(totalpaidBill);
		  patientOPDHistoryResponseDto.setTotalPendingBill(totalpendingBill);  
		 
		return patientOPDHistoryResponseDto;
	}

	public List<PatientOPDHistoryResponseDto> getPaidBill(List<PatientOPDHistoryResponseDto> dto) {
		
		for(PatientOPDHistoryResponseDto patientOPDHistoryResponseDto : dto) {
			
				float totableBill = Float.parseFloat(patientOPDHistoryResponseDto.getBill());
				float pendingBill = Float.parseFloat(patientOPDHistoryResponseDto.getPendingAmount());
				float paidBill = totableBill - pendingBill ;
				
				patientOPDHistoryResponseDto.setPaidBill(paidBill);			
				
			}
			return dto;
		
	}
	
	public PatientOPDHistoryResponseDto getPaidBillSingleOpd(PatientOPDHistoryResponseDto dto) {
		
				float totableBill = Float.parseFloat(dto.getBill());
				float pendingBill = Float.parseFloat(dto.getPendingAmount());
				float paidBill = totableBill - pendingBill ;
				
				dto.setPaidBill(paidBill);			
				
			return dto;
		
	}

	
}
