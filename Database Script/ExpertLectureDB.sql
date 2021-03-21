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
INSERT INTO `expert_details` VALUES (452879634875,415241889636,'ICICI','Indore','India','Professor, SGSITS','2021-05-01','sanjay.sgsits@gmail.com','3234aeac-679f-4472-b2e7-36893762522d','Rakesh','AY4321111Z','ICICI99687',9893000464,'Sanjay Sharma','SGSITS, Indore','MKLL451386',452001,'Madhya Pradesh','G',7878),(465578981212,212265653339,'Kotak','Indore','India','Professor, DAVV','2021-06-03','ajay.davv@gmail.com','3aa6fe32-3e95-4dd5-a96e-3fd29d003697','Ashok','RE45454Z','KOTAK44545',989383646,'Ajay Verma','DAVV, Indore','KPDD575855',452001,'Madhya Pradesh','G',7998),(447784569693,411402325879,'BOB','Guwahati','India','Research Assistant, IIT Guwahati','2021-12-10','mukund.iitg@gmail.com','92dcd517-7a26-4a28-8a68-8fa4a3efc10e','Suresh','AA45458Z','BOB11123',9826099933,'Mukund Banerjee','Hill road, Guwahati','NNOG55454',4000212,'Assam','G',5554),(787896661234,212200968484,'OBC','Gujarat','India','Professor, NIT Surat','2021-10-10','rakesh.davv@gmail.com','a8063556-5111-43bc-b9ed-9adce8979db4','Ashish','AA46661Z','OBC91110',9827254545,'Rakesh Mehta','Mall road, Surat','MPLL23635',400000,'Gujarat','G',7879),(456178951234,208994561235,'SBI','Bhopal','India','Professor, IIT Delhi','2021-03-01','gunjan203144@gmail.com','c9c616ff-f6ef-480e-b184-625f1f768477','Ramesh','AA2340000Z','SBI09078',9424442805,'Gunjan Pandey','L-257 ,Bharti Niketan','EEFF331356',462023,'Madhya Pradesh','G',4555);
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
  `course` varchar(255) DEFAULT NULL,
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
  `year` varchar(255) DEFAULT NULL,
  `expert_designation` varchar(255) NOT NULL,
  PRIMARY KEY (`expert_lecture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expert_lecture_details`
--

LOCK TABLES `expert_lecture_details` WRITE;
/*!40000 ALTER TABLE `expert_lecture_details` DISABLE KEYS */;
INSERT INTO `expert_lecture_details` VALUES (NULL,0,'BE','2021-10-05','02138ccd-132d-4c29-903d-6d1c73b8b214','Sanjay Sharma',2000,NULL,'Pending','Pending','17:00','Cyber Security',2000,'LT-201','IV year','Professor, SGSITS'),(NULL,1500,'BE','2021-03-23','61e8dca0-0975-4eec-acb3-d8d539913c29','Gunjan Pandey',1500,NULL,'Pending','Upcoming','14:30','Kali Linux',3000,'LT-203','IV year','Professsor, IIT Delhi'),(NULL,500,'ME','2021-06-10','b8671ecf-e997-4124-bd8c-fc6382fac4fe','Ajay Verma',1000,NULL,'Pending','Pending','12:30','Data Mining',1500,'LT-202','II year','Professor, DAVV'),(NULL,2000,'ME','2021-08-03','e658a0b4-9d08-40b8-ba3b-60033e701849','Mukund Banerjee',1000,NULL,'Pending','Completed','14:30','Cloud Computing',3000,'LT-201','I year','Research Assistant, IIT Guwahati'),(NULL,1000,'BE','2021-08-01','ecff9765-d002-468b-8aae-4c06d9af1da6','Sanjay Sharma',1000,NULL,'Pending','Upcoming','15:00','Ethical Hacking',2000,'LT-101','III year','Professsor, SGSITS'),(NULL,1500,'BE','2021-10-15','f77fac89-b391-4041-b8ea-2a669b233367','Rakesh Mehta',1000,NULL,'Pending','Pending','16:00','Machine Learning and Artifical Intelligence',2500,'LT-101','II year','Professor, NIT Surat');
/*!40000 ALTER TABLE `expert_lecture_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-21 16:46:15
