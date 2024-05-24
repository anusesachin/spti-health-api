package com.spti.entity;

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
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "discharge_Patient")
public class DischargePatient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @PositiveOrZero
    @Column(name = "mLC_No")
    private Long MLC_No;

    @PositiveOrZero
    @Column(name = "IPD_No")
    private Long IPD_No;

    
    @Column(name = "consultant")
    private String consultant;

    @NotBlank(message = "Diagnosis cannot be blank")
    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "clinical_History")
    private String clinicalHistory;

    
    @ManyToOne
    @JoinColumn(name = "admit_Patient_id")
    private AdmitPatient admitPatient;

    
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
