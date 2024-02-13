package com.spti.mapper.patient;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.spti.dto.patient.AdmitPatientRequestDto;
import com.spti.dto.patient.AdmitPatientResponseDto;
import com.spti.dto.patient.PatientResponseDto;
import com.spti.entity.AdmitPatient;
import com.spti.entity.Patient;

@Component
public class AdmitPatientMapper {

	public AdmitPatient toEntity( AdmitPatientRequestDto dto) {
		AdmitPatient entity = new AdmitPatient();
		
				entity.setId( dto.getId() );
				entity.setAdmitDischargeStatus(dto.getAdmitDischargeStatus());
				entity.setAdmissionDate( dto.getAdmissionDate() );
				
				return entity;
	}

	public AdmitPatientResponseDto toDto(AdmitPatient admitPatient) {
		AdmitPatientResponseDto admitPatientResponseDto = new AdmitPatientResponseDto();
		admitPatientResponseDto.setId(admitPatient.getId());
		admitPatientResponseDto.setAdmitDischargeStatus(admitPatient.getAdmitDischargeStatus());
		admitPatientResponseDto.setAdmissionDate(admitPatient.getAdmissionDate());
		admitPatientResponseDto.setPatient(topatientResponesDto(admitPatient.getPatient()));
		
		return admitPatientResponseDto;
	}

		private PatientResponseDto topatientResponesDto(Patient patient) {
		PatientResponseDto patientResponseDto = new PatientResponseDto();
		patientResponseDto.setFirstName(patient.getFirstName());
		patientResponseDto.setLastName(patient.getLastName());
		patientResponseDto.setAddress(patient.getAddress());
		patientResponseDto.setAge(patient.getAge());
		patientResponseDto.setEmail(patient.getEmail());
		patientResponseDto.setGender(patient.getGender());
		patientResponseDto.setPhoneNumber(patient.getPhoneNumber());
		patientResponseDto.setId(patient.getId());
		patientResponseDto.setBranch(patient.getBranch().getId());
		
		return patientResponseDto;
	}

		public List<AdmitPatientResponseDto> toList( List<AdmitPatient> content ) {
			List<AdmitPatientResponseDto> list = new ArrayList<>();
			for ( AdmitPatient dto : content )
				list.add( toDto( dto ) );
			return list;
		}




}
