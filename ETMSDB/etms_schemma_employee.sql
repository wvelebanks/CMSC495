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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `EmployeeID` int(5) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) NOT NULL,
  `MiddleName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `SSN` varchar(11) NOT NULL,
  `Birthdate` date NOT NULL,
  `StreetNumber` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `State` varchar(2) NOT NULL,
  `ZipCode` varchar(10) NOT NULL,
  `Phone` varchar(12) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `PositionID` int(5) NOT NULL,
  `EmployeeTypeID` int(5) NOT NULL,
  PRIMARY KEY (`EmployeeID`),
  KEY `fk_positionID_idx` (`PositionID`),
  KEY `fk_EmployeeTypeID_idx` (`EmployeeTypeID`),
  CONSTRAINT `fk_EmployeeTypeID` FOREIGN KEY (`EmployeeTypeID`) REFERENCES `employeetype` (`EmployeeTypeID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_positionID` FOREIGN KEY (`PositionID`) REFERENCES `position` (`PositionID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='This Table contains all the users tha will interact with the database through the user interface';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Ann','Marie','Kramer','111-22-3333','1978-01-23','2314 New Avenue','Ghost Town','MD','20876','222-333-4455','amkramer@email.com',1,3),(2,'Jesse','Holland','James','222-33-4567','1983-04-22','1456 West Road','Springs Arbor','MD','20101','221-987-2222','JhJames@email.com',1,1),(3,'Natalie','Luna','Smith','112-34-0000','1952-07-12','1425 Abbey Road','London View','MD','20910','331-112-3425','nlsmith@email.som',2,2),(4,'William','N/A','Johnson','312-35-1214','1982-03-19','1 New York Avenue','Germantown','MD','20886','223-876-2311','wJongon@email.com',2,4),(5,'Irania','Lineth','Flores','212-11-2222','1980-05-12','135 Millan Rod','Beberly Hills','MD','20979','923=678-8907','IlFlores@email.com',1,1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-22 18:09:19
