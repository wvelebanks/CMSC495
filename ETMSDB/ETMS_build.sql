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
  `PositionID` INT NOT NULL AUTO_INCREMENT,
  `PositionType` VARCHAR(45) NOT NULL,
  `PositionName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PositionID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`Employee` (
  `EmployeeID` INT NOT NULL AUTO_INCREMENT,
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
  `PositionID` INT NOT NULL,
  PRIMARY KEY (`EmployeeID`),
  INDEX `fk_positionID_idx` (`PositionID` ASC),
  CONSTRAINT `fk_positionID`
    FOREIGN KEY (`PositionID`)
    REFERENCES `ETMS_Schemma`.`Position` (`PositionID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'This Table contains all the users tha will interact with the database through the user interface';


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`UserTable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`UserTable` (
  `UserID` INT NOT NULL AUTO_INCREMENT,
  `UserName` VARCHAR(45) NOT NULL,
  `UserPassWord` VARCHAR(45) NOT NULL,
  `EmployeeID` INT NOT NULL,
  PRIMARY KEY (`UserID`, `EmployeeID`),
  INDEX `fk_UserTable_Employee1_idx` (`EmployeeID` ASC),
  CONSTRAINT `fk_UserTable_Employee1`
    FOREIGN KEY (`EmployeeID`)
    REFERENCES `ETMS_Schemma`.`Employee` (`EmployeeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`EmployeeType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`EmployeeType` (
  `EmployeeTypeID` INT NOT NULL AUTO_INCREMENT,
  `EmployeeType` VARCHAR(45) NOT NULL,
  `Employee_EmployeeID` INT NOT NULL,
  PRIMARY KEY (`EmployeeTypeID`),
  INDEX `fk_EmployeeType_Employee1_idx` (`Employee_EmployeeID` ASC),
  CONSTRAINT `fk_EmployeeType_Employee1`
    FOREIGN KEY (`Employee_EmployeeID`)
    REFERENCES `ETMS_Schemma`.`Employee` (`EmployeeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`Schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`Schedule` (
  `ScheduleID` INT NOT NULL AUTO_INCREMENT,
  `ScheduleName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ScheduleID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`TimeSheet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`TimeSheet` (
  `TimeSheetID` INT NOT NULL AUTO_INCREMENT,
  `StartDate` DATE NOT NULL,
  `PayPeriod` INT NOT NULL DEFAULT 0,
  `TimeIn` TIMESTAMP NOT NULL,
  `TimeOut` TIMESTAMP NOT NULL,
  `DateSubmitted` DATETIME NOT NULL,
  `Approval` TINYINT(1) NOT NULL,
  `Notes` VARCHAR(45) NOT NULL DEFAULT 'Not Specified',
  `Schedule_ScheduleID` INT NOT NULL,
  `EmployeeID` INT NOT NULL,
  PRIMARY KEY (`TimeSheetID`),
  INDEX `fk_TimeSheet_Schedule1_idx` (`Schedule_ScheduleID` ASC),
  INDEX `fk_EmployeeID_idx` (`EmployeeID` ASC),
  CONSTRAINT `fk_TimeSheet_Schedule1`
    FOREIGN KEY (`Schedule_ScheduleID`)
    REFERENCES `ETMS_Schemma`.`Schedule` (`ScheduleID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_EmployeeID`
    FOREIGN KEY (`EmployeeID`)
    REFERENCES `ETMS_Schemma`.`Employee` (`EmployeeID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`HoursTable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`HoursTable` (
  `HoursTableID` INT NOT NULL AUTO_INCREMENT,
  `TotalWorkedHours` INT NOT NULL,
  `DayWorkedHours` INT NOT NULL,
  `TimeSheet_TimeSheetID` INT NOT NULL,
  PRIMARY KEY (`HoursTableID`, `TimeSheet_TimeSheetID`),
  INDEX `fk_HoursTable_TimeSheet1_idx` (`TimeSheet_TimeSheetID` ASC),
  CONSTRAINT `fk_HoursTable_TimeSheet1`
    FOREIGN KEY (`TimeSheet_TimeSheetID`)
    REFERENCES `ETMS_Schemma`.`TimeSheet` (`TimeSheetID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`HoursCode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`HoursCode` (
  `HoursCodeID` INT NOT NULL AUTO_INCREMENT,
  `HoursCodeName` VARCHAR(45) NULL,
  `HoursTable_HoursTableID` INT NOT NULL,
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
  `LeaveID` INT NOT NULL AUTO_INCREMENT,
  `LeaveName` VARCHAR(45) NULL,
  `TimeSheet_TimeSheetID` INT NOT NULL,
  PRIMARY KEY (`LeaveID`, `TimeSheet_TimeSheetID`),
  INDEX `fk_Leave_TimeSheet1_idx` (`TimeSheet_TimeSheetID` ASC),
  CONSTRAINT `fk_Leave_TimeSheet1`
    FOREIGN KEY (`TimeSheet_TimeSheetID`)
    REFERENCES `ETMS_Schemma`.`TimeSheet` (`TimeSheetID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`Signature`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`Signature` (
  `SignatureID` INT NOT NULL AUTO_INCREMENT,
  `SignatureEmployee` VARBINARY(256) NOT NULL,
  `SignatureSupervisor` VARBINARY(256) NOT NULL,
  `TimeSheet_TimeSheetID` INT NOT NULL,
  PRIMARY KEY (`SignatureID`, `TimeSheet_TimeSheetID`),
  INDEX `fk_Signature_TimeSheet1_idx` (`TimeSheet_TimeSheetID` ASC),
  CONSTRAINT `fk_Signature_TimeSheet1`
    FOREIGN KEY (`TimeSheet_TimeSheetID`)
    REFERENCES `ETMS_Schemma`.`TimeSheet` (`TimeSheetID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ETMS_Schemma`.`Department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ETMS_Schemma`.`Department` (
  `DepartmentID` INT NOT NULL AUTO_INCREMENT,
  `DepartmentName` VARCHAR(45) NOT NULL,
  `TimeSheetID` INT NOT NULL,
  PRIMARY KEY (`DepartmentID`, `TimeSheetID`),
  INDEX `fk_Department_TimeSheet1_idx` (`TimeSheetID` ASC),
  CONSTRAINT `fk_TimeSheet1`
    FOREIGN KEY (`TimeSheetID`)
    REFERENCES `ETMS_Schemma`.`TimeSheet` (`TimeSheetID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;