CREATE DATABASE  IF NOT EXISTS `gouniver` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gouniver`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gouniver
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Dumping data for table `exams`
--

LOCK TABLES `exams` WRITE;
/*!40000 ALTER TABLE `exams` DISABLE KEYS */;
INSERT INTO `exams` VALUES (6,'biology'),(5,'chemistry'),(9,'creativity'),(8,'foreign_lang'),(7,'geography'),(3,'math'),(4,'physics'),(2,'ua_history'),(1,'ua_lang_lit');
/*!40000 ALTER TABLE `exams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `majors`
--

LOCK TABLES `majors` WRITE;
/*!40000 ALTER TABLE `majors` DISABLE KEYS */;
INSERT INTO `majors` VALUES (1,'Computer Science','ua_lang_lit','math','physics'),(2,'History','ua_lang_lit','ua_history','geography'),(3,'Philology','ua_lang_lit','ua_history','foreign_lang'),(4,'Economics','ua_lang_lit','math','foreign_lang'),(5,'Music','ua_lang_lit','ua_history','creativity'),(6,'Journalism','ua_lang_lit','foreign_lang','geography'),(7,'Sociology','ua_lang_lit','math','foreign_lang'),(8,'Law','ua_lang_lit','ua_history','math'),(9,'Mechanical Engineering','ua_lang_lit','math','physics'),(10,'Chemical Techologies','ua_lang_lit','chemistry','math'),(11,'Electronics','ua_lang_lit','math','physics'),(12,'Architecture','ua_lang_lit','ua_history','creativity'),(13,'Agriculture','ua_lang_lit','biology','math'),(14,'Medicine','ua_lang_lit','biology','chemistry'),(15,'Design','ua_lang_lit','ua_history','creativity');
/*!40000 ALTER TABLE `majors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `marks`
--

LOCK TABLES `marks` WRITE;
/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (0,'god@godmail.god','god','God','God',1),(1,'pavlov@dog.com','123','Dog','Pavlov',0),(2,'potter@hogwarts.edu','123','Harry','Potter',0),(3,'nelokh@mail.ru','123','Ne','Lokh',0),(4,'nechuy@ukr.net','123','Ivan','Nechuy-Levytsky',0),(5,'macho1863@yahoo.com','123','Olha','Kobylianska',0),(6,'mascot@disney.com','123','Mickey','Mouse',0),(7,'billie@gmail.com','123','Billie','Holiday',0),(8,'count@transylmail.ro','123','Count','Dracula',0),(9,'beatles@royalmail.uk','123','Michelle','Mabelle',0),(10,'moviestar@cornhub.com','123','Sasha','Grey',0),(11,'tolia49@i.ua','123','Prodam','Samokat',0),(12,'heroyam@slava.ua','123','Stepan','Bandera',0),(13,'legalize@jamail.jah','123','Bob','Marley',0),(14,'virgin@paradise.org','123','Mary','Virgin',0),(15,'krevetko@seafood.org','111','Shrimp','Azovsky',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-27  0:25:03
