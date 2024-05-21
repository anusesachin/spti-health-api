package com.spti.dto.patient;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DischargePatientRequestDto {

    @NotNull(message = "Discharge Patient ID cannot be null")
    private Long dischargePatientId;
    
    @NotNull(message = "MLC Number cannot be null")
    @Min(value = 1, message = "MLC Number must be a positive number")
    private Long MLC_No;
    
    @NotNull(message = "IPD Number cannot be null")
    @Min(value = 1, message = "IPD Number must be a positive number")
    private Long IPD_No;
    
    @NotBlank(message = "Consultant name cannot be blank")
    private String consultatnt;
    
    @NotBlank(message = "Diagnosis cannot be blank")
    private String diagnosis;
    
    @NotBlank(message = "Clinical history cannot be blank")
    private String clinical_History;
    
    @NotNull(message = "Patient ID cannot be null")
    @Min(value = 1, message = "Patient ID must be a positive number")
    private Long patientId;
    
    @NotBlank(message = "Admit Discharge Status cannot be blank")
    private String admitDischargeStatus;
    
    @NotNull(message = "Amount paid cannot be null")
    @Min(value = 0, message = "Amount paid must be zero or a positive number")
    private Long amountPaid;
    
    @NotNull(message = "Amount to be paid cannot be null")
    @Min(value = 0, message = "Amount to be paid must be zero or a positive number")
    private Long amounttobePaid;
    
    @NotNull(message = "Discharge date cannot be null")
    @PastOrPresent(message = "Discharge date cannot be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dischargeDate;
}
