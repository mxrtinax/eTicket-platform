-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: eticket
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `utilizatori`
--

DROP TABLE IF EXISTS `utilizatori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilizatori` (
  `idutilizator` int NOT NULL AUTO_INCREMENT,
  `mail` varchar(45) NOT NULL,
  `nume` varchar(45) NOT NULL,
  `prenume` varchar(45) NOT NULL,
  `parola` varchar(45) NOT NULL,
  `sold` float unsigned zerofill DEFAULT NULL,
  `procentreducere` int DEFAULT NULL,
  `nrbiletereduse` int DEFAULT NULL,
  `drepturi` int DEFAULT NULL,
  PRIMARY KEY (`idutilizator`,`mail`),
  UNIQUE KEY `mail_UNIQUE` (`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilizatori`
--

LOCK TABLES `utilizatori` WRITE;
/*!40000 ALTER TABLE `utilizatori` DISABLE KEYS */;
INSERT INTO `utilizatori` VALUES (3,'mail2@info.ro','numeee','prenumee','parola',NULL,NULL,NULL,NULL),(4,'mail3@info.ro','numeee','prenumee','parola',NULL,NULL,NULL,NULL),(5,'mail4@info.ro','numeee','prenumee','parola',NULL,NULL,NULL,NULL),(6,'ut@mail','nume','prenume','parola',NULL,NULL,NULL,NULL),(7,'un mail','nume','prenume','parola',000000000050,5,10,NULL),(8,'alt mail','num2','prenume2','parola22',000000000050,NULL,NULL,NULL),(10,'si alt mail','num3','prenume3','parola3',NULL,NULL,NULL,3),(11,'martinaspaul@gmail.com','Martinas','Paul','parolamea',000000000000,0,0,0),(12,'admin@mail.com','adminadmin','jr','adminpa55',000000000000,0,0,3),(13,'mail@mail.c','adf','manaa','parola',000000000000,0,0,0);
/*!40000 ALTER TABLE `utilizatori` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-23 23:50:23
