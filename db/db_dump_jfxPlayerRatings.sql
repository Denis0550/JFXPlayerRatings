CREATE DATABASE  IF NOT EXISTS `jfx_player_ratings` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `jfx_player_ratings`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: jfx_player_ratings
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `mu_players`
--

DROP TABLE IF EXISTS `mu_players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mu_players` (
  `id_player` int NOT NULL AUTO_INCREMENT,
  `sq_number` int DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `nationality` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_player`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mu_players`
--

LOCK TABLES `mu_players` WRITE;
/*!40000 ALTER TABLE `mu_players` DISABLE KEYS */;
INSERT INTO `mu_players` VALUES (1,1,'GK','David','de Gea','ESP'),(2,22,'GK','Tom','Heaton','ENG'),(3,5,'DEF','Harry','Maguire','FRA'),(4,2,'DEF','Victor','Lindelöf','FRA'),(5,19,'DEF','Raphaël','Varane','FRA'),(6,6,'DEF','Lisandro','Martínez','ARG'),(7,23,'DEF','Luke','Shaw','ENG'),(8,20,'DEF','Diogo','Dalot','POR'),(9,12,'DEF','Tyrell','Malacia','NED'),(10,29,'DEF','Aaron','Wan-Bissaka','ENG'),(11,18,'MID','Carlos Henrique','Casimiro','BRA'),(12,14,'MID','Christian','Eriksen','DEN'),(13,8,'MID','Bruno','Fernandes','POR'),(14,39,'MID','Scott','McTominay','SCO'),(15,17,'MID','Rodrigues de Paula','Fred','BRA'),(16,34,'MID','Donny','van de Beek','NED'),(17,25,'ATK','Jadon','Sancho','ENG'),(18,21,'ATK','Matheus dos Santos','Antony','BRA'),(19,10,'ATK','Marcus','Rashford','ENG'),(20,49,'ATK','Alejandro','Garnacho','ARG'),(21,9,'ATK','Anthony','Martial','ENG'),(22,27,'ATK','Wout','Weghorst','NED');
/*!40000 ALTER TABLE `mu_players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pl_ratings_one`
--

DROP TABLE IF EXISTS `pl_ratings_one`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pl_ratings_one` (
  `id` int NOT NULL AUTO_INCREMENT,
  `game_week` int DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `rating` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pl_ratings_one`
--

LOCK TABLES `pl_ratings_one` WRITE;
/*!40000 ALTER TABLE `pl_ratings_one` DISABLE KEYS */;
INSERT INTO `pl_ratings_one` VALUES (1,1,'de Gea',8),(2,2,'de Gea',7),(3,3,'de Gea',6),(4,4,'de Gea',8),(5,5,'de Gea',9),(6,1,'Martínez',7),(7,2,'Martínez',8),(8,3,'Martínez',9),(9,4,'Martínez',8),(10,5,'Martínez',9),(11,1,'Fernandes',9),(12,3,'Fernandes',10),(13,4,'Fernandes',6),(14,5,'Fernandes',9),(15,1,'Rashford',9),(16,2,'Eriksen',7),(17,3,'Eriksen',8),(18,4,'Eriksen',5),(19,5,'Eriksen',9),(20,1,'Rashford',7),(21,2,'Rashford',8),(22,3,'Rashford',9),(23,4,'Rashford',8),(24,5,'Rashford',10);
/*!40000 ALTER TABLE `pl_ratings_one` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-13 23:37:58
