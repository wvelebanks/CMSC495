--Inserts in Employee Table
INSERT INTO `etms_schemma`.`employee` (`EmployeeID`, `FirstName`, `MiddleName`, `LastName`, `SSN`, `Birthdate`, `StreetNumber`, `City`, `State`, `ZipCode`, `Phone`, `Email`, `PositionID`, `EmployeeTypeID`) VALUES ('00001', 'Ann', 'Marie', 'Kramer', '111-22-3333', '1978-01-23', '2314 New Avenue', 'Ghost Town', 'MD', '20876', '222-333-4455', 'amkramer@email.com', '00001', '00003');
INSERT INTO `etms_schemma`.`employee` (`EmployeeID`, `FirstName`, `MiddleName`, `LastName`, `SSN`, `Birthdate`, `StreetNumber`, `City`, `State`, `ZipCode`, `Phone`, `Email`, `PositionID`, `EmployeeTypeID`) VALUES ('00002', 'Jesse', 'Holland', 'James', '222-33-4567', '1983-04-22', '1456 West Road', 'Springs Arbor', 'MD', '20101', '221-987-2222', 'JhJames@email.com', '00001', '00001');
INSERT INTO `etms_schemma`.`employee` (`EmployeeID`, `FirstName`, `MiddleName`, `LastName`, `SSN`, `Birthdate`, `StreetNumber`, `City`, `State`, `ZipCode`, `Phone`, `Email`, `PositionID`, `EmployeeTypeID`) VALUES ('00003', 'Natalie', 'Luna', 'Smith', '112-34-0000', '1952-07-12', '1425 Abbey Road', 'London View', 'MD', '20910', '331-112-3425', 'nlsmith@email.som', '00002', '00002');
INSERT INTO `etms_schemma`.`employee` (`EmployeeID`, `FirstName`, `MiddleName`, `LastName`, `SSN`, `Birthdate`, `StreetNumber`, `City`, `State`, `ZipCode`, `Phone`, `Email`, `PositionID`, `EmployeeTypeID`) VALUES ('00004', 'William', 'N/A', 'Johnson', '312-35-1214', '1982-03-19', '1 New York Avenue', 'Germantown', 'MD', '20886', '223-876-2311', 'wJongon@email.com', '00002', '4');
INSERT INTO `etms_schemma`.`employee` (`EmployeeID`, `FirstName`, `MiddleName`, `LastName`, `SSN`, `Birthdate`, `StreetNumber`, `City`, `State`, `ZipCode`, `Phone`, `Email`, `PositionID`, `EmployeeTypeID`) VALUES ('00005', 'Irania', 'Lineth', 'Flores', '212-11-2222', '1980-05-12', '135 Millan Rod', 'Beberly Hills', 'MD', '20979', '923=678-8907', 'IlFlores@email.com', '00001', '00001');


--Inserts into User Table
INSERT INTO `etms_schemma`.`usertable` (`UserID`, `UserName`, `UserPassWord`, `EmployeeID`) VALUES ('00001', 'akramer', 'sfksop', '00001');
INSERT INTO `etms_schemma`.`usertable` (`UserID`, `UserName`, `UserPassWord`, `EmployeeID`) VALUES ('00002', 'jjames', 'kdfgjoi', '00002');
INSERT INTO `etms_schemma`.`usertable` (`UserID`, `UserName`, `UserPassWord`, `EmployeeID`) VALUES ('00003', 'nsmith', '993urw', '00003');
INSERT INTO `etms_schemma`.`usertable` (`UserID`, `UserName`, `UserPassWord`, `EmployeeID`) VALUES ('00004', 'wjohnson', '99fjh23', '00004');
INSERT INTO `etms_schemma`.`usertable` (`UserID`, `UserName`, `UserPassWord`, `EmployeeID`) VALUES ('00005', 'iflores', '98kjrtdf', '00005');

-- Inserts into hours table
INSERT INTO `etms_schemma`.`hourstable` (`HoursTableID`, `TotalWorkedHours`, `DayWorkedHours`) VALUES ('00001', '40', '5');
INSERT INTO `etms_schemma`.`hourstable` (`HoursTableID`, `TotalWorkedHours`, `DayWorkedHours`) VALUES ('00002', '40', '4');
INSERT INTO `etms_schemma`.`hourstable` (`HoursTableID`, `TotalWorkedHours`, `DayWorkedHours`) VALUES ('00003', '30', '5');
INSERT INTO `etms_schemma`.`hourstable` (`HoursTableID`, `TotalWorkedHours`, `DayWorkedHours`) VALUES ('00004', '20', '5');

-- Inserts into Hours Code Table
INSERT INTO `etms_schemma`.`hourscode` (`HoursCodeID`, `HoursCodeName`, `HoursTable_HoursTableID`) VALUES ('00001', 'FTE', '00001');
INSERT INTO `etms_schemma`.`hourscode` (`HoursCodeID`, `HoursCodeName`, `HoursTable_HoursTableID`) VALUES ('00002', 'PTE', '00004');
INSERT INTO `etms_schemma`.`hourscode` (`HoursCodeID`, `HoursCodeName`, `HoursTable_HoursTableID`) VALUES ('00003', 'FTE', '00002');
INSERT INTO `etms_schemma`.`hourscode` (`HoursCodeID`, `HoursCodeName`, `HoursTable_HoursTableID`) VALUES ('00004', 'PTE', '00003');

-- insert to signature Table
INSERT INTO `etms_schemma`.`signature` (`SignatureID`, `PayperiodEnDate`) VALUES ('00001', '2017-01-14');
INSERT INTO `etms_schemma`.`signature` (`SignatureID`, `PayperiodEnDate`) VALUES ('00002', '2017-01-28');
INSERT INTO `etms_schemma`.`signature` (`SignatureID`, `PayperiodEnDate`) VALUES ('00003', '2017-02-11');
INSERT INTO `etms_schemma`.`signature` (`SignatureID`, `PayperiodEnDate`) VALUES ('00004', '2017-02-25');

-- Insert into timesheet table
INSERT INTO `etms_schemma`.`timesheet` (`TimeSheetID`, `StartDate`, `PayPeriod`, `TimeIn`, `TimeOut`, `DateSubmitted`, `Approval`, `Notes`, `Schedule_ScheduleID`, `EmployeeID`, `LeaveID`, `DepartmentID`, `SignatureID`, `HoursTableID`) VALUES ('00001', '2017-01-01', '1', '2017-01-02 8:30:00', '2017-01-02 17:01:00', '2017-01-14 12:30:35', '1', 'None', '00001', '00002', '00008', '00002', '00001', '00002');
INSERT INTO `etms_schemma`.`timesheet` (`TimeSheetID`, `StartDate`, `PayPeriod`, `TimeIn`, `TimeOut`, `DateSubmitted`, `Approval`, `Notes`, `Schedule_ScheduleID`, `EmployeeID`, `LeaveID`, `DepartmentID`, `SignatureID`, `HoursTableID`) VALUES ('00002', '2017-01-01', '1', '2017-01-03 8:15:12', '2017-01-03 16:45:15', '2017-01-14 12:30:35', '1', 'None', '1', '2', '8', '2', '1', '2');
INSERT INTO `etms_schemma`.`timesheet` (`TimeSheetID`, `StartDate`, `PayPeriod`, `TimeIn`, `TimeOut`, `DateSubmitted`, `Approval`, `Notes`, `Schedule_ScheduleID`, `EmployeeID`, `LeaveID`, `DepartmentID`, `SignatureID`, `HoursTableID`) VALUES ('00003', '2017-01-01', '1', '2017-01-04 8:20:14', '2017-01-04 16:50:26', '2017-01-14 12:30:35', '1', 'None', '1', '2', '8', '2', '1', '2');
INSERT INTO `etms_schemma`.`timesheet` (`TimeSheetID`, `StartDate`, `PayPeriod`, `TimeIn`, `TimeOut`, `DateSubmitted`, `Approval`, `Notes`, `Schedule_ScheduleID`, `EmployeeID`, `LeaveID`, `DepartmentID`, `SignatureID`, `HoursTableID`) VALUES ('00004', '2017-01-01', '1', '2017-01-05 8:10:11', '2017-01-05 16:20:02', '2017-01-14 12:30:35', '1', 'None', '1', '2', '8', '2', '1', '2');
INSERT INTO `etms_schemma`.`timesheet` (`TimeSheetID`, `StartDate`, `PayPeriod`, `TimeIn`, `TimeOut`, `DateSubmitted`, `Approval`, `Notes`, `Schedule_ScheduleID`, `EmployeeID`, `LeaveID`, `DepartmentID`, `SignatureID`, `HoursTableID`) VALUES ('00005', '2017-01-01', '1', '2017-01-06 8:30:17', '2017-01-06 17:07:09', '2017-01-14 12:30:35', '1', 'None', '1', '2', '8', '2', '1', '2');

--------------------------------------------------------------------------------------------------------------------------------------------------------
---------------------------from this line below are some of the changes made that were captured.-----------
-- Updates on signature table 
ALTER TABLE `etms_schemma`.`signature` 
ADD COLUMN `PayperiodEnDate` DATE NOT NULL AFTER `SignatureSupervisor`;


-- Updates on Timesheet table
ALTER TABLE `etms_schemma`.`timesheet` 
DROP FOREIGN KEY `fx_DepartmentID`;
ALTER TABLE `etms_schemma`.`timesheet` 
ADD CONSTRAINT `fx_DepartmentID`
  FOREIGN KEY (`DepartmentID`)
  REFERENCES `etms_schemma`.`department` (`DepartmentID`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
-- Updates on Department Table
ALTER TABLE `etms_schemma`.`department` 
CHANGE COLUMN `DepartmentID` `DepartmentID` INT(5) NOT NULL AUTO_INCREMENT ;

-- Updates on Table Employee
ALTER TABLE `etms_schemma`.`employee` 
DROP FOREIGN KEY `fk_EmployeeTypeID`,
DROP FOREIGN KEY `fk_positionID`;
ALTER TABLE `etms_schemma`.`employee` 
CHANGE COLUMN `EmployeeID` `EmployeeID` INT(5) NOT NULL ;
ALTER TABLE `etms_schemma`.`employee` 
ADD CONSTRAINT `fk_EmployeeTypeID`
  FOREIGN KEY (`EmployeeTypeID`)
  REFERENCES `etms_schemma`.`employeetype` (`EmployeeTypeID`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_positionID`
  FOREIGN KEY (`PositionID`)
  REFERENCES `etms_schemma`.`position` (`PositionID`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE `etms_schemma`.`employee` 
CHANGE COLUMN `EmployeeID` `EmployeeID` INT(5) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `etms_schemma`.`employee` 
ADD CONSTRAINT `fk_positionID`
  FOREIGN KEY (`PositionID`)
  REFERENCES `etms_schemma`.`position` (`PositionID`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  ALTER TABLE `etms_schemma`.`employee` 
ADD CONSTRAINT `fk_EmployeeTypeID`
  FOREIGN KEY (`EmployeeTypeID`)
  REFERENCES `etms_schemma`.`employeetype` (`EmployeeTypeID`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

  
  -- Updates in Leave Table
ALTER TABLE `etms_schemma`.`leave` 
CHANGE COLUMN `LeaveID` `LeaveID` INT(5) NOT NULL AUTO_INCREMENT ;

-- Updates in Hours Code Table
ALTER TABLE `etms_schemma`.`hourscode` 
CHANGE COLUMN `HoursCodeID` `HoursCodeID` INT(5) NOT NULL AUTO_INCREMENT ;
  
-- Alter position table
ALTER TABLE `etms_schemma`.`position` 
CHANGE COLUMN `PositionID` `PositionID` INT(5) NOT NULL AUTO_INCREMENT ;

-- Alter Employee Type
ALTER TABLE `etms_schemma`.`employeetype` 
CHANGE COLUMN `EmployeeTypeID` `EmployeeTypeID` INT(5) NOT NULL AUTO_INCREMENT ;

-- Alter Signature Table
ALTER TABLE `etms_schemma`.`signature` 
CHANGE COLUMN `SignatureEmployee` `SignatureEmployee` VARBINARY(256) NULL ,
CHANGE COLUMN `SignatureSupervisor` `SignatureSupervisor` VARBINARY(256) NULL ;







