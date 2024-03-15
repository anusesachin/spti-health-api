package com.spti.mapper.patient;

import org.springframework.stereotype.Component;

import com.spti.dto.patient.DischargePatientRequestDto;
import com.spti.entity.AdmitPatient;

@Component
public class DischargePatientMapper {

	public AdmitPatient toEntity(DischargePatientRequestDto dto) {
		AdmitPatient entity = new AdmitPatient();
		
		entity.setId( dto.getDischargePatientId() );
		entity.setMLCNo(dto.getMLC_No());
		entity.setIPDNo(dto.getIPD_No());
		entity.setConsultatnt(dto.getConsultatnt());
		entity.setDiagnosis(dto.getDiagnosis());
		entity.setClinicalHistory(dto.getClinical_History());
		entity.setMLCNo(dto.getMLC_No());
		entity.setAdmitDischargeStatus(dto.getAdmitDischargeStatus());
		entity.setAmountPaid(dto.getAmountPaid());
		entity.setAmounttobePaid(dto.getAmounttobePaid());
		entity.setDischargedAt(dto.getDischargeDate());
		
		
		return entity;
	}

}
