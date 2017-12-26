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
-- Table structure for table `secure_resources`
--

DROP TABLE IF EXISTS `secure_resources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secure_resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `create_Date` datetime DEFAULT NULL,
  `create_By` varchar(45) DEFAULT NULL,
  `update_Date` datetime DEFAULT NULL,
  `update_By` varchar(45) DEFAULT NULL,
  `remarks` varchar(245) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `srcurl` varchar(45) DEFAULT NULL COMMENT '资源路径',
  `permission` varchar(45) DEFAULT NULL,
  `is_Menu` int(11) DEFAULT '0' COMMENT '是否为菜单，0否 1是',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统资源';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secure_resources`
--

LOCK TABLES `secure_resources` WRITE;
/*!40000 ALTER TABLE `secure_resources` DISABLE KEYS */;
INSERT INTO `secure_resources` VALUES (1,0,NULL,NULL,NULL,NULL,NULL,0,'二手房收租管理',1,'/rentalorder/list',NULL,1),(2,0,NULL,NULL,NULL,NULL,NULL,0,'租房参数设定',2,'/sysVariables/form',NULL,1);
/*!40000 ALTER TABLE `secure_resources` ENABLE KEYS */;
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
