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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "patients_opd_history")
public class PatientOPDHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "seen_by_doctor")
    @NotNull(message = "Seen by doctor cannot be null")
    private String seenByDoctor;

    @Column(name = "diagnosis")
    @NotNull(message = "Diagnosis cannot be null")
    @Size(max = 255, message = "Diagnosis must be less than 255 characters")
    private String diagnosis;

    @Column(name = "treatment")
    @NotNull(message = "Treatment cannot be null")
    @Size(max = 255, message = "Treatment must be less than 255 characters")
    private String treatment;

    @Column(name = "bill")
    @NotNull(message = "Bill cannot be null")
    private String bill;

    @Column(name = "pending_amount")
    private String pendingAmount;

    @Column(name = "bill_Status")
    private String billStatus;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "date_of_treatment")
    @NotNull(message = "Date of treatment cannot be null")
    private LocalDateTime dateOfTreatment;

    @Column(name = "treatment_Date")
    @NotNull(message = "Treatment date cannot be null")
    private LocalDate treatmentDate;

    @Column(name = "payment_type")
    @NotNull(message = "Payment type cannot be null")
    private String paymentType;

    @Column(name = "note")
    @Size(max = 255, message = "Note must be less than 255 characters")
    private String note;
}
