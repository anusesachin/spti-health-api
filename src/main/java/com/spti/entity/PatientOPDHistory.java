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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

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
    
	@NotBlank
	@Column( name = "seen_by_doctor" )
	private String seenByDoctor;
    
	@NotBlank
	@Column( name = "diagnosis" )
	private String diagnosis;
    
	@NotBlank
	@Column( name = "treatment" )
	private String treatment;
    
	@PositiveOrZero
	@NotBlank
	@Column( name = "bill" )
	private String bill;
	
	@PositiveOrZero
	@NotBlank
	@Column( name = "pending_amount" )
	private String pendingAmount;
    
	
	@NotNull
	@Column( name = "bill_Status" )
	private String billStatus;

	@ManyToOne
	@JoinColumn( name = "patient_id" )
	private Patient patient;

	@Column( name = "date_of_treatment" )
	private LocalDateTime dateOfTreatment;
	
	@Column( name = "treatment_Date" )
	private LocalDate treatmentDate;
	
	@NotBlank
	@Column( name = "payment_type" )
	private String paymentType;
}
