package com.spti.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "patients_opd_history")
public class PatientOPDHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "seen_by_doctor")
    private String seenByDoctor;

    @Column(name = "treatment")
    private String treatment;

    @Column(name = "bill")
    private String bill;

    @Column(name = "pending_amount")
    private String pendingAmount;

    @Column(name = "bill_status")
    private String billStatus;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "date_of_treatment")
    @NotNull(message = "Date of treatment cannot be null")
    private LocalDateTime dateOfTreatment;

    @Column(name = "treatment_date")
    private LocalDate treatmentDate;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "note")
    private String note;
    

    @ManyToOne(targetEntity = Diagnosis.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnosis_id", referencedColumnName = "id")
    private Diagnosis diagnosis;
}
