DROP SCHEMA IF EXISTS `hospital`;
CREATE SCHEMA `hospital` ;
use `hospital`;

CREATE TABLE `hospital`.`branch` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NULL,
  `address` VARCHAR(128) NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `role`  VARCHAR(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


CREATE TABLE hospital.patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    gender VARCHAR(8),
    address VARCHAR(255),
    age INT,
    phone_number VARCHAR(15),
    email VARCHAR(100),
    branch INT NOT NULL,
    FOREIGN KEY (branch) REFERENCES hospital.branch(id)
);

CREATE TABLE patients_opd_history (
    id BIGINT NOT NULL AUTO_INCREMENT,
    seenByDoctor VARCHAR(255),
    diagnosis VARCHAR(255),
    treatment VARCHAR(255),
    bill VARCHAR(255),
    pending_amount VARCHAR(45),
    bill_Status VARCHAR(255),
    date_of_treatment TIMESTAMP,
    patient_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id)
);

ALTER TABLE `hospital`.`patients_opd_history` 
CHANGE COLUMN `seenByDoctor` `seen_by_doctor` VARCHAR(255) NULL DEFAULT NULL ;

ALTER TABLE `hospital`.`patients_opd_history` 
ADD COLUMN `treatment_Date` DATE NULL AFTER `bill_Status`;

ALTER TABLE `hospital`.`patients_opd_history` 
ADD COLUMN `payment_type` VARCHAR(45) NULL AFTER `date_of_treatment`;

CREATE TABLE `admit_patient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `admit_Date` timestamp NULL DEFAULT NULL,
  `patient_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_id` (`patient_id`),
  CONSTRAINT `admit_patient` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`patient_id`)); 

CREATE TABLE `hospital`.`discharge_patient` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mLC_No` INT NOT NULL,
  `IPD_No` INT NOT NULL,
  `consultatnt` VARCHAR(45) NOT NULL,
  `diagnosis` VARCHAR(45) NOT NULL,
  `clinical_History` VARCHAR(45) NOT NULL,
  `admit_Patient_id` INT NOT NULL,
  `patient_id`INT NOT NULL,
  PRIMARY KEY (`id`),
 FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
 FOREIGN KEY (admit_Patient_id) REFERENCES admit_patient(id)
);


ALTER TABLE `hospital`.`admit_patient` 
ADD COLUMN `Admit_And_Discharge_Status` VARCHAR(45) NOT NULL AFTER `admit_Date`;
