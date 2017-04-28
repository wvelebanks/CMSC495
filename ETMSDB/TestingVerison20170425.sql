-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: etms_schemma
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `DepartmentID` int(5) NOT NULL AUTO_INCREMENT,
  `DepartmentName` varchar(45) NOT NULL,
  PRIMARY KEY (`DepartmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Accounting'),(2,'Human Resources'),(3,'Information Technology'),(4,'Maintenance'),(5,'Cleaning');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `EmployeeID` int(5) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) NOT NULL,
  `MiddleName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) NOT NULL,
  `SSN` varchar(11) NOT NULL,
  `Birthdate` date NOT NULL,
  `StreetNumber` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `State` varchar(2) NOT NULL,
  `ZipCode` varchar(10) NOT NULL,
  `Phone` varchar(12) NOT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `PositionID` int(5) NOT NULL,
  `EmployeeTypeID` int(5) NOT NULL,
  PRIMARY KEY (`EmployeeID`),
  KEY `fk_positionID_idx` (`PositionID`),
  KEY `fk_EmployeeTypeID_idx` (`EmployeeTypeID`),
  CONSTRAINT `fk_EmployeeTypeID` FOREIGN KEY (`EmployeeTypeID`) REFERENCES `employeetype` (`EmployeeTypeID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_positionID` FOREIGN KEY (`PositionID`) REFERENCES `position` (`PositionID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='This Table contains all the users tha will interact with the database through the user interface';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Joe','null','Schmo','123-45-6789','2017-04-27','1111  New Avenue','ADMIN','MD','20876','222-333-4455','null',1,1),(2,'Jesse','Holland','James','222-33-4567','1983-04-22','1456 West Road','Springs Arbor','MD','20101','221-987-2222','JhJames@email.com',1,1),(3,'Natalie','Luna','Smith','112-34-0000','1952-07-12','1425 Abbey Road','London View','MD','20910','331-112-3425','nlsmith@email.som',2,2),(4,'William','N/A','Johnson','312-35-1214','1982-03-19','1 New York Avenue','Germantown','MD','20886','223-876-2311','wJongon@email.com',2,4),(5,'Irania','Lineth','Flores','212-11-2222','1980-05-12','135 Millan Rod','Beberly Hills','MD','20979','923=678-8907','IlFlores@email.com',1,1),(6,'Ann','Marie','Kramer','111-22-3333','1978-01-23','2314 New Avenue','Ghost Town','MD','20876','222-333-4455','amkramer@email.com',1,3);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeetype`
--

DROP TABLE IF EXISTS `employeetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employeetype` (
  `EmployeeTypeID` int(5) NOT NULL AUTO_INCREMENT,
  `EmployeeType` varchar(45) NOT NULL,
  PRIMARY KEY (`EmployeeTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeetype`
--

LOCK TABLES `employeetype` WRITE;
/*!40000 ALTER TABLE `employeetype` DISABLE KEYS */;
INSERT INTO `employeetype` VALUES (1,'Full Time'),(2,'Part Time'),(3,'Casual'),(4,'Fixed Term'),(5,'Shift Worker'),(6,'Daily Hire'),(7,'Weekly Hire'),(8,'Probation'),(9,'Outworker');
/*!40000 ALTER TABLE `employeetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hourscode`
--

DROP TABLE IF EXISTS `hourscode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hourscode` (
  `HoursCodeID` int(5) NOT NULL AUTO_INCREMENT,
  `HoursCodeName` varchar(45) DEFAULT NULL,
  `HoursTable_HoursTableID` int(5) NOT NULL,
  PRIMARY KEY (`HoursCodeID`,`HoursTable_HoursTableID`),
  KEY `fk_HoursCode_HoursTable1_idx` (`HoursTable_HoursTableID`),
  CONSTRAINT `fk_HoursCode_HoursTable1` FOREIGN KEY (`HoursTable_HoursTableID`) REFERENCES `hourstable` (`HoursTableID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hourscode`
--

LOCK TABLES `hourscode` WRITE;
/*!40000 ALTER TABLE `hourscode` DISABLE KEYS */;
INSERT INTO `hourscode` VALUES (1,'FTE',1),(2,'PTE',4),(3,'FTE',2),(4,'PTE',3);
/*!40000 ALTER TABLE `hourscode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hourstable`
--

DROP TABLE IF EXISTS `hourstable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hourstable` (
  `HoursTableID` int(5) NOT NULL AUTO_INCREMENT,
  `TotalWorkedHours` int(11) NOT NULL,
  `DayWorkedHours` int(11) NOT NULL,
  PRIMARY KEY (`HoursTableID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hourstable`
--

LOCK TABLES `hourstable` WRITE;
/*!40000 ALTER TABLE `hourstable` DISABLE KEYS */;
INSERT INTO `hourstable` VALUES (1,40,5),(2,40,4),(3,30,5),(4,20,5);
/*!40000 ALTER TABLE `hourstable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave`
--

DROP TABLE IF EXISTS `leave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leave` (
  `LeaveID` int(5) NOT NULL AUTO_INCREMENT,
  `LeaveName` varchar(45) NOT NULL,
  PRIMARY KEY (`LeaveID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave`
--

LOCK TABLES `leave` WRITE;
/*!40000 ALTER TABLE `leave` DISABLE KEYS */;
INSERT INTO `leave` VALUES (1,'AL - Annual Leave'),(2,'HL - Holiday Leave'),(3,'HP - Holiday Pay'),(4,'ND - Night Differential'),(5,'OT - Overtime'),(7,'PL - Personal Leave'),(8,'RG - Regular Pay'),(9,'SL - Sick Leave'),(10,'SP - Sunday Pay'),(11,'VA - Vacation');
/*!40000 ALTER TABLE `leave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position` (
  `PositionID` int(5) NOT NULL AUTO_INCREMENT,
  `PositionType` varchar(45) NOT NULL,
  `PositionName` varchar(45) NOT NULL,
  PRIMARY KEY (`PositionID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'ADMIN','Administrator'),(2,'SUP','Supervisor'),(3,'SUB','Non-Supervisory');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `ScheduleID` int(11) NOT NULL AUTO_INCREMENT,
  `ScheduleName` varchar(45) NOT NULL,
  PRIMARY KEY (`ScheduleID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'Morning Shift'),(2,'Afternoon Shift'),(3,'Night Shift'),(4,'Flexible Shift'),(5,'Complex Shift'),(6,'Maxi-Complex Shift');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signature`
--

DROP TABLE IF EXISTS `signature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `signature` (
  `SignatureID` int(5) NOT NULL AUTO_INCREMENT,
  `SignatureEmployee` varbinary(256) DEFAULT NULL,
  `SignatureSupervisor` varbinary(256) DEFAULT NULL,
  `PayperiodEnDate` date NOT NULL,
  PRIMARY KEY (`SignatureID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signature`
--

LOCK TABLES `signature` WRITE;
/*!40000 ALTER TABLE `signature` DISABLE KEYS */;
INSERT INTO `signature` VALUES (1,NULL,NULL,'2017-01-14'),(2,NULL,NULL,'2017-01-28'),(3,NULL,NULL,'2017-02-11'),(4,NULL,NULL,'2017-02-25');
/*!40000 ALTER TABLE `signature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timesheet`
--

DROP TABLE IF EXISTS `timesheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timesheet` (
  `TimeSheetID` int(5) NOT NULL AUTO_INCREMENT,
  `StartDate` date NOT NULL,
  `PayPeriod` int(5) NOT NULL DEFAULT '0',
  `TimeIn` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `TimeOut` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `DateSubmitted` datetime NOT NULL,
  `Approval` tinyint(1) NOT NULL,
  `Notes` varchar(45) NOT NULL DEFAULT 'Not Specified',
  `Schedule_ScheduleID` int(5) NOT NULL,
  `EmployeeID` int(5) NOT NULL,
  `LeaveID` int(5) NOT NULL,
  `DepartmentID` int(5) NOT NULL,
  `SignatureID` int(5) NOT NULL,
  `HoursTableID` int(5) NOT NULL,
  PRIMARY KEY (`TimeSheetID`),
  KEY `fk_TimeSheet_Schedule1_idx` (`Schedule_ScheduleID`),
  KEY `fk_EmployeeID_idx` (`EmployeeID`),
  KEY `fx_DepartmentID_idx` (`DepartmentID`),
  KEY `fk_SignatureID_idx` (`SignatureID`),
  KEY `fk_HoursTableID_idx` (`HoursTableID`),
  CONSTRAINT `fk_EmployeeID` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_HoursTableID` FOREIGN KEY (`HoursTableID`) REFERENCES `hourstable` (`HoursTableID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_SignatureID` FOREIGN KEY (`SignatureID`) REFERENCES `signature` (`SignatureID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_TimeSheet_Schedule1` FOREIGN KEY (`Schedule_ScheduleID`) REFERENCES `schedule` (`ScheduleID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fx_DepartmentID` FOREIGN KEY (`DepartmentID`) REFERENCES `department` (`DepartmentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timesheet`
--

LOCK TABLES `timesheet` WRITE;
/*!40000 ALTER TABLE `timesheet` DISABLE KEYS */;
INSERT INTO `timesheet` VALUES (1,'2017-01-01',1,'2017-01-02 13:30:00','2017-01-02 22:01:00','2017-01-14 12:30:35',1,'None',1,2,8,2,1,2),(2,'2017-01-01',1,'2017-01-03 13:15:12','2017-01-03 21:45:15','2017-01-14 12:30:35',1,'None',1,2,8,2,1,2),(3,'2017-01-01',1,'2017-01-04 13:20:14','2017-01-04 21:50:26','2017-01-14 12:30:35',1,'None',1,2,8,2,1,2),(4,'2017-01-01',1,'2017-01-05 13:10:11','2017-01-05 21:20:02','2017-01-14 12:30:35',1,'None',1,2,8,2,1,2),(5,'2017-01-01',1,'2017-01-06 13:30:17','2017-01-06 22:07:09','2017-01-14 12:30:35',1,'None',1,2,8,2,1,2);
/*!40000 ALTER TABLE `timesheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertable`
--

DROP TABLE IF EXISTS `usertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertable` (
  `UserID` int(5) NOT NULL,
  `UserName` varchar(45) NOT NULL,
  `UserPassWord` char(64) NOT NULL,
  `EmployeeID` int(5) NOT NULL,
  PRIMARY KEY (`UserID`,`EmployeeID`),
  KEY `fk_UserTable_Employee1_idx` (`EmployeeID`),
  CONSTRAINT `fk_UserTable_Employee1` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertable`
--

LOCK TABLES `usertable` WRITE;
/*!40000 ALTER TABLE `usertable` DISABLE KEYS */;
INSERT INTO `usertable` VALUES (1,'admin','SHA2(\'ETMS@dmin123\',256),1)',1),(2,'jjames','kdfgjoi',2),(3,'nsmith','993urw',3),(4,'wjohnson','99fjh23',4),(5,'iflores','98kjrtdf',5),(6,'akramer','sfksop',6);
/*!40000 ALTER TABLE `usertable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-28  0:09:53
