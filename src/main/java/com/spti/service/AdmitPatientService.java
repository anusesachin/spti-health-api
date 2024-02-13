package com.spti.service;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spti.dto.patient.AdmitPatientRequestDto;
import com.spti.dto.patient.AdmitPatientResponseDto;

public interface AdmitPatientService {

	boolean AdmitPatientAdd(@Valid AdmitPatientRequestDto dto);

	AdmitPatientResponseDto getAdmitPatientBypatienId(Long id);

	Page<AdmitPatientResponseDto> allAdmitPatients(Pageable pageable);

}
