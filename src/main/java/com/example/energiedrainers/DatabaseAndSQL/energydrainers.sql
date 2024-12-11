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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klant`
--

LOCK TABLES `klant` WRITE;
/*!40000 ALTER TABLE `klant` DISABLE KEYS */;
INSERT INTO `klant` VALUES (1,'Test','Test','Test','Test','Test'),(2,'112','Skibidi','Toilet','Brainrot','Jr7Qcl+69IQwTgpyNg87kY+XS5OEwr4kbLXqTltmnPI='),(3,'911','Sonic','the Hedhehog','Sonic1991','$2a$10$r0.ALFeE2HKaEBGxW2d34OCbXbjXsp915ctb12o53t/1HAqXQf7Ri'),(4,'112','Friedrich','Nietzsche','Nietzsche1844','$2a$10$ssRFZJqf2ZkYNR7pPaKPhuMLNGwYAi3bCuGfdLdiJ/lfbO6h7oBB.'),(5,'112','Laozi','Taoism','TaoismForLife','$2a$10$r0Ftq9voxzWiS4X0fAn60Oi4OjEU5kPwY9S89SQAV7gxmWTSKKlNC'),(6,'112','Sun','Drainers','SunDrainers','$2a$10$RRW2wjZJoEE6QfKgpkTe6OKGwMaDsTJZgOYg41IwHFThC4X6.3vu2'),(7,'112','Danny','Phantom','DannyPhantom','$2a$10$R.YkIRDrIX7uI1z92EpWfe2yTDwBltDcjjN2Sl.a6ZoLXnsAo2K4m'),(8,'3107142563','Pikachu','Ketchup','PikachuKethup','$2a$10$aFloLnugkTjon61ZROX/hu6F50RBfI2JvNPWWXXKBDnpikO7.ivfa'),(9,'test','test','test','test','$2a$10$IWIZaZFKFH3lChe0H065VO7K1gfV20wxoZoPerQhi8hETwEChnxrS'),(10,'1234','Koe','Art','KoeArt','$2a$10$pp3IE7gHkms4LzQtTH16i.clM6V8UuJIEyTEX5sqMQUQyNyOxlF.W'),(11,'112','Mono','Poly','Monopoly','$2a$10$U6WLYZZtaUVBiyIAJbMVlupkvBQnh.CLlse6fVdZPh5sWk96DbLyu'),(12,'112','Best','ie','Bestie','$2a$10$AJolLTi9bZs/SYTJW.R0i.YU9uSVN7h8et90rh.Vf9RVRvtgr/1.q'),(13,'112','Giga','Chad','GigaChad2004','$2a$10$k.ofv1iDRJCf6IxMjMtfg.Tt/I9V7mSeJjex5xVQd3l96oOnXzA/G'),(14,'112','Adidas','Imposter','AdidasImposter','$2a$10$F3Ab1ohSlClK62oc6F/BAusVbd.r5slHyXpDrQMMjT7.EVQX9s.aa'),(15,'0612345678','Skibidi','Izzler','SkibidiRizzler','$2a$10$w79n.mrOUKAYL2811tzAFunu9snmkdRQxXsEDlnUhu4usTQby3EhK'),(16,'112','CoCo','Melon','CoCoMelon','$2a$10$gSJABvbRKyjlto6spiWa9O4NFkA0PoWFfa1rdiqWXiLOSFW6At9dW'),(17,'1','t','t','t','$2a$10$3wgLdfTUw.nslefGsm5BWOy0/A.QtUuTqfLNicGvWeOnNmVUnRTZm'),(18,'1','t','t','t','$2a$10$Mh/bSanrdCeBAJsETFooweU/fXEQ5dweAqPN2zhQc/P7KPy5Auq9q'),(19,'1','t','t','t','$2a$10$6w7Rbh.xlDd.2nZ8.z1qUeBLJ3ttESI/gXwBpUYrferMN8NLh3Tfm'),(20,'112991','7','days','7daysAweek','$2a$10$93P03XSqkjxMV8l55/iyuOpymRvFi0CaDRt4fRj3RK6O/EJICMSiu'),(21,'112991','7','days','7daysAweek','$2a$10$JVXIgA9VLl.wk9IuFRlnjuZBEr5X9qHl/FdoyspSfojRcYy3OUIqC'),(22,'112','Pikachu','Pikachu','Pikachu','$2a$10$nROxUu7XQ7bXk.pVfjBgIO.USyTKNpwWWcia/R4qJht/LMZHJcuoW'),(23,'112','Pikachu','Pikachu','Pikachu','$2a$10$KMTNhsxkr7xlQT1rFJybv.zaOxban6mA3VlhQxPyIpSzdpulPj5ne'),(24,'112','Pikachu','Pikachu','Pikachu','$2a$10$sS2wEav8pDuNS1iQ/HaM3uYpr/2o3TuLZGGC8RSJCUMHrLiz3B.Qy'),(25,'112','Pikachu','Pikachu','Pikachu','$2a$10$HgDqKKL0p0oNuvZ923yUd.uCnaFPYGMszk/4isILMhjwUEzO6x7ly'),(26,'112','Pikachu','Pikachu','Pikachu','$2a$10$SZU0zvvydH9K.z0/illBq.EE/Hyc9MZQVbcvSE5Jz2K4vUNyRSYvm'),(27,'112','Pikachu','Pikachu','Pikachu','$2a$10$CB6OWsGssGIUkG1eV/ipdOsbxmCsAf0ch3SbXFKIhSqY4FGbndfCi'),(28,'112','Pikachu','Pikachu','Pikachu','$2a$10$nGu8XkzcHmS5P664xJtmUORS38ApMdCuNssvV.cp6BAoM6ndCZMKi'),(29,'112','Pikachu','Pikachu','Pikachu','$2a$10$s79Qe5A5bRykdhxrrX1AU.dL87OzkB1FRQFj3hJXwlUFjPJP/NRuy'),(30,'112','Pikachu','Pikachu','Pikachu','$2a$10$jl4wJi/xhjcvRO/pNyhYAeTH/OxuQwJKl53Un4fH4yE0Jm0c.Yl3C'),(31,'112','Pichu','Pichu','Pichu','$2a$10$hLb8mKF.pvdZEzGwzJ.Vsu0Ku2S3CuyYlctwMUa22kWM6fUeoemIa'),(32,'112','Scrum','Master','ScrumMaster','$2a$10$HXxS3aAVKfFNnxq30m1am.wAAsk6V8ZHVv6eMGlScV4TTu6MDcwRS'),(33,'112911','Kyojuro','Rengoku','Kyojuro','$2a$10$9WUhFUy3y9MAw2VAdYO3veEYUKRmaSr0utS.SfbvSJP1nuI8.xokW'),(34,'112','Skibidi','Dop Dop','SkibidiDopDopYesYes','$2a$10$VLByIS4yxFlKEl5XT3Gnau5UarbMAaZ/f5RiFOSgV1sLGHnk7PxiC'),(35,'112','Teletubbie','Red','TeletubbieRed','$2a$10$gH.6abwoV.UUF5x7UKcuHeMOS6yUaqj3Oc0WQwsRLpRSQvqtIp9.W'),(36,'112','Hyper','Charger','HyperCharge','$2a$10$aAqo2QIh5RnWcMkRWMWrmOpYI9Yhprd.FCaKrgtdHBe7g/iAvg9xC');
/*!40000 ALTER TABLE `klant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meting`
--

DROP TABLE IF EXISTS `meting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meting` (
  `MetingID` int NOT NULL DEFAULT 0,
  `Tijdstip` datetime NOT NULL,
  `HOEK_kantelservo` int DEFAULT NULL,
  `HOEK_draaiservo` int DEFAULT NULL,
  `LDR_BovenRechts` int DEFAULT NULL,
  `LDR_BovenLinks` int DEFAULT NULL,
  `LDR_OnderRechts` int DEFAULT NULL,
  `LDR_OnderLinks` int DEFAULT NULL,
  `TrackerID` int NOT NULL DEFAULT 0,
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
  `TrackerID` int NOT NULL DEFAULT 0,
  `KlantID` int NOT NULL,
  PRIMARY KEY (`TrackerID`),
  UNIQUE KEY `TrackerID` (`TrackerID`),
  FOREIGN KEY (`KlantID`) REFERENCES `klant` (`KlantID`)
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

-- Dump completed on 2024-12-11 13:08:27
klant