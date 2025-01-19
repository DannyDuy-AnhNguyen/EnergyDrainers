-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: energydrainers
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `klant`
--

DROP TABLE IF EXISTS `klant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `klant` (
  `KlantID` int NOT NULL AUTO_INCREMENT,
  `Telefoonnummer` varchar(10) DEFAULT NULL,
  `Voornaam` varchar(40) NOT NULL,
  `Achternaam` varchar(40) NOT NULL,
  `Gebruikersnaam` varchar(30) NOT NULL,
  `Wachtwoord` varchar(255) NOT NULL,
  PRIMARY KEY (`KlantID`),
  UNIQUE KEY `KlantID` (`KlantID`),
  UNIQUE KEY `Gebruikersnaam` (`Gebruikersnaam`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klant`
--

LOCK TABLES `klant` WRITE;
/*!40000 ALTER TABLE `klant` DISABLE KEYS */;
INSERT INTO `klant` VALUES (1,'0612345678','Kyojuro','Rengoku','Kyojuro','$2a$10$T2e4J5EfTmf8ySvQyxe37u.AEG5lp4V4OYR3aEUyGOY3njoBaYzdK'),(51,'112','Skibidi','Toilet','Skibidi','$2a$10$XsAhyDgBo1SyeD/gEqvOWe8BatGkC4Y3aInt35bqbLE5OzrKXm8LO'),(52,'Test','Test','Test','Test','$2a$10$VAb7qXdn1yiSdunR5iskwuWYOKLV2Le99DPtteQRbhz.fbfCy4/lq'),(57,'112','Nobuhide','Seki','Nobuhide','$2a$10$Qu14qiKTYd0SlMy5486pHOHFtJkTssQmDMO5RrFbUWTeaIyEDhEAq'),(58,'112','Yoshi','Dino','Yoshi','$2a$10$/1jQAYNZJDcoMHq2sPamleNLhsv4XnV/kBmQ8A1JzYUH1Nv6Y1q5G'),(59,'112','Sigma ','Boy','Sigma','$2a$10$xvsm06EyQ0h3wQX/f2LIcenz1uHPbfCUO6Veatt9wGWJACTC62Fqu');
/*!40000 ALTER TABLE `klant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meting`
--

DROP TABLE IF EXISTS `meting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meting` (
  `MetingID` int NOT NULL DEFAULT '0',
  `Tijdstip` datetime NOT NULL,
  `HOEK_kantelservo` int DEFAULT NULL,
  `HOEK_draaiservo` int DEFAULT NULL,
  `LDR_BovenRechts` int DEFAULT NULL,
  `LDR_BovenLinks` int DEFAULT NULL,
  `LDR_OnderRechts` int DEFAULT NULL,
  `LDR_OnderLinks` int DEFAULT NULL,
  `TrackerID` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`MetingID`),
  UNIQUE KEY `MetingID` (`MetingID`),
  KEY `TrackerID` (`TrackerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meting`
--

LOCK TABLES `meting` WRITE;
/*!40000 ALTER TABLE `meting` DISABLE KEYS */;
/*!40000 ALTER TABLE `meting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tracker`
--

DROP TABLE IF EXISTS `tracker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tracker` (
  `TrackerID` int NOT NULL AUTO_INCREMENT,
  `KlantID` int NOT NULL,
  PRIMARY KEY (`TrackerID`),
  UNIQUE KEY `TrackerID` (`TrackerID`),
  KEY `KlantID` (`KlantID`),
  CONSTRAINT `tracker_ibfk_1` FOREIGN KEY (`KlantID`) REFERENCES `klant` (`KlantID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tracker`
--

LOCK TABLES `tracker` WRITE;
/*!40000 ALTER TABLE `tracker` DISABLE KEYS */;
INSERT INTO `tracker` VALUES (2,1),(4,1),(5,1),(8,1),(3,51),(1,52),(6,57),(7,58);
/*!40000 ALTER TABLE `tracker` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-19 21:33:01
