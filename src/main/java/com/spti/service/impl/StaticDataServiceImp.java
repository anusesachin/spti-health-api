package com.spti.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spti.dao.StaticDataRepository;
import com.spti.dto.patient.DiagnosisResponseDto;
import com.spti.entity.Diagnosis;
import com.spti.mapper.patient.StaticDataMapper;
import com.spti.service.StaticDataService;

@Service
public class StaticDataServiceImp implements StaticDataService {

	@Autowired
	private StaticDataRepository staticRepository;
	
	@Autowired
	private StaticDataMapper staticMapper;
	
	
	@Override
	public List<DiagnosisResponseDto> getAllDiagnosis() {
		List<Diagnosis> allDiagnosis = staticRepository.findAll();
		if (allDiagnosis != null)
			return staticMapper.AllHistory(allDiagnosis);
		else
			return null;
		
	}


}