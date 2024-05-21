package com.spti.dto.patient;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdmitPatientRequestDto {

    @Positive(message = "ID must be positive")
    private long id;
    
    @NotNull(message = "Admit/Discharge Status cannot be null")
    @Pattern(regexp = "ADMIT|DISCHARGE", message = "Admit/Discharge Status must be either 'ADMIT' or 'DISCHARGE'")
    private String admitDischargeStatus;
    
    @NotNull(message = "Patient ID cannot be null")
    @Positive(message = "Patient ID must be positive")
    private Long patientId;
    
    @NotNull(message = "Admission Date cannot be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime admissionDate;
}
