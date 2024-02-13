package com.spti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table( name = "discharge_Patient" )
public class DischargePatient {
	
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id" )
	private Long id;
	
	@Column( name = "mLC_No" )
	private Long MLC_No;
	
	@Column( name = "IPD_No" )
	private Long IPD_No;
	
	@Column( name = "consultatnt" )
	private String consultatnt;
	
	@Column( name = "diagnosis" )
	private String diagnosis;
	
	@Column( name = "clinical_History" )
	private String clinical_History;
	
	@ManyToOne
	@JoinColumn( name = "admit_Patient_id" )
	private AdmitPatient admitPatient;
	
	@ManyToOne
	@JoinColumn( name = "patient_id" )
	private Patient patient;

}
