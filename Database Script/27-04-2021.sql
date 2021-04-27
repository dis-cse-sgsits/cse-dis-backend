CREATE DATABASE  IF NOT EXISTS `academics` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `academics`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: academics
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `expert_lecture_details`
--

DROP TABLE IF EXISTS `expert_lecture_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expert_lecture_details` (
  `attendance` longblob,
  `conveyance` bigint DEFAULT NULL,
  `date` varchar(255) NOT NULL,
  `expert_lecture_id` varchar(255) NOT NULL,
  `expert_name` varchar(255) NOT NULL,
  `honorarium` bigint DEFAULT NULL,
  `notesheet` longblob,
  `payment_status` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `time` varchar(255) NOT NULL,
  `topic` varchar(255) NOT NULL,
  `total_amount` bigint DEFAULT NULL,
  `venue` varchar(255) NOT NULL,
  `expert_designation` varchar(255) NOT NULL,
  `coordinator` varchar(255) NOT NULL,
  `audience` varchar(255) DEFAULT NULL,
  `notesheet_file_type` varchar(255) DEFAULT NULL,
  `attendance_file_type` varchar(255) DEFAULT NULL,
  `notesheet_extension` varchar(255) DEFAULT NULL,
  `attendance_extension` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`expert_lecture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expert_lecture_details`
--

LOCK TABLES `expert_lecture_details` WRITE;
/*!40000 ALTER TABLE `expert_lecture_details` DISABLE KEYS */;
INSERT INTO `expert_lecture_details` VALUES (NULL,0,'2021-10-05','02138ccd-132d-4c29-903d-6d1c73b8b214','Sanjay Sharma',2000,NULL,'Completed','Completed','17:00','Cyber Security',2000,'LT-201','Professor, SGSITS','Mrs. Preeti Khare','BE-I','application/pdf','application/pdf',NULL,NULL,'Payment deposited by partner bank'),(NULL,200,'2021-06-11','2008563a-c608-4f98-9937-252f7d35d58f','Anshul Agrawal',500,NULL,'Pending','Pending','12:00','Cyber Security in Defence',700,'GCL Lab','Cyber Security Expert','Mr. Veerendra Shrivastava','ME-I',NULL,NULL,NULL,NULL,NULL),(NULL,0,'2021-06-10','231ce063-6f3c-4fe9-b859-646eb02996fa','Amit Meena',700,NULL,'Pending','Pending','12:00','Agile Framework',700,'LT-301','Tech Lead','Mrs. Sonika Shrivastava','BE-IV',NULL,NULL,NULL,NULL,NULL),(NULL,1500,'2021-03-23','61e8dca0-0975-4eec-acb3-d8d539913c29','Gunjan Pandey',1500,NULL,'Pending','Upcoming','14:30','Kali Linux',3000,'LT-203','Professsor, IIT Delhi','Mrs. Preeti Khare','BE-II',NULL,NULL,NULL,NULL,NULL),(NULL,500,'2021-10-05','86929119-afa0-4d96-8e52-5fefd4245cd1','Sanjay Sharma',1000,NULL,'Pending','Pending','14:00','Hybrid Cloud',1500,'LT-101','Professor, SGSITS','Mrs. Peeti Khare','BE-IV,ME-II',NULL,NULL,NULL,NULL,NULL),(NULL,500,'2021-06-10','94f16642-dc56-45da-b47c-a630e0869300','Rishabh Mehra',1000,NULL,'Pending','Pending','11:00','Object Oriented Design',1500,'Software Engineering Lab','Professor, Medicaps University','Miss Priyanka Bamne','BE-II',NULL,NULL,NULL,NULL,NULL),(NULL,200,'2021-08-20','a2dd79c7-201b-4857-8b42-e42e2453b042','Anshul Agrawal',1000,NULL,'Pending','Pending','16:00','Boom in Cyber Security',1200,'LT-102','Cyber Security Expert','Mrs. Preeti Khare','BE-I',NULL,NULL,NULL,NULL,NULL),(NULL,2000,'2021-08-03','e658a0b4-9d08-40b8-ba3b-60033e701849','Mukund Banerjee',1000,NULL,'Pending','Completed','14:30','Cloud Computing',3000,'LT-201','Research Assistant, IIT Guwahati','Mrs. Preeti Khare','ME-I',NULL,NULL,NULL,NULL,NULL),(NULL,1000,'2021-08-01','ecff9765-d002-468b-8aae-4c06d9af1da6','Sanjay Sharma',1000,NULL,'Pending','Pending','15:00','Ethical Hacking',2000,'LT-101','Professsor, SGSITS','Mrs. Preeti Khare','ME-II','','','','',NULL);
/*!40000 ALTER TABLE `expert_lecture_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `industry_visit`
--

DROP TABLE IF EXISTS `industry_visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `industry_visit` (
  `industry_visit_id` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `company_name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `pin` bigint DEFAULT NULL,
  `participants` varchar(255) NOT NULL,
  `coordinator_1` varchar(255) NOT NULL,
  `coordinator_2` varchar(255) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `total_expenditure` bigint DEFAULT NULL,
  `attendance` longblob,
  `notesheet` longblob,
  `attendance_file_type` varchar(255) DEFAULT NULL,
  `notesheet_file_type` varchar(255) DEFAULT NULL,
  `notesheet_extension` varchar(255) DEFAULT NULL,
  `attendance_extension` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`industry_visit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `industry_visit`
--

LOCK TABLES `industry_visit` WRITE;
/*!40000 ALTER TABLE `industry_visit` DISABLE KEYS */;
INSERT INTO `industry_visit` VALUES ('0be78c84-f89f-406d-9ec1-c89b74db8568','2021-05-04','10:00:00','Excel Solutions','Rajiv Gandhi Square','Indore','Madhya Pradesh',452014,'BE-IV','Mr. Rajesh Dhakad','','Pending',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('36a8ef75-bce9-495e-a7ca-95f5a0aaa5b3','2021-10-01','16:00:00','Walkover IT Solutions','Palasia','Indore','Madhya Pradesh',452001,'BE-I,BE-II','Mrs. Aditi Seetha','Miss Priyanka Bamne','Pending',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('44aec24e-d591-459f-b7a2-cd214af1e967','2021-04-30','12:00:00','OpsGenie','Vijay Nagar','Indore','Madhya Pradesh',452001,'ME-I','Mr. Veerendra Shrivastava','','Pending',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('56cc5d5b-abf3-44da-b981-1f710d0a00c9','2021-04-16','15:00:00','System Solutions','Bypass','Jabalpur','Madhya Pradesh',452001,'BE-IV-1-60','Mr. Veerendra Shrivastava','Miss Priyanka Bamne','Upcoming',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('63699f8b-3671-49f0-99a3-1a2fa308b812','2021-04-15','15:00:00','TCS','Super Corridor','Indore','Madhya Pradesh',452001,'ME-I,ME-II','Mr. Veerendra Shrivastava','Miss Priyanka Bamne','Completed',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('671f08e7-985d-43e9-883c-aa983994630e','2021-03-30','13:00:00','InfoBeans','IT Park','Indore','Madhya Pradesh',452001,'BE-III,BE-IV','Mr. Veerendra Shrivastava','Miss Priyanka Bamne','Upcoming',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('95cf3020-3925-4b65-8fc6-5b34b0d4d2e4','2021-05-01','12:00:00','Worldpay','IT Park, Indore','Indore','Madhya Pradesh',452001,'BE-IV','Mr. Veerendra Shrivastava','','Pending',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('e5807e1a-be42-49be-bff0-1d720582debb','2021-10-01','13:00:00','TechSafe','Rasoma Square','Indore','Madhya Pradesh',452001,'BE-IV','Mr. Swarnim Soni','','Pending',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('fad052f6-47e5-4541-9546-5f0c955b6f55','2021-08-22','08:00:00','NetSol','MP Nagar','Bhopal','Madhya Pradesh',400000,'ME-I','Mr. Veerendra Shrivastava','Miss Priyanka Bamne','Completed',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Photos pending'),('fbb9cfe0-e334-4e72-9433-088657f85db9','2021-05-25','09:00:00','Scogo Networks','Upper lake','Bhopal','Madhya Pradesh',462001,'BE-IV','Mr. Veerendra Shrivastava','Mr. Rajesh Dhakad','Pending',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `industry_visit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-27 20:56:22
