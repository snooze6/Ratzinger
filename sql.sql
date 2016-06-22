-- MySQL dump 10.13  Distrib 5.7.11, for Linux (x86_64)
--
-- Host: ratztest.cdh6gtvsyebq.us-east-1.rds.amazonaws.com    Database: ratztest
-- ------------------------------------------------------
-- Server version	5.5.5-10.0.17-MariaDB-log

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
-- Table structure for table `Comments`
--

DROP TABLE IF EXISTS `Comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Comments` (
  `idComment` int(11) NOT NULL AUTO_INCREMENT,
  `idCommentParent` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `content` varchar(300) DEFAULT NULL,
  `dt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `idProduct` int(11) DEFAULT NULL,
  `DNI` varchar(9) DEFAULT NULL,
  `valoracion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idComment`),
  KEY `idCommentParent` (`idCommentParent`),
  KEY `DNI` (`DNI`),
  KEY `idProduct` (`idProduct`),
  CONSTRAINT `Comments_ibfk_1` FOREIGN KEY (`idCommentParent`) REFERENCES `Comments` (`idComment`),
  CONSTRAINT `Comments_ibfk_2` FOREIGN KEY (`DNI`) REFERENCES `users` (`DNI`),
  CONSTRAINT `Comments_ibfk_3` FOREIGN KEY (`idProduct`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comments`
--

LOCK TABLES `Comments` WRITE;
/*!40000 ALTER TABLE `Comments` DISABLE KEYS */;
INSERT INTO `Comments` VALUES (1,NULL,'ArmandoNogueira Rio','Me gusta valorar mal','2016-04-04 21:33:39',1,'12341234M',1),(2,1,'ArmandoNogueira Rio','Esto se merecia un 5','2016-04-04 21:34:31',1,'12341234M',1),(3,1,'ArmandoNogueira Rio','Esto es un 4','2016-04-04 21:34:47',1,'12341234M',1),(4,NULL,'ArmandoNogueira Rio','Esto es un 3','2016-04-04 21:35:11',1,'12341234M',3),(5,2,'ArmandoNogueira Rio','Esto es un 3','2016-04-04 21:39:15',1,'12341234M',3);
/*!40000 ALTER TABLE `Comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admins` (
  `DNI` varchar(9) NOT NULL,
  KEY `DNI` (`DNI`),
  CONSTRAINT `admins_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `users` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES ('12341234M'),('98765432J');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_product`
--

DROP TABLE IF EXISTS `order_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_product` (
  `idorder` int(11) NOT NULL,
  `idproduct` int(11) NOT NULL,
  `unitaryPrice` float DEFAULT NULL,
  `quantity` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idorder`,`idproduct`),
  KEY `fk_order_product_1_idx` (`idproduct`),
  CONSTRAINT `fk_order_product_1` FOREIGN KEY (`idproduct`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_product_2` FOREIGN KEY (`idorder`) REFERENCES `orders` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product`
--

LOCK TABLES `order_product` WRITE;
/*!40000 ALTER TABLE `order_product` DISABLE KEYS */;
INSERT INTO `order_product` VALUES (1,8,12.95,'1'),(1,10,50,'1'),(2,10,50,'1'),(3,2,16.95,'1'),(4,3,16.95,'1'),(5,1,14.95,'1'),(5,2,16.95,'1'),(5,5,14.95,'1'),(6,10,50,'1'),(7,10,50,'1'),(8,3,16.95,'1'),(9,2,16.95,'1'),(9,7,14.95,'1'),(9,9,16.95,'1'),(10,1,14.95,'1'),(10,8,12.95,'1'),(10,9,16.95,'1'),(11,2,13.56,'1'),(11,7,11.96,'1'),(11,8,10.36,'1'),(12,3,13.56,'1'),(12,7,11.96,'1'),(12,8,10.36,'1'),(13,3,13.56,'1'),(13,7,11.96,'1'),(14,1,11.96,'1'),(14,8,10.36,'1'),(15,1,11.96,'1'),(15,10,40,'1'),(16,1,11.96,'1'),(16,8,10.36,'1'),(17,2,13.56,'1'),(17,7,11.96,'1'),(18,1,11.96,'1'),(19,1,11.96,'1'),(19,3,13.56,'1'),(20,2,13.56,'1'),(20,10,40,'2'),(21,10,50,'3'),(22,1,11.96,'1'),(22,2,13.56,'1'),(23,1,11.96,'1'),(23,5,11.96,'1'),(24,1,11.96,'1'),(24,3,13.56,'1'),(25,2,13.56,'1'),(25,3,13.56,'1'),(26,2,13.56,'1'),(26,4,11.16,'1'),(27,3,13.56,'1'),(27,5,11.96,'1'),(28,1,11.96,'1'),(28,3,13.56,'1'),(29,1,11.96,'1'),(29,2,13.56,'1'),(29,5,11.96,'1'),(30,10,40,'1'),(31,1,11.96,'1'),(32,1,11.96,'1'),(32,6,10.36,'1'),(33,2,13.56,'1'),(34,1,14.95,'1'),(35,6,10.36,'1'),(36,3,13.56,'1');
/*!40000 ALTER TABLE `order_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userDNI` varchar(9) NOT NULL,
  `total` float NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_orders_1_idx` (`userDNI`),
  CONSTRAINT `fk_orders_1` FOREIGN KEY (`userDNI`) REFERENCES `users` (`DNI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'12345678Z',62.95,'2016-04-02 18:22:40'),(2,'12345678Z',50,'2016-04-02 19:03:24'),(3,'12345678Z',66.95,'2016-04-03 00:49:11'),(4,'53481946T',13.56,'2016-04-03 15:35:58'),(5,'53481946T',37.48,'2016-04-03 15:37:08'),(6,'12341234M',50,'2016-04-03 16:07:46'),(7,'12341234M',50,'2016-04-03 16:21:16'),(8,'12341234M',16.95,'2016-04-03 16:27:23'),(9,'53481946T',39.08,'2016-04-03 17:59:41'),(10,'53481946T',35.88,'2016-04-03 18:01:32'),(11,'53481946T',44.85,'2016-04-03 18:04:20'),(12,'53481946T',44.85,'2016-04-03 18:09:21'),(13,'53481946T',31.9,'2016-04-03 18:29:27'),(14,'53481946T',27.9,'2016-04-03 18:59:00'),(15,'53481946T',64.95,'2016-04-03 19:01:42'),(16,'53481946T',27.9,'2016-04-03 19:12:05'),(17,'53481946T',31.9,'2016-04-03 19:14:40'),(18,'53481946T',14.95,'2016-04-03 19:23:52'),(19,'53481946T',31.9,'2016-04-03 19:39:27'),(20,'53481946T',116.95,'2016-04-03 19:50:13'),(21,'12345678Z',120,'2016-04-03 19:51:42'),(22,'53481946T',31.9,'2016-04-03 19:56:09'),(23,'53481946T',29.9,'2016-04-03 20:11:17'),(24,'53481946T',31.9,'2016-04-03 20:16:05'),(25,'53481946T',33.9,'2016-04-03 20:18:40'),(26,'53481946T',30.9,'2016-04-03 20:22:31'),(27,'53481946T',31.9,'2016-04-03 20:28:19'),(28,'12345678Z',31.9,'2016-04-03 20:30:58'),(29,'53481946T',46.85,'2016-04-03 20:36:29'),(30,'53481946T',50,'2016-04-03 23:28:27'),(31,'53481946T',14.95,'2016-04-04 20:15:30'),(32,'53481946T',27.9,'2016-04-04 20:51:23'),(33,'53481946T',16.95,'2016-04-04 20:56:28'),(34,'98765432A',11.96,'2016-04-04 20:59:03'),(35,'53481946T',12.95,'2016-04-04 21:02:28'),(36,'53481946T',16.95,'2016-04-04 21:02:59');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `unitary_price` float DEFAULT NULL,
  `image` varchar(255) NOT NULL DEFAULT 'http://www.puya.se/wp-content/uploads/2016/03/PuyaSubs-Gintama-S3-01-720pE5C140D3V2-013.jpg',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Yuan ','Lorem fistrum mamaar ese pedazo de quietooor ',' The Guo Brothers ',' China ',14.95,'https://realworldrecords.com/_public/ir/400/0/GLOBAL_PUBLIC/img/releases/23.jpg'),(2,'Drums of Passion ','Lorem fistrum mamaar ese pedazo de quietooor ',' Babatunde Olatunji ',' Nigeria ',16.95,'https://upload.wikimedia.org/wikipedia/en/3/30/Babatunde_Olatunji_Drums_of_Passion.jpg'),(3,'Kaira ','Lorem fistrum mamaar ese pedazo de quietooor ',' Tounami Diabate',' Mali ',16.95,'http://ecx.images-amazon.com/images/I/61p8w3pIoIL.jpg'),(4,'The Lion is Loose ','Lorem fistrum mamaar ese pedazo de quietooor ',' Eliades Ochoa ',' Cuba ',13.95,'http://ecx.images-amazon.com/images/I/510PTCFWGZL.jpg'),(5,'Dance the Devil Away ','Lorem fistrum mamaar ese pedazo de quietooor ',' Outback ',' Australia ',14.95,'http://ecx.images-amazon.com/images/I/417VXCEY9AL.jpg'),(6,'Record of Changes ','Lorem fistrum mamaar ese pedazo de quietooor ',' Samulnori ',' Korea ',12.95,'http://4.bp.blogspot.com/_atPaKDf9gk0/SL8X9kAsMsI/AAAAAAAAAIQ/8thDZGKESh0/s320/IMG.jpg'),(7,'Djelika ','Lorem fistrum mamaar ese pedazo de quietooor ',' Tounami Diabate ',' Mali ',14.95,'http://2.bp.blogspot.com/-HT238A38Sm8/TrHqBakJPEI/AAAAAAAADPs/Em6qbu6Os_k/s1600/20100124212200.jpg'),(8,'Rapture ','Lorem fistrum mamaar ese pedazo de quietooor ',' Nusrat Fateh Ali Khan ',' Pakistan ',12.95,'http://ecx.images-amazon.com/images/I/41KPDMBKW4L.jpg'),(9,'Cesaria Evora ','Lorem fistrum mamaar ese pedazo de quietooor ',' Cesaria Evora ',' Cape Verde ',16.95,'http://ecx.images-amazon.com/images/I/81vGVx7cQ-L._SL1500_.jpg'),(10,'DAA ','',' GSTIC ',' Spain ',50,'http://i3.kym-cdn.com/photos/images/original/000/343/462/79a.gif'),(18,'Gothic Lolita Propaganda','All heil Yui-sama','Yousei Teikoku','Japan',15.99,'http://www.game-ost.com/static/covers_soundtracks/1/4/14080_558869.jpg'),(19,'Gothic Lolita Agitator','All heil Yui-sama','Yousei Teikoku','Japan',20,'http://ecx.images-amazon.com/images/I/619MOIT3arL._SY300_.jpg'),(20,'Gothic Lolita Propaganda','All heil Yui-sama','Yousei Teikoku','Japan',15.99,'http://www.game-ost.com/static/covers_soundtracks/1/4/14080_558869.jpg'),(21,'Yuan','','adasjlbdbjdfbjbjfdbkjÃ±dfb','sefsf',0,'./web/images/notfound.png');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quantities`
--

DROP TABLE IF EXISTS `quantities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quantities` (
  `id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`,`quantity`),
  CONSTRAINT `quantities_ibfk_1` FOREIGN KEY (`id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quantities`
--

LOCK TABLES `quantities` WRITE;
/*!40000 ALTER TABLE `quantities` DISABLE KEYS */;
INSERT INTO `quantities` VALUES (1,96),(2,97),(3,98),(4,100),(5,99),(6,98),(7,100),(8,99),(9,100),(10,1000),(19,123);
/*!40000 ALTER TABLE `quantities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `DNI` varchar(9) NOT NULL,
  `firstName` varchar(45) NOT NULL COMMENT '		',
  `lastName` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `password` varchar(200) NOT NULL,
  `active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('11223344U','Editado','Lenin el grande','lenin@comunism.com','1000:5b42403536373838356134:91b93dd8dc339259edb7bd0739e040af1ee4c9f5f9456203c7344deec1b903a9b5963a97d4f596e06037a7200302ac279f245e17e6a000d348355654d4ea7849',1),('12341234J','Juan','Juan','juan@juan.juan','1000:5b42403739623464343531:0bfc6327bf293b34b6579175536136a23914946f1c3849394637387277d0d375d256aa027bd8217b773ebe30acbe0367080862d3ea3191cab51e065ef044f417',1),('12341234M','Armando','Nogueira Rio','armandonogueirar@gmail.com','1000:5b42403433376334333331:652293d4953dfb1c182d2dbdccb2df9325f53762765a9d9f792c4c2e5ea11cab415041610f4a5ccab08172f6751cac89c1b4901059a9258e02da74fc31976da7',1),('12345678S','El fuerete','pass tocha','test@test.com','1000:5b42403535396562336539:77729e268c28bb582d913b48878a1e79084e1b07d486e8c964ff3a342ef2e23bfd9af96db07a55028915992df59832a271cc9df52456a65edb0dba971837fe76',1),('12345678Z','Yui-godess','QWERT','yui@yui.yui','1000:5b42403531643730656336:7375b7ce88a4c8c8d7f9d77d3ac52ec036945bb1d8075af5309d3843cbc16ed4222acb3577ba0edc8460bd5725d0508bc836a0a99bf1f108bab11f709677bc91',0),('14785236S','SSS','ssssss','ssss@sssss.com','1000:5b42403238306562336230:b92bf9d90203f6051f0d3e002648d9c2f5909bc81cf6df754beec7c0a14125fa82c9d89dfb2454152b7084b0063c0a5087450f6fd7ad85e4024fa9cd2d65de5b',1),('53481946T','Diego','Reiriz Cores','diegoreiriz@gmail.com','1000:5b42403136643737333733:f86898e5ff3acb6c5a2928a528fa637ec2eba0f42cbfcd7409a00a66af3b53668c23c5d89a7f72f6fcf5c93e74247b81fc711b8554fef05e2fd8a8154e0b879d',1),('87654321A','ajdasjd','alksdlkas','sklsdjlaks@sdasd.com','1000:5b424034383361393031:f1a7a5bd19753cc80fb4d7861465b9e578086697f47df6b024e618472608c8e71eaf5e58694c6d684f1ee1302ac6ebe6f4a4969ec30f67c01a1055b3ea32253d',1),('98765432A','ANSELMO','asldnasljdn','asdas@asdasd.com','1000:5b42403465363439336434:a1bd9fd2ae5972c31668fad7c9c5ffd11636cdf44bc8fc85c39a6e3d27a26acc38ddb0dec0b76311588d6617a25de8eb7a4d11395dae327fa579f2785a891254',1),('98765432J','porto','porto','porto@porto.com','1000:5b424062343466646639:50233486ba7534bbcd4964a9e08a945c6b103ba7966af5d959b1ab1621dedc9c83ef79b041567801f2a4a4dec05516853df6c440b1d2bc3a15b1dc0d6cde26a2',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vips`
--

DROP TABLE IF EXISTS `vips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vips` (
  `DNI` varchar(9) NOT NULL,
  KEY `DNI` (`DNI`),
  CONSTRAINT `admins_ibfk_2` FOREIGN KEY (`DNI`) REFERENCES `users` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vips`
--

LOCK TABLES `vips` WRITE;
/*!40000 ALTER TABLE `vips` DISABLE KEYS */;
INSERT INTO `vips` VALUES ('11223344U'),('12341234M'),('53481946T');
/*!40000 ALTER TABLE `vips` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-05  1:43:27
