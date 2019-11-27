-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: smsproject
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.32-MariaDB

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
-- Table structure for table `chitiethoadon`
--

DROP TABLE IF EXISTS `chitiethoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitiethoadon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hoadonbanhang_id` varchar(45) NOT NULL,
  `sanpham_id` varchar(45) NOT NULL,
  `soluong` int(11) NOT NULL,
  `dongia` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `chitiethoadon_sanpham` (`sanpham_id`),
  KEY `chitiethoadon_hoadonbanhang` (`hoadonbanhang_id`),
  CONSTRAINT `chitiethoadon_hoadonbanhang` FOREIGN KEY (`hoadonbanhang_id`) REFERENCES `hoadonbanhang` (`id`),
  CONSTRAINT `chitiethoadon_sanpham` FOREIGN KEY (`sanpham_id`) REFERENCES `sanpham` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiethoadon`
--

LOCK TABLES `chitiethoadon` WRITE;
/*!40000 ALTER TABLE `chitiethoadon` DISABLE KEYS */;
INSERT INTO `chitiethoadon` VALUES (6,'fasfasfafdafs','SP12342',3,60000000),(7,'asfdadfasdfasfd','SP12346',2,90000000),(8,'sdgfsdgsdgdgf','SP12345',3,96000000),(9,'fdasfafdsadfsf','SP12346',2,90000000),(10,'sfsdfafdfasf','SP12346',2,90000000),(11,'dgfsdgsdgfsdgdg','SP12346',2,90000000),(12,'sdfgsdgsdgsdgfsdg','SP12341',2,106000000),(13,'fgdsfgsdgfsdg','SP12346',2,90000000),(14,'dasfdasdfasfas','SP12346',1,45000000),(15,'fdsgsdfgsdg','SP12342',1,20000000),(16,'fdsgsdfgsdg','SP12342',1,20000000),(17,'dfadfafda','SP12346',1,45000000),(18,'dâfdsfafdsfds','SP12346',2,90000000),(19,'ádfafadsaf','SP12346',2,90000000),(20,'asdfasdfasdfasfd','SP12346',2,90000000),(21,'asdfasfafdasf','SP12346',2,90000000),(22,'adfasdfasfasdf','SP12341',2,106000000),(23,'asfsafasfsadf','SP12342',2,40000000);
/*!40000 ALTER TABLE `chitiethoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietnhap`
--

DROP TABLE IF EXISTS `chitietnhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitietnhap` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sanpham_id` varchar(45) NOT NULL,
  `soluong` int(11) NOT NULL,
  `dongia` double NOT NULL,
  `hoadonnhap_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `chitietnhap_sanpham` (`sanpham_id`),
  KEY `chitietnhap_hoadonnhap` (`hoadonnhap_id`),
  CONSTRAINT `chitietnhap_hoadonnhap` FOREIGN KEY (`hoadonnhap_id`) REFERENCES `hoadonnhap` (`id`),
  CONSTRAINT `chitietnhap_sanpham` FOREIGN KEY (`sanpham_id`) REFERENCES `sanpham` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietnhap`
--

LOCK TABLES `chitietnhap` WRITE;
/*!40000 ALTER TABLE `chitietnhap` DISABLE KEYS */;
INSERT INTO `chitietnhap` VALUES (25,'SP12346',2,90000000,'fasfasdfadfsf'),(26,'SP12346',2,90000000,'fasfasd234'),(27,'SP12345',3,96000000,'asdfadfasf'),(28,'SP12345',2,64000000,'asdfadfasf123'),(29,'SP12345',2,64000000,'afdasdfasdfasf'),(30,'SP12345',1,32000000,'afdasdfasdfasf234'),(31,'SP12341',3,159000000,'asdfasdfafdsfasdfa'),(32,'SP11223',3,360000,'fdasafsadfasdfasdf'),(33,'SP12342',3,60000000,'asfdasdfadfadf');
/*!40000 ALTER TABLE `chitietnhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietxe`
--

DROP TABLE IF EXISTS `chitietxe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitietxe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sokhung` varchar(45) DEFAULT NULL,
  `somay` varchar(45) DEFAULT NULL,
  `chitietnhap_id` int(11) NOT NULL,
  `chitiethoadon_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `chitietxe_chitiethoadon` (`chitiethoadon_id`),
  KEY `chitietxe_chitietnhap` (`chitietnhap_id`),
  CONSTRAINT `chitietxe_chitiethoadon` FOREIGN KEY (`chitiethoadon_id`) REFERENCES `chitiethoadon` (`id`),
  CONSTRAINT `chitietxe_chitietnhap` FOREIGN KEY (`chitietnhap_id`) REFERENCES `chitietnhap` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietxe`
--

LOCK TABLES `chitietxe` WRITE;
/*!40000 ALTER TABLE `chitietxe` DISABLE KEYS */;
INSERT INTO `chitietxe` VALUES (27,'sokhung123','somay123',25,20),(28,'sokhung124','somay127',26,21),(29,'sokhung125','somay125',26,NULL),(31,'sokhung126','somay126',27,NULL),(32,'sokhung127','somay128',27,NULL),(33,'sokhung128','somay129',27,NULL),(34,'sokhung129','somay1231',28,NULL),(35,'sokhung221','somay122',28,NULL),(36,'sokhung122','somay432',29,NULL),(37,'sokhung123','somay143',29,NULL),(38,'sokhung124','somay176',30,NULL),(39,'sokhung666','somay666',31,NULL),(40,'sokhung9887','somay5435',31,NULL),(41,'sokhung923','somay2342',31,NULL),(42,NULL,NULL,32,NULL),(43,NULL,NULL,32,NULL),(44,NULL,NULL,32,NULL),(45,'sokhung98234','somay92834',33,NULL),(46,'sokhung82323','somay2342',33,NULL),(47,'sokhung234','somay642',33,23);
/*!40000 ALTER TABLE `chitietxe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hangsanxuat`
--

DROP TABLE IF EXISTS `hangsanxuat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hangsanxuat` (
  `id` varchar(45) NOT NULL,
  `tenhang` varchar(100) NOT NULL,
  `tennuoc` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hangsanxuat`
--

LOCK TABLES `hangsanxuat` WRITE;
/*!40000 ALTER TABLE `hangsanxuat` DISABLE KEYS */;
INSERT INTO `hangsanxuat` VALUES ('HSX9955','Suzuki','Nhật Bản'),('HSX9966','Piaggio','Italy'),('HSX9977','Yhamaha','Nhật Bản'),('HSX9988','Honda','Nhật Bản');
/*!40000 ALTER TABLE `hangsanxuat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadonbanhang`
--

DROP TABLE IF EXISTS `hoadonbanhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hoadonbanhang` (
  `id` varchar(45) NOT NULL,
  `ngayban` date NOT NULL,
  `khachhang_id` int(11) NOT NULL,
  `nhanvien_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `hoadonbanhang_khachhang` (`khachhang_id`),
  KEY `hoadonbanhang_nhanvien` (`nhanvien_id`),
  CONSTRAINT `hoadonbanhang_khachhang` FOREIGN KEY (`khachhang_id`) REFERENCES `khachhang` (`makhachhang`),
  CONSTRAINT `hoadonbanhang_nhanvien` FOREIGN KEY (`nhanvien_id`) REFERENCES `nhanvien` (`manhanvien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadonbanhang`
--

LOCK TABLES `hoadonbanhang` WRITE;
/*!40000 ALTER TABLE `hoadonbanhang` DISABLE KEYS */;
INSERT INTO `hoadonbanhang` VALUES ('ádfafadsaf','2019-11-05',1,3),('adfasdfasfasdf','2019-11-05',12,5),('asdfasdfasdfasfd','2019-11-13',1,3),('asdfasfafdasf','2019-10-28',1,2),('asfdadfasdfasfd','2019-11-12',12,5),('asfsafasfsadf','2019-11-12',1,5),('dâfdsfafdsfds','2019-11-05',1,5),('dasfdasdfasfas','2019-11-11',1,3),('dfadfafda','2019-11-05',12,5),('dgfsdgsdgfsdgdg','2019-11-06',1,5),('fasfasfafdafs','2019-11-12',1,3),('fdasfafdsadfsf','2019-10-29',1,2),('fdsgsdfgsdg','2019-11-13',12,5),('fgdsfgsdgfsdg','2019-11-12',1,2),('sdfgsdgsdgsdgfsdg','2019-11-12',1,3),('sdgfsdgsdgdgf','2019-11-13',12,2),('sfsdfafdfasf','2019-11-05',1,5);
/*!40000 ALTER TABLE `hoadonbanhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadonnhap`
--

DROP TABLE IF EXISTS `hoadonnhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hoadonnhap` (
  `id` varchar(45) NOT NULL,
  `ngaynhap` date NOT NULL,
  `nhacungcap_id` varchar(45) NOT NULL,
  `nhanvien_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `hoadonnhap_nhacungcap` (`nhacungcap_id`),
  KEY `hoadonnhap_nhanvien` (`nhanvien_id`),
  CONSTRAINT `hoadonnhap_nhacungcap` FOREIGN KEY (`nhacungcap_id`) REFERENCES `nhacungcap` (`id`),
  CONSTRAINT `hoadonnhap_nhanvien` FOREIGN KEY (`nhanvien_id`) REFERENCES `nhanvien` (`manhanvien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadonnhap`
--

LOCK TABLES `hoadonnhap` WRITE;
/*!40000 ALTER TABLE `hoadonnhap` DISABLE KEYS */;
INSERT INTO `hoadonnhap` VALUES ('123333333333','2019-11-12','NCC1236',5),('adasdfa35435','2019-10-30','NCC1236',3),('adasdfaadfaf','2019-10-30','NCC1236',3),('ádfsfadsdf','2019-10-29','NCC1235',2),('afdasdfasdfasf','2019-10-29','NCC1235',5),('afdasdfasdfasf234','2019-10-29','NCC1235',5),('ascasdfas','2019-10-29','NCC1235',3),('asdfadfasf','2019-11-19','NCC1236',3),('asdfadfasf123','2019-11-19','NCC1236',3),('asdfafdasdfsad','2019-10-29','NCC1237',3),('asdfasdfafdsfasdfa','2019-11-05','NCC1236',3),('asfasfafsfafsare','2019-11-19','NCC1236',2),('asfdasdfadfadf','2019-11-14','NCC1235',15),('asfdasdfaffd','2019-11-05','NCC1237',3),('fasdasfsafd','2019-11-12','NCC1236',3),('fasfasd234','2019-11-05','NCC1235',3),('fasfasdfadfsf','2019-11-05','NCC1235',3),('fdasafsadfasdfasdf','2019-11-05','NCC1236',3),('fddfadfsafdasf','2019-11-05','NCC1236',3),('fjdhjdghdfhfgh','2019-11-12','NCC1235',2),('gsdgsdgfsgf','2019-11-05','NCC1235',2),('sadfadfadfadsf','2019-10-29','NCC1234',2),('safdafasf','2019-10-29','NCC1235',2),('sdgfsdgsdgfsdgfsg','2019-11-04','NCC1236',3),('sdgsdgdsfgdsg','2019-10-29','NCC1235',2),('sfasfsdfafdsfaf','2019-10-29','NCC1235',2),('SHD12345','2019-12-11','NCC1234',2),('SHD99988','2019-10-17','NCC1235',5),('SHD99999','2019-10-28','NCC1237',2),('uerywewet','2019-11-12','NCC1235',5);
/*!40000 ALTER TABLE `hoadonnhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `khachhang` (
  `makhachhang` int(11) NOT NULL,
  `tenkhachhang` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `gioitinh` varchar(45) DEFAULT NULL,
  `diachi` varchar(100) DEFAULT NULL,
  `sdt` varchar(15) DEFAULT NULL,
  `thoigiancapnhat` datetime DEFAULT NULL,
  PRIMARY KEY (`makhachhang`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  CONSTRAINT `khachhang_users` FOREIGN KEY (`makhachhang`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'La Văn việt','lavanvietk60@gmail.com','Nam','Nam Từ Liêm - Hà Nội','0122312332','2019-11-23 23:35:05'),(12,'Nguyễn Văn Nam','nguyenvannam@gmail.com','Nam','Bắc Giang','012313213','2019-11-26 09:48:01'),(13,'Trần Thị Hoa','tranhoa@gmail.com','Nữ','Hà Nam','021341341234','2019-11-26 09:51:11'),(14,'Vũ Ngọc Hân','vuhan@gmail.com','Nữ','Yên Bái','023942432','2019-11-27 09:47:37');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhacungcap`
--

DROP TABLE IF EXISTS `nhacungcap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nhacungcap` (
  `id` varchar(45) NOT NULL,
  `tennhacungcap` varchar(100) NOT NULL,
  `diachi` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhacungcap`
--

LOCK TABLES `nhacungcap` WRITE;
/*!40000 ALTER TABLE `nhacungcap` DISABLE KEYS */;
INSERT INTO `nhacungcap` VALUES ('NCC1234','Xe máy đẹp','Từ Sơn - Bắc Ninh'),('NCC1235','Thế giới xe máy','Từ Liêm - Hà Nội'),('NCC1236','Hà Nội xe','Thanh Xuân - Hà Nội'),('NCC1237','Xe honda','Bắc Giang'),('NCC1238','Xe máy Việt Pháp','Hưng yên'),('NCC1239','Xe ga sang trọng','Cầu Giấy - Hà Nội');
/*!40000 ALTER TABLE `nhacungcap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nhanvien` (
  `manhanvien` int(11) NOT NULL,
  `tennhanvien` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `gioitinh` varchar(45) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `diachi` varchar(100) DEFAULT NULL,
  `sdt` varchar(15) DEFAULT NULL,
  `thoigiancapnhat` datetime DEFAULT NULL,
  PRIMARY KEY (`manhanvien`),
  CONSTRAINT `manhanvien_users` FOREIGN KEY (`manhanvien`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (2,'La Văn Minh','lavanminhk51@gmail.com','Nam','2018-12-11','Bắc Ninh - Hà Nội','0123456789',NULL),(3,'Trần Thị Hương','tranhuong@gmail.com','Nữ','1999-10-25','Yên Lạc - Vĩnh Phúc','0123456788','2019-11-24 09:10:50'),(5,'La Văn Hải','lavanhaik52@gmail.com','Nam','1996-11-23','Trùng Khánh - Cao Bằng','0123455677',NULL),(15,'Nguyễn Thị Trà','nguyentra@gmail.com','Nữ','2001-11-29','Hà Nam','023923424','2019-11-27 09:49:12');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_USER'),(2,'ROLE_EMPLOYEE'),(3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sanpham` (
  `id` varchar(45) NOT NULL,
  `loaisanpham` varchar(45) NOT NULL,
  `tensanpham` varchar(100) NOT NULL,
  `phankhoi` varchar(45) DEFAULT NULL,
  `mausac` varchar(45) DEFAULT NULL,
  `dongia` double NOT NULL,
  `hangsanxuat_id` varchar(45) NOT NULL,
  `hinhanh` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sanpham_hangsanxuat` (`hangsanxuat_id`),
  CONSTRAINT `sanpham_hangsanxuat` FOREIGN KEY (`hangsanxuat_id`) REFERENCES `hangsanxuat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES ('SP11223','Phụ tùng','Mũ bảo hiểm','','Đen',120000,'HSX9966','mubaohiem1.jpg'),('SP12312','Xe máy','Vision','125','Trắng',34000000,'HSX9988','vision2.png'),('SP12341','Xe máy','Air Blade','125','Đỏ - Đen',53000000,'HSX9988','airblade1.jpg'),('SP12342','Xe máy','Suzuki viva','110','Đen',20000000,'HSX9955','viva1.jpg'),('SP12343','Phụ tùng','Mũ bảo hiểm',NULL,'Tím',60000,'HSX9977','mubaohiem2.png'),('SP12345','Xe máy','Vision','125','Đen',32000000,'HSX9988','vision1.jpg'),('SP12346','Xe máy','Exciter','150','Xanh',45000000,'HSX9977','exciter1.jpg'),('SP12347','Phụ tùng','Bọc ống xả',NULL,'Đen',100000,'HSX9988','ongxa1.jpg'),('SP12348','Phụ tùng','Đệm yên',NULL,'Đen',75000,'HSX9977','demyen1.jpg'),('SP12349','Xe máy','Vespa','150','Vàng',85000000,'HSX9966','vespa1.png'),('SP12387','Xe máy','SH','150','Đen',92000000,'HSX9988','sh1.jpg'),('SP18765','Xe máy','Air blade','125','Đen - Trắng',51000000,'HSX9988','airblade2.jpg'),('SP54364','Xe máy','SH','150','Trắng',95000000,'HSX9988','sh2.jpg'),('SP88776','Xe máy','Lead','125','Xanh đậm',43000000,'HSX9988','lead1.jpg'),('SP98765','Xe máy','Lead','125','Trắng',41000000,'HSX9988','lead2.jpg');
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_roles_users1_idx` (`user_id`),
  KEY `fk_user_roles_roles1_idx` (`role_id`),
  CONSTRAINT `fk_user_roles_roles1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_roles_users1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1,1),(2,2,2),(3,3,2),(4,3,3),(5,5,3),(6,6,3),(7,7,1),(8,8,2),(9,9,2),(10,10,2),(11,10,1),(12,11,3),(13,11,1),(14,12,1),(15,13,1),(16,14,1),(17,15,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'lavanvietk60@gmail.com','La Văn việt','laviet','$2a$10$1f.aN0CO3A0bQN6MS3vFW.3kj6UM3Hhd3y4460ryrfhFM1EuCG3y.'),(2,'lavanminhk51@gmail.com','La Văn Minh','laminh','$2a$10$1f.aN0CO3A0bQN6MS3vFW.3kj6UM3Hhd3y4460ryrfhFM1EuCG3y.'),(3,'tranhuong@gmail.com','Trần Thị Hương','tranthihuong','$2a$10$5XxJQA9dyzsQ0aIwa4jewuRtAaTwjBqhc5Vw9.HuWOQshYto/qhFa'),(4,'lavantoank59@gmail.com','La Văn Toản','latoan','$2a$10$lRmslaO4Vla7Akk42QknteeCtmMiwAAB9T89DcjnCH3bxA2U.bnCS'),(5,'lavanhaik52@gmail.com','La Văn Hải','lahai','$2a$10$5XxJQA9dyzsQ0aIwa4jewuRtAaTwjBqhc5Vw9.HuWOQshYto/qhFa'),(6,'nguyentien@gmail.com','nguen van tien','nguyentien','$2a$10$s5.iYt00M5b1yKhrDMN4luqPvBxZhzJMfevx2yjDizcJDOe0YFfiy'),(7,'123@gmail.com','hhhhhh','haiyen','$2a$10$g3X1TDFB/8FQj2zBU7EN1OW2YQK6ohha60s3F9mqrlyH57nMTTSl6'),(8,'hoan@gmail.com','tran van hoan','tranhoan','$2a$10$GAu93sMk2qumiXGfhetHceiMw9ZMsb4US11xxD32n/xJY2t6yiC26'),(9,'lavanviet1@gmail.com','lavanviet1','lavanviet1','$2a$10$Zz2YJXi5pefTxzjZ8h/55Oi/SpLx/N0FVN9mZvUhgfoUb5.s7v6yG'),(10,'nguyenvanhong@gmail.com','nguyen van hong','nguyenvanho','$2a$10$z.aIhmsxy7RV1oUfl8l8subbIJ62Cv3BUsURszPxCaKaeWDEybGG6'),(11,'haihaihai@gmail.com','haihaihai','haihaihai','$2a$10$6/Lcqo4vSw3j4nLdq5o6sedPUsoHdgD6Y/JLXiEjn1eiOMXubUXee'),(12,'nguyenvannam@gmail.com','Nguyễn Văn Nam','nguyenvannam','$2a$10$S.69E6Vd7pEkUQSdG8SwR.HJUmBPTfWAZvZrsboI79SdPaRW0EyQK'),(13,'tranhoa@gmail.com','Trần Thị Hoa','tranthihoa','$2a$10$xM9d9SeIGnU3uQk8Awfk0uo4V5zZtPMWf0WIVXWZaXD1tB/BLLF5C'),(14,'vuhan@gmail.com','Vũ Ngọc Hân','vuhan','$2a$10$e68x6zXvX1/G46xFNjFNOOXBC5gswxDU7/GqXw7j2VpRgD.ACYkKC'),(15,'nguyentra@gmail.com','Nguyễn Thị Trà','nguyentra','$2a$10$pRQFEo0/qlayAqy9LMLtCem.CtpFbBrr6WQFRWRmO40HTZrPXeN3C');
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

-- Dump completed on 2019-11-27 10:30:09
