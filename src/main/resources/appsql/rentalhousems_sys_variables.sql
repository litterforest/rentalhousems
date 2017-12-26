-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: rentalhousems
-- ------------------------------------------------------
-- Server version	5.5.32

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
-- Table structure for table `sys_variables`
--

DROP TABLE IF EXISTS `sys_variables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_variables` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_Date` datetime DEFAULT NULL,
  `create_By` varchar(45) DEFAULT NULL,
  `update_Date` datetime DEFAULT NULL,
  `update_By` varchar(45) DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  `current_Renting_Power_Consumption` decimal(12,2) DEFAULT NULL,
  `current_Berth_Power_Consumption` decimal(12,2) DEFAULT NULL,
  `standard_Renting_Electricity` decimal(12,2) DEFAULT NULL,
  `standard_Berth_Electricity` decimal(12,2) DEFAULT NULL,
  `user_id` int(11) DEFAULT '0' COMMENT '用户外键ID',
  `del_flag` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_variables`
--

LOCK TABLES `sys_variables` WRITE;
/*!40000 ALTER TABLE `sys_variables` DISABLE KEYS */;
INSERT INTO `sys_variables` VALUES (2,'2017-12-14 14:55:33',NULL,'2017-12-14 15:04:27',NULL,NULL,8500.00,8000.00,0.70,1.03,3,0),(3,'2017-12-16 18:06:03',NULL,'2017-12-16 18:06:03',NULL,NULL,0.00,0.00,0.00,0.00,4,0);
/*!40000 ALTER TABLE `sys_variables` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-26 15:11:38
