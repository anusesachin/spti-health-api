package com.spti.mapper.patient;

import org.springframework.stereotype.Component;

import com.spti.dto.patient.DischargePatientRequestDto;
import com.spti.entity.AdmitPatient;
import com.spti.entity.DischargePatient;

@Component
public class DischargePatientMapper {

	public DischargePatient toEntity(DischargePatientRequestDto dto) {
		DischargePatient entity = new DischargePatient();
		
		entity.setId( dto.getDischargePatientId() );
		entity.setMLC_No(dto.getMLC_No());
		entity.setIPD_No(dto.getIPD_No());
		entity.setConsultatnt(dto.getConsultatnt());
		entity.setDiagnosis(dto.getDiagnosis());
		entity.setClinical_History(dto.getClinical_History());
		entity.setMLC_No(dto.getMLC_No());
		
		
		return entity;
	}

}
