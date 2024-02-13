package com.spti.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spti.dao.AdmitPatientRepository;
import com.spti.dao.DischargePatientRepository;
import com.spti.dao.PatientRepository;
import com.spti.dto.patient.DischargePatientRequestDto;
import com.spti.entity.AdmitPatient;
import com.spti.entity.DischargePatient;
import com.spti.entity.Patient;
import com.spti.mapper.patient.DischargePatientMapper;
import com.spti.service.DischargePatientService;

@Service
public class DischargePatientServiceImpl implements DischargePatientService {
	
	@Autowired
	private DischargePatientMapper dischargePatientMapper;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	AdmitPatientRepository admitPatientRepository;
	
	@Autowired
	private DischargePatientRepository dischargePatientRepository;

	@Override
	public boolean dischargePatienAdd(DischargePatientRequestDto dto) {
		try {
			DischargePatient entity = dischargePatientMapper.toEntity( dto );
			
			Optional<Patient> opt = patientRepository.findById(dto.getPatientId());
			Optional<AdmitPatient> admitPatient = admitPatientRepository.findByPatient_id( dto.getPatientId() );
			if (opt.isPresent() ||admitPatient.isPresent() ) {
				entity.setPatient(opt.get());
				entity.setAdmitPatient(admitPatient.get());
				dischargePatientRepository.save( entity );
				
				AdmitPatient admitPatient2 = admitPatient.get();
				admitPatient2.setAdmitDischargeStatus(dto.getAdmitDischargeStatus());
				admitPatientRepository.save( admitPatient2 );
				return true;
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		return false;
	}

}
