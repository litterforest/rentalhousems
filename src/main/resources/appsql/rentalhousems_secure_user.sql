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
-- Table structure for table `secure_user`
--

DROP TABLE IF EXISTS `secure_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secure_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_Date` datetime DEFAULT NULL,
  `create_By` varchar(45) DEFAULT NULL,
  `update_Date` datetime DEFAULT NULL,
  `update_By` varchar(45) DEFAULT NULL,
  `remarks` varchar(245) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `realname` varchar(45) DEFAULT NULL COMMENT '真实姓名',
  `is_admin` int(11) DEFAULT '0' COMMENT '是否为管理员',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='管理人员用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secure_user`
--

LOCK TABLES `secure_user` WRITE;
/*!40000 ALTER TABLE `secure_user` DISABLE KEYS */;
INSERT INTO `secure_user` VALUES (3,'2017-12-14 14:55:33',NULL,'2017-12-14 14:55:33',NULL,NULL,'cobee','d1465a4fed4a138f074b3490a5574b48','18027041862',0,'陈淦森',1),(4,'2017-12-16 18:06:03',NULL,'2017-12-16 18:06:03',NULL,NULL,'admin','68a43d1a89793013cfa3425717aa190a','18027041863',NULL,'admin',0);
/*!40000 ALTER TABLE `secure_user` ENABLE KEYS */;
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
