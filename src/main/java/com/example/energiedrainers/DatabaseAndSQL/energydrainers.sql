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
  UNIQUE KEY `KlantID` (`KlantID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klant`
--

LOCK TABLES `klant` WRITE;
/*!40000 ALTER TABLE `klant` DISABLE KEYS */;
INSERT INTO `klant` VALUES (1,'Test','Test','Test','Test','Test'),(2,'112','Skibidi','Toilet','Brainrot','Jr7Qcl+69IQwTgpyNg87kY+XS5OEwr4kbLXqTltmnPI='),(3,'911','Sonic','the Hedhehog','Sonic1991','$2a$10$r0.ALFeE2HKaEBGxW2d34OCbXbjXsp915ctb12o53t/1HAqXQf7Ri'),(4,'112','Friedrich','Nietzsche','Nietzsche1844','$2a$10$ssRFZJqf2ZkYNR7pPaKPhuMLNGwYAi3bCuGfdLdiJ/lfbO6h7oBB.'),(5,'112','Laozi','Taoism','TaoismForLife','$2a$10$r0Ftq9voxzWiS4X0fAn60Oi4OjEU5kPwY9S89SQAV7gxmWTSKKlNC'),(6,'112','Sun','Drainers','SunDrainers','$2a$10$RRW2wjZJoEE6QfKgpkTe6OKGwMaDsTJZgOYg41IwHFThC4X6.3vu2'),(7,'112','Danny','Phantom','DannyPhantom','$2a$10$R.YkIRDrIX7uI1z92EpWfe2yTDwBltDcjjN2Sl.a6ZoLXnsAo2K4m'),(8,'3107142563','Pikachu','Ketchup','PikachuKethup','$2a$10$aFloLnugkTjon61ZROX/hu6F50RBfI2JvNPWWXXKBDnpikO7.ivfa'),(9,'test','test','test','test','$2a$10$IWIZaZFKFH3lChe0H065VO7K1gfV20wxoZoPerQhi8hETwEChnxrS'),(10,'1234','Koe','Art','KoeArt','$2a$10$pp3IE7gHkms4LzQtTH16i.clM6V8UuJIEyTEX5sqMQUQyNyOxlF.W');
/*!40000 ALTER TABLE `klant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meting`
--

DROP TABLE IF EXISTS `meting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meting` (
  `MetingID` int NOT NULL AUTO_INCREMENT,
  `Tijdstip` datetime NOT NULL,
  `HOEK_kantelservo` int DEFAULT NULL,
  `HOEK_draaiservo` int DEFAULT NULL,
  `LDR_BovenRechts` int DEFAULT NULL,
  `LDR_BovenLinks` int DEFAULT NULL,
  `LDR_OnderRechts` int DEFAULT NULL,
  `LDR_OnderLinks` int DEFAULT NULL,
  `TrackerID` int NOT NULL,
  PRIMARY KEY (`MetingID`),
  UNIQUE KEY `MetingID` (`MetingID`),
  KEY `TrackerID` (`TrackerID`),
  CONSTRAINT `meting_ibfk_1` FOREIGN KEY (`TrackerID`) REFERENCES `tracker` (`TrackerID`)
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
  KEY `KlantID` (`KlantID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tracker`
--

LOCK TABLES `tracker` WRITE;
/*!40000 ALTER TABLE `tracker` DISABLE KEYS */;
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

-- Dump completed on 2024-12-04 10:04:38
