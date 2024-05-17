package com.spti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private Long id;

    @NotBlank(message = "First name cannot be blank")
    @Size(max = 255, message = "First name must be less than 255 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(max = 255, message = "Last name must be less than 255 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Gender cannot be blank")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @NotNull(message = "Age cannot be null")
    @Column(name = "age")
    private Integer age;

    @NotBlank(message = "Phone number cannot be blank")
    @Size(min = 10, max = 12, message = "Phone number must be between 10 and 12 characters")
    @Pattern(regexp = "^\\d+$", message = "Phone number must contain only digits")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "branch")
    private Branch branch;
}
