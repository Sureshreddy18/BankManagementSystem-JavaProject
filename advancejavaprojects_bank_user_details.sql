-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: advancejavaprojects
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `bank_user_details`
--

DROP TABLE IF EXISTS `bank_user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank_user_details` (
  `user_Id` int NOT NULL AUTO_INCREMENT,
  `user_Name` varchar(45) NOT NULL,
  `user_BankEmailId` varchar(45) NOT NULL,
  `user_EmailId` varchar(45) NOT NULL,
  `user_Password` int NOT NULL,
  `user_Gender` varchar(45) NOT NULL,
  `user_Address` varchar(45) NOT NULL,
  `user_Dob` date NOT NULL,
  `user_AccountNo` int NOT NULL,
  `user_Amount` double DEFAULT NULL,
  `user_MobileNo` varchar(45) NOT NULL,
  `IFSC_Code` varchar(45) NOT NULL,
  PRIMARY KEY (`user_Id`),
  UNIQUE KEY `user_BankEmailId_UNIQUE` (`user_BankEmailId`),
  UNIQUE KEY `user_EmailId_UNIQUE` (`user_EmailId`),
  UNIQUE KEY `user_AccountNo_UNIQUE` (`user_AccountNo`),
  UNIQUE KEY `user_Password_UNIQUE` (`user_Password`),
  UNIQUE KEY `user_MobileNo_UNIQUE` (`user_MobileNo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_user_details`
--

LOCK TABLES `bank_user_details` WRITE;
/*!40000 ALTER TABLE `bank_user_details` DISABLE KEYS */;
INSERT INTO `bank_user_details` VALUES (1,'shyamkumar','shyam51@teca53.com','shyam123@gmail.com',1812,'male','Hyd','2000-10-10',8637547,2009.7,'7834476375','IFSCTECA53'),(2,'Yashna','Yashna26@teca53.com','yashna143@gmail.com',6360,'Female','Ong','2002-07-17',1548108,3900,'8484434233','IFSCTECA53');
/*!40000 ALTER TABLE `bank_user_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-28 14:25:30
