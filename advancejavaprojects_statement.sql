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
-- Table structure for table `statement`
--

DROP TABLE IF EXISTS `statement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statement` (
  `status` varchar(45) DEFAULT NULL,
  `date_OfTransaction` date DEFAULT NULL,
  `type_OfPayment` varchar(45) DEFAULT NULL,
  `transactionId` int DEFAULT NULL,
  `amount` varchar(20) DEFAULT NULL,
  `userId` int DEFAULT NULL,
  `bank_accountNo` int DEFAULT NULL,
  `transaction_Time` time DEFAULT NULL,
  `remaining_Balance` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statement`
--

LOCK TABLES `statement` WRITE;
/*!40000 ALTER TABLE `statement` DISABLE KEYS */;
INSERT INTO `statement` VALUES ('debit','2024-01-25','Online',12312182,'11.0 Dr',1,8637547,'16:38:24','Rs 2105.0'),('debit','2024-01-25','Online',16990432,'0.16 Dr',1,8637547,'16:39:35','Rs 2104.84'),('debit','2024-01-26','Online',13626264,'0.116 Dr',1,8637547,'07:47:58','Rs 2104.724'),('credit','2024-01-26','Online',10318175,'0.232 Cr',1,8637547,'07:48:11','Rs 2104.956'),('credit','2024-01-26','Online',15065305,'4.5 Cr',1,8637547,'08:44:26','Rs 2109.456'),('debit','2024-01-27','mobileToMobile',17219081,'200.16 Dr',1,8637547,'08:43:20','Rs 1909.296'),('debit','2024-01-27','mobileToMobile',16903668,'9.296 Dr',1,8637547,'09:02:01','Rs 1900.0'),('debit','2024-01-27','mobileToMobile',16736400,'9.5 Dr',1,8637547,'09:03:14','Rs 1900.2'),('debit','2024-01-27','mobileToMobile',15187059,'9.5 Dr',2,1548108,'09:31:05','Rs 4000.0'),('debit','2024-01-27','mobileToMobile',16550310,'100.0 Dr',2,1548108,'09:34:45','Rs 3900.0'),('credit','2024-01-27','mobileToMobile',16834764,'100.0 Cr',1,8637547,'09:34:45','Rs 2009.7');
/*!40000 ALTER TABLE `statement` ENABLE KEYS */;
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
