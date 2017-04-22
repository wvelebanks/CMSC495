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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-22 18:09:16
