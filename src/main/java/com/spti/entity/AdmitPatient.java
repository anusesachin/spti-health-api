package com.spti.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table( name = "admit_patient" )
public class AdmitPatient {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id" )
	private Long id;
	
	@Column( name = "Admit_And_Discharge_Status" )
	private String admitDischargeStatus;
	
	@ManyToOne
	@JoinColumn( name = "patient_id" )
	private Patient patient;
	
	@Column( name = "admit_Date" )
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime admissionDate;

	@Column( name = "mLC_No" )
	private Long MLCNo;

	@Column( name = "IPD_No" )
	private Long IPDNo;

	@Column( name = "consultatnt" )
	private String consultatnt;

	@Column( name = "diagnosis" )
	private String diagnosis;

	@Column( name = "clinical_History" )
	private String clinicalHistory;

	@Column( name = "amount_paid" )
	private Long amountPaid;

	@Column( name = "amount_tobepaid" )
	private Long amounttobePaid;

	@Column(name="discharged_at")
	private LocalDateTime dischargedAt;
	
}
