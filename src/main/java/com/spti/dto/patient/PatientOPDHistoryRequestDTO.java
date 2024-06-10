package com.spti.dto.patient;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.spti.entity.Diagnosis;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PatientOPDHistoryRequestDTO {

  //  @NotNull(message = "ID is required")
    private Long id;

  //  @NotBlank(message = "Seen by Doctor is required")
  //  @Size(max = 255, message = "Seen by Doctor cannot be longer than 255 characters")
    private String seenByDoctor;

 //   @NotBlank(message = "Diagnosis is required")
  //  @Size(max = 500, message = "Diagnosis cannot be longer than 500 characters")
    private Diagnosis diagnosis;

  //  @NotBlank(message = "Treatment is required")
  //  @Size(max = 1000, message = "Treatment cannot be longer than 1000 characters")
    private String treatment;

//    @NotBlank(message = "Bill is required")
    private String bill;

//    @NotBlank(message = "Bill Status is required")
 //   @Pattern(regexp = "PAID|UNPAID", message = "Bill Status must be either PAID or UNPAID")
    private String billStatus;

 //   @NotNull(message = "Patient ID is required")
    private Long patientId;

  //  @PositiveOrZero(message = "Branch must be zero or positive")
    private int branch;

 //   @NotBlank(message = "Pending Amount is required")
 //   @Pattern(regexp = "\\d+(\\.\\d{1,2})?", message = "Pending Amount must be a valid monetary amount")
    private String pendingAmount;

//    @NotBlank(message = "Payment Type is required")
    private String paymentType;

 //   @Size(max = 2000, message = "Note cannot be longer than 2000 characters")
    private String note;

 //   @NotNull(message = "Treatment Date is required")
    private LocalDate treatmentDate;
    
 //   @NotNull(message = "Date of Treatment is required")
 //   @DateTimeFormat(pattern = "yyyy-MM-dd")
 //   @FutureOrPresent(message = "Date of Treatment must be in the present or future")
    private LocalDateTime dateOfTreatment;

	
}
