/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 10.4.17-MariaDB : Database - shippingdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shippingdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `shippingdb`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `date_register` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `customer` */

insert  into `customer`(`id`,`age`,`contact`,`created_at`,`date_register`,`email`,`first_name`,`gender`,`last_name`,`middle_name`,`password`,`status`,`updated_at`,`username`) values 
(2,20,'09123456789','2023-11-23 08:19:04.000000','2023-11-22 16:00:00.000000','jay10@gmail.com','Jay','Male','Fornias','Bernales','123','Active','2023-11-23 08:19:04.000000','jay'),
(3,20,'09123456789','2023-11-23 08:32:22.000000','2023-11-22 16:00:00.000000','jay10@gmail.com','Jay','Female','Fornias','Bernales','1234','Inactive','2023-11-23 08:32:22.000000','jay'),
(4,200,'09123456789','2023-11-24 07:40:56.000000','2023-11-23 16:00:00.000000','jay10@gmail.com','Jay','Male','Fornias','Black','123','Inactive','2023-11-24 07:40:56.000000','jay');

/*Table structure for table `payment` */

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` float NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `date_of_payment` datetime(6) DEFAULT NULL,
  `paid_by` varchar(255) DEFAULT NULL,
  `payment_type` varchar(255) DEFAULT NULL,
  `reference_number` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `payment` */

insert  into `payment`(`id`,`amount`,`created_at`,`date_of_payment`,`paid_by`,`payment_type`,`reference_number`,`updated_at`) values 
(1,1000,NULL,'2023-11-22 16:00:00.000000','Jay','cheque','11101','2023-11-24 06:11:36.000000'),
(2,2999,NULL,'2023-11-20 16:00:00.000000','Sai','others','11103','2023-11-24 06:18:43.000000'),
(3,200,'2023-11-24 06:17:21.000000','2023-11-23 16:00:00.000000','Jek','card','11102','2023-11-24 06:17:21.000000'),
(4,500,'2023-11-24 06:17:54.000000','2023-11-23 16:00:00.000000','Jom','cash','11104','2023-11-24 06:17:54.000000');

/*Table structure for table `personnel` */

DROP TABLE IF EXISTS `personnel`;

CREATE TABLE `personnel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contact` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `personnel` */

insert  into `personnel`(`id`,`contact`,`created_at`,`email`,`first_name`,`last_name`,`middle_name`,`password`,`updated_at`,`username`) values 
(1,'09123456789',NULL,'jay10@gmail.com','Jay','Black','Bernales','admin1','2023-11-24 10:36:15.000000','jay');

/*Table structure for table `shipment` */

DROP TABLE IF EXISTS `shipment`;

CREATE TABLE `shipment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` float NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `item_details` varchar(255) DEFAULT NULL,
  `receiver_contact` varchar(255) DEFAULT NULL,
  `receiver_email` varchar(255) DEFAULT NULL,
  `reference_number` varchar(255) DEFAULT NULL,
  `shipping_date` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `shipment` */

insert  into `shipment`(`id`,`amount`,`created_at`,`customer_name`,`item_details`,`receiver_contact`,`receiver_email`,`reference_number`,`shipping_date`,`status`,`updated_at`) values 
(1,300,NULL,'Jay Bernales Fornias','new','091231343545','jay10@gmail.com','11101','2023-11-22 16:00:00.000000','pending','2023-11-24 13:51:19.000000'),
(2,899,NULL,'Jay Black Fornias','new ','091231343545','jay10@gmail.com','11102','2023-11-20 16:00:00.000000','delivered','2023-11-24 13:51:05.000000'),
(3,455,NULL,'Jay Bernales Fornias','bew','091231343545','jay10@gmail.com','11103','2023-11-22 16:00:00.000000','pending','2023-11-24 13:50:46.000000');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
