-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: vehiclesharing
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `veicolo`
--

DROP TABLE IF EXISTS `veicolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `veicolo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `alimentazione` varchar(50) NOT NULL,
  `categoria` enum('BICICLETTA','MACCHINA','MOTO') DEFAULT NULL,
  `descrizione` varchar(150) DEFAULT NULL,
  `disponibilita` bit(1) NOT NULL,
  `immagine_veicolo` varchar(50) DEFAULT NULL,
  `indirizzo` varchar(50) NOT NULL,
  `marca` varchar(150) NOT NULL,
  `modello` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veicolo`
--

LOCK TABLES `veicolo` WRITE;
/*!40000 ALTER TABLE `veicolo` DISABLE KEYS */;
INSERT INTO `veicolo` VALUES (1,'Bici elettrica','BICICLETTA','Bici a pedalata assistita, ideale per percorsi urbani',_binary '','commuter7.jpeg','Via Roma 12, Milano','Canyon','Commuter 7.0'),(2,'Benzina','MACCHINA','Auto compatta con ottimi consumi per la città',_binary '','panda.jpeg','Viale Europa 45, Torino','Fiat','Panda 1.2'),(3,'Benzina','MACCHINA','Berline di lusso con motore potente e comodo',_binary '','CLASSEE.jpeg','Corso Italia 78, Roma','Mercedes-Benz','Classe E'),(4,'Elettrico','MACCHINA','Auto completamente elettrica con autonomia di 400 km',_binary '\0','model3.jpeg','Piazza Duomo 10, Milano','Tesla','Model 3'),(5,'Benzina','MOTO','Moto sportiva ad alta prestazione',_binary '','R1.jpeg','Via della Libertà 21, Napoli','Yamaha','R1'),(6,'Diesel','MACCHINA','SUV spazioso con trazione integrale, ideale per viaggi lunghi',_binary '','X5.jpeg','Via Vittorio Veneto 60, Firenze','BMW','X5'),(7,'Elettrico','MOTO','Moto elettrica leggera e veloce per percorsi urbani',_binary '','SRS.jpeg','Piazza Navona 4, Roma','Zero Motorcycles','SRS'),(8,'Bici a pedalata assistita','BICICLETTA','Bici elettrica ideale per lunghe distanze',_binary '','Turbo_Vado.jpeg','Viale dei Colli 23, Bologna','Specialized','Turbo Vado'),(9,'Benzina','MOTO','Motocicletta cruiser per viaggi lunghi e comodi',_binary '','Iron_883.jpeg','Corso Francia 10, Torino','Harley-Davidson','Iron 883'),(10,'Elettrico','MACCHINA','Veicolo compatto elettrico per città con ricarica veloce',_binary '','EQ_ForTwo.jpeg','Via Torino 3, Milano','Smart','EQ ForTwo');
/*!40000 ALTER TABLE `veicolo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-07 10:57:36
