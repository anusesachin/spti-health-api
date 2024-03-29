package com.spti.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spti.dao.AdmitPatientRepository;
import com.spti.dao.PatientRepository;
import com.spti.dao.TreatmentRepository;
import com.spti.dto.patient.AdmitPatientRequestDto;
import com.spti.dto.patient.AdmitPatientResponseDto;
import com.spti.dto.treatment.TreatmentRequest;
import com.spti.dto.treatment.TreatmentResponse;
import com.spti.entity.AdmitPatient;
import com.spti.entity.Branch;
import com.spti.entity.Patient;
import com.spti.entity.Treatment;
import com.spti.mapper.patient.AdmitPatientMapper;
import com.spti.mapper.patient.TreatmentMapper;
import com.spti.service.AdmitPatientService;

@Service
public class AdmitPatientServiceImpl implements AdmitPatientService {
	
	@Autowired
	AdmitPatientMapper admitPatientMapper;
	
	@Autowired
	AdmitPatientRepository admitPatientRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private TreatmentMapper treatmentMapper;
	
	@Autowired
	private TreatmentRepository treatmentRepository;

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
		Optional<AdmitPatient> admitPatient = admitPatientRepository.findByPatient_idAndAdmitDischargeStatus( id ,"Admit" );
		
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

	@Override
	public boolean addAdmittedPatientTreatmentDetails(List<TreatmentRequest> treatmentRequestdto) {
		List<Treatment> treatmentList=new ArrayList<Treatment>();
				treatmentRequestdto.forEach(treatment->{
					treatmentList.add(treatmentMapper.toEntity(treatment));
				});
				
		return treatmentRepository.saveAll(treatmentList) != null;
	}

	@Override
	public List<TreatmentResponse> getTreatmentDetailsByAdmittanceId(Long id) {
		// TODO Auto-generated method stub
		List<Treatment> treatmentList = treatmentRepository.findAllByAdmittanceId(id);
		List<TreatmentResponse> treatmentResponseList=new ArrayList<TreatmentResponse>();
		treatmentList.forEach(treatment->{
			treatmentResponseList.add(treatmentMapper.toDto(treatment));
		});
		
		return treatmentResponseList;
	}

	

	



	
	
		
	


}
