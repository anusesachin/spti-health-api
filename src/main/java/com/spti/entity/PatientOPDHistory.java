package com.spti.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

@Setter
@Getter
@Entity
@Table( name = "patients_opd_history" )
public class PatientOPDHistory {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "id" )
	private Long id;

	@Column( name = "seen_by_doctor" )
	private String seenByDoctor;

	@Column( name = "diagnosis" )
	private String diagnosis;

	@Column( name = "treatment" )
	private String treatment;

	@Column( name = "bill" )
	private String bill;
	
	@Column( name = "pending_amount" )
	private String pendingAmount;

	@Column( name = "bill_Status" )
	private String billStatus;

	@ManyToOne
	@JoinColumn( name = "patient_id" )
	private Patient patient;

	@Column( name = "date_of_treatment" )
	private LocalDateTime dateOfTreatment;
	
	@Column( name = "treatment_Date" )
	private LocalDate treatmentDate;
	
	@Column( name = "payment_type" )
	private String paymentType;
}
