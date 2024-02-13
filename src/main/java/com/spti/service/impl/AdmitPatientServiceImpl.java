package com.spti.service.impl;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spti.dao.AdmitPatientRepository;
import com.spti.dao.PatientRepository;
import com.spti.dto.patient.AdmitPatientRequestDto;
import com.spti.dto.patient.AdmitPatientResponseDto;
import com.spti.entity.AdmitPatient;
import com.spti.entity.Branch;
import com.spti.entity.Patient;
import com.spti.mapper.patient.AdmitPatientMapper;
import com.spti.service.AdmitPatientService;

@Service
public class AdmitPatientServiceImpl implements AdmitPatientService {
	
	@Autowired
	AdmitPatientMapper admitPatientMapper;
	
	@Autowired
	AdmitPatientRepository admitPatientRepository;
	
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public boolean AdmitPatientAdd( AdmitPatientRequestDto dto) {
		try {
			AdmitPatient entity = admitPatientMapper.toEntity( dto );
			
			Optional<Patient> opt = patientRepository.findById(dto.getPatientId());
			if (opt.isPresent()) {
				entity.setPatient(opt.get());
				admitPatientRepository.save( entity );
				return true;
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public AdmitPatientResponseDto getAdmitPatientBypatienId(Long id) {
		Optional<AdmitPatient> admitPatient = admitPatientRepository.findByPatient_id( id );
		
				if ( admitPatient.isPresent() )
					return admitPatientMapper.toDto( admitPatient.get() );
				else
					return null;
		
	}

	@Override
	public Page<AdmitPatientResponseDto> allAdmitPatients(Pageable pageable) {
		
		Page<AdmitPatient> entityPage = admitPatientRepository.findByAdmitDischargeStatus("Admit"  ,pageable );
		return new PageImpl<>( admitPatientMapper.toList( entityPage.getContent() ), pageable, entityPage.getTotalElements() );
	}



	
	
		
	


}
