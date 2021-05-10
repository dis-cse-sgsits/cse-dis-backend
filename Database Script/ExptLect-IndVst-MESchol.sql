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
-- Table structure for table `expert_details`
--

DROP TABLE IF EXISTS `expert_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expert_details` (
  `aadhaar_no` bigint DEFAULT NULL,
  `account_no` bigint DEFAULT NULL,
  `bank_name` varchar(255) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `designation` varchar(255) NOT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `expert_id` varchar(255) NOT NULL,
  `fathers_name` varchar(255) DEFAULT NULL,
  `gst_no` varchar(255) DEFAULT NULL,
  `ifsc` varchar(255) DEFAULT NULL,
  `mobile_no` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  `office_address` varchar(255) DEFAULT NULL,
  `pan_no` varchar(255) DEFAULT NULL,
  `pin_code` bigint DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `unique_teqip_id` bigint DEFAULT NULL,
  PRIMARY KEY (`expert_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expert_details`
--

LOCK TABLES `expert_details` WRITE;
/*!40000 ALTER TABLE `expert_details` DISABLE KEYS */;
INSERT INTO `expert_details` VALUES (452879634875,415241889636,'ICICI','Indore','India','Professor, SGSITS','2021-05-01','sanjay.sgsits@gmail.com','3234aeac-679f-4472-b2e7-36893762522d','Rakesh','AY4321111Z','ICICI99687',9893000464,'Sanjay Sharma','SGSITS, Indore','MKLL451386',452001,'Madhya Pradesh','G',7878),(465578981212,212265653339,'Kotak','Indore','India','Professor, DAVV','2021-06-03','ajay.davv@gmail.com','3aa6fe32-3e95-4dd5-a96e-3fd29d003697','Ashok','RE45454Z','KOTAK44545',989383646,'Ajay Verma','DAVV, Indore','KPDD575855',452001,'Madhya Pradesh','G',7998),(447784569693,411402325879,'BOB','Guwahati','India','Research Assistant, IIT Guwahati','2021-12-10','mukund.iitg@gmail.com','92dcd517-7a26-4a28-8a68-8fa4a3efc10e','Suresh','AA45458Z','BOB11123',9826099933,'Mukund Banerjee','Hill road, Guwahati','NNOG55454',4000212,'Assam','G',5554),(787896661234,212200968484,'OBC','Gujarat','India','Professor, NIT Surat','2021-10-10','rakesh.davv@gmail.com','a8063556-5111-43bc-b9ed-9adce8979db4','Ashish','AA46661Z','OBC91110',9827254545,'Rakesh Mehta','Mall road, Surat','MPLL23635',400000,'Gujarat','G',7879);
/*!40000 ALTER TABLE `expert_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expert_lecture_details`
--

DROP TABLE IF EXISTS `expert_lecture_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expert_lecture_details` (
  `attendance` varchar(255) DEFAULT NULL,
  `conveyance` bigint DEFAULT NULL,
  `date` varchar(255) NOT NULL,
  `expert_lecture_id` varchar(255) NOT NULL,
  `expert_name` varchar(255) NOT NULL,
  `honorarium` bigint DEFAULT NULL,
  `notesheet` varchar(255) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `time` varchar(255) NOT NULL,
  `topic` varchar(255) NOT NULL,
  `total_amount` bigint DEFAULT NULL,
  `venue` varchar(255) NOT NULL,
  `expert_designation` varchar(255) NOT NULL,
  `coordinator` varchar(255) NOT NULL,
  `audience` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`expert_lecture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expert_lecture_details`
--

LOCK TABLES `expert_lecture_details` WRITE;
/*!40000 ALTER TABLE `expert_lecture_details` DISABLE KEYS */;
INSERT INTO `expert_lecture_details` VALUES (NULL,0,'2021-10-05','02138ccd-132d-4c29-903d-6d1c73b8b214','Sanjay Sharma',2000,NULL,'Pending','Pending','17:00','Cyber Security',2000,'LT-201','Professor, SGSITS','Mrs. Preeti Khare','BE-I'),(NULL,1500,'2021-03-23','61e8dca0-0975-4eec-acb3-d8d539913c29','Gunjan Pandey',1500,NULL,'Pending','Upcoming','14:30','Kali Linux',3000,'LT-203','Professsor, IIT Delhi','Mrs. Preeti Khare','BE-II'),(NULL,500,'2021-10-05','86929119-afa0-4d96-8e52-5fefd4245cd1','Sanjay Sharma',1000,NULL,'Pending','Pending','14:00','Hybrid Cloud',1500,'LT-101','Professor, SGSITS','Mrs. Peeti Khare','BE-IV,ME-II'),(NULL,2000,'2021-08-03','e658a0b4-9d08-40b8-ba3b-60033e701849','Mukund Banerjee',1000,NULL,'Pending','Completed','14:30','Cloud Computing',3000,'LT-201','Research Assistant, IIT Guwahati','Mrs. Preeti Khare','ME-I'),(NULL,1000,'2021-08-01','ecff9765-d002-468b-8aae-4c06d9af1da6','Sanjay Sharma',1000,NULL,'Pending','Upcoming','15:00','Ethical Hacking',2000,'LT-101','Professsor, SGSITS','Mrs. Preeti Khare','ME-II'),(NULL,1500,'2021-10-15','f77fac89-b391-4041-b8ea-2a669b233367','Rakesh Mehta',1000,NULL,'Pending','Pending','16:00','Machine Learning and Artifical Intelligence',2500,'LT-101','Professor, NIT Surat','Mrs. Preeti Khare','BE-IV,ME-I');
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
  `audience` varchar(255) NOT NULL,
  `coordinator_1` varchar(255) NOT NULL,
  `coordinator_2` varchar(255) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `total_expenditure` bigint DEFAULT NULL,
  `attendance` varchar(255) DEFAULT NULL,
  `notesheet` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`industry_visit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `industry_visit`
--

LOCK TABLES `industry_visit` WRITE;
/*!40000 ALTER TABLE `industry_visit` DISABLE KEYS */;
INSERT INTO `industry_visit` VALUES ('0465aa16-5747-44f4-8a31-676900b7375d','2021-04-10','12:00:00','Concept Solutions','Vijay Nagar','Indore','Madhya Pradesh',452007,'BE-II','Mr. Veerendra Shrivastava','Miss Priyanka Bamne','Pending',NULL,NULL,NULL),('63699f8b-3671-49f0-99a3-1a2fa308b812','2021-04-15','15:00:00','TCS','Super Corridor','Indore','Madhya Pradesh',452001,'ME-I,ME-II','Mr. Veerendra Shrivastava','Miss Priyanka Bamne','Completed',NULL,NULL,NULL),('671f08e7-985d-43e9-883c-aa983994630e','2021-03-30','13:00:00','InfoBeans','IT Park','Indore','Madhya Pradesh',452001,'BE-III,BE-IV','Mr. Veerendra Shrivastava','Miss Priyanka Bamne','Upcoming',NULL,NULL,NULL),('fad052f6-47e5-4541-9546-5f0c955b6f55','2021-08-22','08:00:00','NetSol','MP Nagar','Bhopal','Madhya Pradesh',400000,'ME-I','Mr. Veerendra Shrivastava','Miss Priyanka Bamne','Completed',NULL,NULL,NULL);
/*!40000 ALTER TABLE `industry_visit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `me_scholarship`
--

DROP TABLE IF EXISTS `me_scholarship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `me_scholarship` (
  `enrollment` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `admission_year` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `year` int NOT NULL,
  PRIMARY KEY (`enrollment`),
  UNIQUE KEY `enrollment_no_UNIQUE` (`enrollment`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `me_scholarship`
--

LOCK TABLES `me_scholarship` WRITE;
/*!40000 ALTER TABLE `me_scholarship` DISABLE KEYS */;
/*!40000 ALTER TABLE `me_scholarship` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-28 13:14:34
