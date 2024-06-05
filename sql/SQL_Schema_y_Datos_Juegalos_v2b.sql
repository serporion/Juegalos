CREATE DATABASE  IF NOT EXISTS `juegalos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `juegalos`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: juegalos
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `alquiler`
--

DROP TABLE IF EXISTS `alquiler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alquiler` (
  `idalquiler` smallint unsigned NOT NULL AUTO_INCREMENT,
  `fechaalquiler` date DEFAULT NULL,
  `fechainicio` date NOT NULL,
  `fechafinal` date NOT NULL,
  `precio` int NOT NULL,
  `usuprestador` smallint unsigned NOT NULL,
  `usuprestatario` smallint unsigned NOT NULL,
  `importetotal` decimal(4,2) unsigned NOT NULL,
  `idpro` smallint unsigned NOT NULL,
  PRIMARY KEY (`idalquiler`),
  KEY `usuprestatario` (`usuprestatario`),
  KEY `usuprestador` (`usuprestador`),
  KEY `idpro` (`idpro`),
  CONSTRAINT `alquiler_ibfk_1` FOREIGN KEY (`usuprestatario`) REFERENCES `usuario` (`idcli`),
  CONSTRAINT `alquiler_ibfk_2` FOREIGN KEY (`usuprestador`) REFERENCES `usuario` (`idcli`),
  CONSTRAINT `alquiler_ibfk_3` FOREIGN KEY (`idpro`) REFERENCES `juego` (`idpro`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquiler`
--

LOCK TABLES `alquiler` WRITE;
/*!40000 ALTER TABLE `alquiler` DISABLE KEYS */;
INSERT INTO `alquiler` VALUES (60,'2023-04-18','2023-04-19','2023-04-21',8,6,4,9.82,40),(61,'2023-04-18','2023-04-19','2023-04-20',9,8,6,10.82,55),(62,'2023-04-18','2023-04-19','2023-04-20',8,9,11,9.82,50),(63,'2023-04-18','2023-04-22','2023-04-23',4,9,11,5.82,48),(64,'2023-04-18','2023-04-20','2023-04-21',5,3,1,6.82,3);
/*!40000 ALTER TABLE `alquiler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `idfact` smallint unsigned NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `cliente` smallint unsigned NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `importealquiler` tinyint NOT NULL,
  `importeservicio` decimal(4,2) NOT NULL,
  `iva` decimal(5,3) NOT NULL,
  `importetotal` decimal(5,3) NOT NULL,
  `idalquiler` smallint unsigned NOT NULL,
  `abono` varchar(10) NOT NULL,
  PRIMARY KEY (`idfact`),
  KEY `cliente` (`cliente`),
  KEY `idalquiler` (`idalquiler`),
  CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`cliente`) REFERENCES `usuario` (`idcli`),
  CONSTRAINT `factura_ibfk_2` FOREIGN KEY (`idalquiler`) REFERENCES `alquiler` (`idalquiler`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (25,'2023-04-18',4,'Alquiler del título :  Runaway',8,1.50,0.315,9.820,60,'NULL'),(26,'2023-04-18',4,'Alquiler del título :  Runaway',-8,-1.50,-0.315,-9.820,60,'AB60'),(27,'2023-04-18',6,'Alquiler del título  :  BattleField',9,1.50,0.315,10.820,61,'NULL');
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juego`
--

DROP TABLE IF EXISTS `juego`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `juego` (
  `idpro` smallint unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `fechaalta` date NOT NULL,
  `categoria` enum('Accion','Aventura Grafica','Roll','Terror') NOT NULL,
  `plataforma` enum('PC','Switch','Wii','Wii U','Play 1','Play 2','Play 3','Play 4','Play 5','Otros') NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `edicion` varchar(4) NOT NULL,
  `precio` int NOT NULL,
  `sesion` int DEFAULT NULL,
  PRIMARY KEY (`idpro`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juego`
--

LOCK TABLES `juego` WRITE;
/*!40000 ALTER TABLE `juego` DISABLE KEYS */;
INSERT INTO `juego` VALUES (1,'Call Of Duty','2023-01-17','Accion','PC','Muy bueno. El mejor Call Of Duty','2000',3,1),(2,'Medal Of Honor','2023-01-17','Accion','PC','Juego increible donde los haya. Fiel a la historia y su desarrollo','2005',5,1),(3,'Gothic','2023-01-11','Roll','PC','Aprendizaje para la lucha. El personaje crece de manera real','2005',5,1),(5,'Harry Potter','2023-03-13','Aventura Grafica','PC','Divertido para los niños. Dificultad media.','2001',5,1),(39,'Runaway 2','2023-03-17','Accion','PC','Muy adictivo. No paras de jugar.','1996',6,1),(40,'Runaway','2023-03-17','Accion','PC','Muy adictivo','1992',4,1),(41,'Kane and Lynch','2023-03-17','Accion','PC','Violento y divertido.','2010',7,1),(42,'Fear','2023-03-17','Terror','PC','Terror ambientado en el espacio','2005',8,1),(46,'Fear II','2023-03-17','Accion','PC','La saga continua.','2006',7,1),(47,'Sims II','2023-03-17','Accion','PC','Hazte una vida','2008',4,1),(48,'Doom III','2023-03-17','Terror','PC','Vida en el infierno','2004',4,1),(50,'FarCry','2023-03-19','Accion','PC','Accion Trepidante','2005',8,1),(51,'Brothers In Arms','2023-03-27','Accion','PC','Otro de la II Guerra Mundial','2008',6,1),(52,'Company Of Heroes','2023-03-27','Roll','PC','Accion estratégica','2006',9,1),(53,'Rainbow Six 3. Raven Shield','2023-03-27','Accion','PC','Estrategia y acción.','2003',8,1),(55,'BattleField','2023-04-02','Accion','PC','Accion trepidante','2013',9,1),(56,'Call of Duty: Ghosts','2023-04-10','Accion','PC','Sigue la opción','2013',5,1),(58,'Death to Spies','2023-04-17','Accion','PC','De espionaje e infiltración','2000',2,1),(59,'Strike Fighters Flight Simulator','2023-04-17','Aventura Grafica','PC','Juego simulación \naérea.','2007',6,1);
/*!40000 ALTER TABLE `juego` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `idusuario` smallint unsigned NOT NULL AUTO_INCREMENT,
  `usuario` varchar(30) NOT NULL,
  `contrasena` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `usuario` (`usuario`),
  CONSTRAINT `login_ibfk_1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idcli`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'59784633F','hola'),(2,'59786546G','hola'),(3,'59482321A','hola'),(4,'60000051S','hola'),(5,'60452135G','hola'),(6,'12345689L','hola'),(7,'78945645Q','hola'),(8,'00000000A','1234'),(9,'14785236D','hola'),(10,'54654646A','hola'),(11,'34524543H','hola'),(12,'32432444G','hola'),(13,'12121212A','hola'),(20,'45612352A','[C@bb34823');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idcli` smallint unsigned NOT NULL AUTO_INCREMENT,
  `fechaalta` date DEFAULT NULL,
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `cp` varchar(5) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `poblacion` varchar(50) NOT NULL,
  `provincia` varchar(50) NOT NULL,
  `formapago` enum('efectivo','tarjeta','bizum','transferencia') NOT NULL,
  `tarjeta` varchar(16) NOT NULL,
  PRIMARY KEY (`idcli`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'2020-04-04','59784633F','Miguel','De Cervantes Saavedra','Calle Bar vente ya','56321','45678952','Beertenfor','Madrid','efectivo','2222222222222222'),(2,'2020-05-03','59786546G','Rafael','Lento y Golpeando','Calle Siniestro Total','53221','23165485','Rescateme','Madrid','bizum','3333333333333333'),(3,'2020-06-08','59482321A','San Jacobo','Frito con Lechuga','Calle Hambre que da Calambre','99999','45686232','Bollullos','Sevilla','bizum','1111111111111111'),(4,'2020-09-10','60000051S','Elena','El de los pelos largos','Calle Peluquería Cerrada','45643','456689633','Tijeretas','Madrid','bizum','4444444444444444'),(5,'2021-05-07','60452135G','Juan Ramón','Jiménez Mantecon','Platería','12354','963852741','Leganes','Madrid','efectivo','5555555555555555'),(6,'2021-10-20','12345689K','Sor','Citroen Blanco','Calle Esperanza de los Inmortales','12345','666666666','Móstoles','Toledo','transferencia','1111111111111111'),(7,'2021-11-30','78945645Q','Ramon','María del Valle Inclán','Calle Lavapies sin brazos','12345','91456123','Borrachos','Granada','efectivo','1111111111111111'),(8,'2022-01-05','00000000A','admin','','','00000','000000000','AAAAAAA','BBBBBBB','efectivo','1111111111111111'),(9,'2022-03-20','14785236D','María Teresa','Borragan Rojas','Calle Pastoreo','11112','635247821','Felicidad','Toledo','efectivo','1111111111111111'),(10,'2022-06-22','54654646A','María','Zambrano Alarcón','Calle Ultima de la Fila','21321','654654365','Fuenlabrada','Madrid','efectivo','1111111111111111'),(11,'2022-06-10','34524543H','María Juana','Moliner','Ruiz','12386','65498731','Zaragoza','Zaragoza','efectivo','1111111111111111'),(12,'2022-10-13','32432444G','María de la Concepci','Albornoz Salas','Calle Limpieza Total','32432','343243129','Cangas de Onís','Asturías','efectivo','2222222222222222'),(13,'2023-04-05','12121212A','Pedro','Medario Camello','Calle Pasa algo','18193','666645658','Monachil','Granada','tarjeta','2222222222222222'),(20,'2023-04-12','45612352A','Elena','Nito del Bosque','Calle Amazonas Quemado','62301','741852369','Segovia','Segovia','tarjeta','8956234512785236');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_juego`
--

DROP TABLE IF EXISTS `usuario_juego`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_juego` (
  `idcli` smallint unsigned NOT NULL,
  `idpro` smallint unsigned NOT NULL,
  KEY `idcli` (`idcli`),
  KEY `idpro` (`idpro`),
  CONSTRAINT `usuario_juego_ibfk_1` FOREIGN KEY (`idcli`) REFERENCES `usuario` (`idcli`),
  CONSTRAINT `usuario_juego_ibfk_2` FOREIGN KEY (`idpro`) REFERENCES `juego` (`idpro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_juego`
--

LOCK TABLES `usuario_juego` WRITE;
/*!40000 ALTER TABLE `usuario_juego` DISABLE KEYS */;
INSERT INTO `usuario_juego` VALUES (9,42),(9,46),(9,47),(9,48),(9,50),(2,2),(3,51),(8,52),(8,53),(8,55),(10,1),(3,3),(3,5),(3,39),(6,40),(8,41),(5,56),(8,58),(5,59);
/*!40000 ALTER TABLE `usuario_juego` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-18 21:04:12
