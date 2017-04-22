-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ETMS_Schemma
-- -----------------------------------------------------
-- Thiis is the database for the the Employee Time Management System

-- -----------------------------------------------------
-- Schema ETMS_Schemma
--
-- Thiis is the database for the the Employee Time Management System
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ETMS_Schemma` ;
USE `ETMS_Schemma` ;

-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`Position`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`Position` (
  `PositionID` INT(5) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key of Position Table',
  `PositionType` VARCHAR(45) NOT NULL COMMENT 'Position Type describes ',
  `PositionName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PositionID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`EmployeeType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`EmployeeType` (
  `EmployeeTypeID` INT(5) NOT NULL AUTO_INCREMENT COMMENT 'Employee TYpe ID is the Primary Key for the Employee Type table ',
  `EmployeeType` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`EmployeeTypeID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`Employee` (
  `EmployeeID` INT(5) NOT NULL AUTO_INCREMENT COMMENT 'Employee ID is the Primary Key for the Employee Table',
  `FirstName` VARCHAR(45) NOT NULL,
  `MiddleName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `SSN` VARCHAR(11) NOT NULL,
  `Birthdate` DATE NOT NULL,
  `StreetNumber` VARCHAR(45) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  `State` VARCHAR(2) NOT NULL,
  `ZipCode` VARCHAR(10) NOT NULL,
  `Phone` VARCHAR(12) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `PositionID` INT(5) NOT NULL,
  `EmployeeTypeID` INT(5) NOT NULL,
  PRIMARY KEY (`EmployeeID`),
  INDEX `fk_positionID_idx` (`PositionID` ASC),
  INDEX `fk_EmployeeTypeID_idx` (`EmployeeTypeID` ASC),
  CONSTRAINT `fk_positionID`
    FOREIGN KEY (`PositionID`)
    REFERENCES `ETMS_Schemma`.`Position` (`PositionID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_EmployeeTypeID`
    FOREIGN KEY (`EmployeeTypeID`)
    REFERENCES `ETMS_Schemma`.`EmployeeType` (`EmployeeTypeID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = 'This Table contains all the users tha will interact with the' /* comment truncated */ /* database through the user interface*/;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`UserTable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`UserTable` (
  `UserID` INT(5) NOT NULL AUTO_INCREMENT COMMENT 'UserId is the primary key for User table ',
  `UserName` VARCHAR(45) NOT NULL,
  `UserPassWord` VARCHAR(45) NOT NULL,
  `EmployeeID` INT(5) NOT NULL COMMENT 'Employee Id is a foreign key to the employee Table',
  PRIMARY KEY (`UserID`, `EmployeeID`),
  INDEX `fk_UserTable_Employee1_idx` (`EmployeeID` ASC),
  CONSTRAINT `fk_UserTable_Employee1`
    FOREIGN KEY (`EmployeeID`)
    REFERENCES `ETMS_Schemma`.`Employee` (`EmployeeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`Schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`Schedule` (
  `ScheduleID` INT(5) NOT NULL COMMENT 'ScheduleID is the Primary Key for Schedule table',
  `ScheduleName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ScheduleID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`HoursTable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`HoursTable` (
  `HoursTableID` INT(5) NOT NULL AUTO_INCREMENT COMMENT 'Hours TableID is the primary key for the hours table ',
  `TotalWorkedHours` INT NOT NULL,
  `DayWorkedHours` INT NOT NULL,
  PRIMARY KEY (`HoursTableID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`HoursCode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`HoursCode` (
  `HoursCodeID` INT(5) NOT NULL AUTO_INCREMENT COMMENT 'Hours Code ID is the Primary key for the hours code table ',
  `HoursCodeName` VARCHAR(45) NULL,
  `HoursTable_HoursTableID` INT(5) NOT NULL COMMENT 'Hours table ID is the primary key for the Hours table ',
  PRIMARY KEY (`HoursCodeID`, `HoursTable_HoursTableID`),
  INDEX `fk_HoursCode_HoursTable1_idx` (`HoursTable_HoursTableID` ASC),
  CONSTRAINT `fk_HoursCode_HoursTable1`
    FOREIGN KEY (`HoursTable_HoursTableID`)
    REFERENCES `ETMS_Schemma`.`HoursTable` (`HoursTableID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`Leave`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`Leave` (
  `LeaveID` INT(5) NOT NULL AUTO_INCREMENT COMMENT 'Leave Id is the Primary Key for Leave Table which holds the different coles related to leave.',
  `LeaveName` VARCHAR(45) NULL,
  PRIMARY KEY (`LeaveID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`Signature`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`Signature` (
  `SignatureID` INT(5) NOT NULL AUTO_INCREMENT COMMENT 'SignatureID is the Primary key for the signature Table',
  `SignatureEmployee` VARBINARY(256) NOT NULL,
  `SignatureSupervisor` VARBINARY(256) NOT NULL,
  PRIMARY KEY (`SignatureID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`Department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`Department` (
  `DepartmentID` INT(5) NOT NULL AUTO_INCREMENT COMMENT 'Department ID is the Promary Key for the Department Table',
  `DepartmentName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`DepartmentID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`TimeSheet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`TimeSheet` (
  `TimeSheetID` INT(5) NOT NULL AUTO_INCREMENT COMMENT 'TimesheetId is the primary Key for The Time Sheet table',
  `StartDate` DATE NOT NULL COMMENT 'the start provides the beginning date of the period an employee is filling his/her timesheet for.',
  `PayPeriod` INT(5) NOT NULL DEFAULT 0 COMMENT 'Pay Period provides the number of the period being paid based on the time set (bi-weekly, weekly, monthly). For instance in a six month contract if the pay period is bi-weekly then the number of pay period will be up to 12, 24 if the payment is done weekl' /* comment truncated */ /*y and 6 if it is done monthly.*/,
  `TimeIn` TIMESTAMP NOT NULL COMMENT 'The recorded time at which an employee signed-in.',
  `TimeOut` TIMESTAMP NOT NULL COMMENT 'The recorded time at which the employee signed out from work.',
  `DateSubmitted` DATETIME NOT NULL COMMENT 'The date submitted is when the employee has signed for all hos hours for a specific pay period which could be at the end of the week, two weeks or the month for instance.',
  `Approval` TINYINT(1) NOT NULL COMMENT 'The approval records if the supervisor has approved the employee\'s timesheet.',
  `Notes` VARCHAR(45) NOT NULL DEFAULT 'Not Specified' COMMENT 'This field comes to any note or comment for either the supervisor or the employee.',
  `Schedule_ScheduleID` INT(5) NOT NULL COMMENT 'Scheduled ID is a foreign key from the Schedule table that manages the different types of schedules that can be assigned to an employee.',
  `EmployeeID` INT(5) NOT NULL COMMENT 'EmployeeID is a foreign key for the employee table, which is a table that stores all the employee\'s information. ',
  `LeaveID` INT(5) NOT NULL COMMENT 'Leave ID is a foerign Key to the Leave Table which holds the different codes for leave.',
  `SignatureID` INT(5) NOT NULL COMMENT 'Signature ID is a foreign Key to the Signature table that will store the signatures of the employee and the supervisor that signs the timesheet.',
  `DepartmentID` INT(5) NOT NULL COMMENT 'Department ID is the foreign key to the table that store information of the department that and employee could assign to work.',
  `HoursCodeID` INT(5) NOT NULL COMMENT 'Hours Code ID is a foreing key for Hours code table which is also link with Hours Table',
  PRIMARY KEY (`TimeSheetID`),
  INDEX `fk_TimeSheet_Schedule1_idx` (`Schedule_ScheduleID` ASC),
  INDEX `fk_EmployeeID_idx` (`EmployeeID` ASC),
  INDEX `fk_LeaveID_idx` (`LeaveID` ASC),
  INDEX `fk-SignatureID_idx` (`SignatureID` ASC),
  INDEX `fk_DepartmentID_idx` (`DepartmentID` ASC),
  INDEX `fk_HoursCodeID_idx` (`HoursCodeID` ASC),
  CONSTRAINT `fk_TimeSheet_Schedule1`
    FOREIGN KEY (`Schedule_ScheduleID`)
    REFERENCES `ETMS_Schemma`.`Schedule` (`ScheduleID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_EmployeeID`
    FOREIGN KEY (`EmployeeID`)
    REFERENCES `ETMS_Schemma`.`Employee` (`EmployeeID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_LeaveID`
    FOREIGN KEY (`LeaveID`)
    REFERENCES `ETMS_Schemma`.`Leave` (`LeaveID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk-SignatureID`
    FOREIGN KEY (`SignatureID`)
    REFERENCES `ETMS_Schemma`.`Signature` (`SignatureID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_DepartmentID`
    FOREIGN KEY (`DepartmentID`)
    REFERENCES `ETMS_Schemma`.`Department` (`DepartmentID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_HoursCodeID`
    FOREIGN KEY (`HoursCodeID`)
    REFERENCES `ETMS_Schemma`.`HoursCode` (`HoursCodeID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
