package com.spti.entity;

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
@Table( name = "patients" )
public class Patient {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "patient_id" )
	private Long id;

	@Column( name = "first_name" )
	private String firstName;

	@Column( name = "last_name" )
	private String lastName;

	@Column( name = "gender" )
	private String gender;
	
	@Column( name = "address" )
	private String address;

	@Column( name = "age" )
	private int age;

	@Column( name = "phone_number" )
	private String phoneNumber;

	@Column( name = "email" )
	private String email;

	@ManyToOne
	@JoinColumn( name = "branch" )
	private Branch branch;

}
