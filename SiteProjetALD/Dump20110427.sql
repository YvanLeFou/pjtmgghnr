-- MySQL dump 10.13  Distrib 5.1.34, for apple-darwin9.5.0 (i386)
--
-- Host: localhost    Database: projetaldtest
-- ------------------------------------------------------
-- Server version	5.5.11

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
-- Current Database: `projetaldtest`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `projetaldtest` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `projetaldtest`;

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorie` (
  `idCategorie` int(11) NOT NULL AUTO_INCREMENT,
  `libelleCategorie` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idCategorie`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
INSERT INTO `categorie` VALUES (1,'Vacances'),(3,'Vaisselle'),(4,'Exterieur'),(5,'Vacances'),(6,'Loisirs'),(7,'Vaisselle'),(8,'Exterieur'),(9,'Vacances'),(10,'Loisirs'),(11,'Vaisselle'),(12,'Exterieur'),(13,'Vacances'),(14,'Loisirs'),(15,'Vaisselle'),(16,'Exterieur'),(17,'Vacances'),(18,'Loisirs'),(19,'Vaisselle'),(20,'Exterieur'),(21,'Vacances'),(22,'Loisirs'),(23,'Vaisselle'),(24,'Exterieur'),(25,'Vacances'),(26,'Loisirs'),(27,'Vaisselle'),(28,'Exterieur'),(29,'Vacances'),(30,'Loisirs'),(31,'Vaisselle'),(32,'Exterieur'),(33,'Vacances'),(34,'Loisirs'),(35,'Vaisselle'),(36,'Exterieur'),(37,'Vacances'),(38,'Loisirs'),(39,'Vaisselle'),(40,'Exterieur'),(41,'Vacances'),(42,'Loisirs'),(43,'Vaisselle'),(44,'Exterieur'),(45,'Vacances'),(46,'Loisirs'),(47,'Vaisselle'),(48,'Exterieur'),(49,'Vacances'),(50,'Loisirs'),(51,'Vaisselle'),(52,'Exterieur'),(53,'Vacances'),(54,'Loisirs'),(55,'Vaisselle'),(56,'Exterieur'),(57,'Vacances'),(58,'Loisirs'),(59,'Vaisselle'),(60,'Exterieur'),(61,'Vacances'),(62,'Loisirs'),(63,'Vaisselle'),(64,'Exterieur'),(65,'Vacances'),(66,'Loisirs'),(67,'Vaisselle'),(68,'Exterieur'),(69,'Vacances'),(70,'Loisirs'),(71,'Vaisselle'),(72,'Exterieur'),(73,'Vacances'),(74,'Loisirs'),(75,'Vaisselle'),(76,'Exterieur'),(77,'Vacances'),(78,'Loisirs'),(79,'Vaisselle'),(80,'Exterieur'),(81,'Vacances'),(82,'Loisirs'),(83,'Vaisselle'),(84,'Exterieur'),(85,'Vacances'),(86,'Loisirs'),(87,'Vaisselle'),(88,'Exterieur'),(89,'Vacances'),(90,'Loisirs'),(91,'Vaisselle'),(92,'Exterieur'),(93,'Vacances'),(94,'Loisirs'),(95,'Vaisselle'),(96,'Exterieur'),(97,'Vacances'),(98,'Loisirs'),(99,'Vaisselle'),(100,'Exterieur'),(101,'Vacances'),(102,'Loisirs'),(103,'Vaisselle'),(104,'Exterieur'),(105,'Vacances'),(106,'Loisirs'),(107,'Vaisselle'),(108,'Exterieur'),(109,'Vacances'),(110,'Loisirs'),(111,'Vaisselle'),(112,'Exterieur');
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departement`
--

DROP TABLE IF EXISTS `departement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departement` (
  `idDepartement` int(11) NOT NULL AUTO_INCREMENT,
  `libelleDepartement` varchar(30) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `idRegion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDepartement`),
  KEY `FK_Departement_idRegion` (`idRegion`),
  CONSTRAINT `FK_Departement_idRegion` FOREIGN KEY (`idRegion`) REFERENCES `region` (`idRegion`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departement`
--

LOCK TABLES `departement` WRITE;
/*!40000 ALTER TABLE `departement` DISABLE KEYS */;
INSERT INTO `departement` VALUES (1,'Ain','01',22),(2,'Aisne','02',19),(3,'Allier','03',2),(4,'Alpes de Haute Provence','04',21),(5,'Alpes (Hautes)','05',21),(6,'Alpes Maritimes','06',21),(7,'Ardéche','07',22),(8,'Ardennes','08',6),(9,' Ariége','09',14),(10,'Aube','10',6),(11,'Aude','11',11),(12,'Aveyron','12',14),(13,'Bouches du Rhône','13',21),(14,'Calvados','14',24),(15,'Cantal','15',2),(16,'Charente','16',20),(17,'Charente Maritime','17',20),(18,'Cher','18',5),(19,'Corréze','19',12),(21,'Creuse ','23',12),(22,'Dordogne','24',1),(23,'Doubs','25',9),(24,'Drôme','26',22),(25,'Eure','27',17),(26,'Eure et Loir','28',5),(27,'Finistére','29',4),(28,'Gard','30',11),(29,'Garonne (Haute)','31',14),(30,'Gers','32',14),(31,'Gironde','33',1),(32,'Hérault','34',11),(33,'Ile et Vilaine','35',4),(34,'Indre','36',5),(35,'Indre et Loire','37',5),(36,'Isére','38',22),(37,'Jura','39',9),(38,'Landes','40',1),(39,'Loir et Cher','41',5),(40,'Loire','42',22),(41,'Loire (Haute)','43',2),(42,'Loire Atlantique','44',18),(43,'Loiret','45',5),(44,'Lot','46',14),(45,'Lot et Garonne','47',1),(46,'Lozére','48',11),(47,'Maine et Loire','49',18),(48,'Manche','50',24),(49,'Marne','51',6),(50,'Marne (Haute)','52',6),(51,'Mayenne','53',18),(52,'Meurthe et Moselle','54',13),(53,'Meuse','55',13),(54,'Morbihan','56',4),(55,'Moselle','57',13),(56,'Niévre','58',3),(57,'Nord','59',15),(58,'Oise','60',19),(59,'Orne','61',24),(60,'Pas de Calais','62',15),(61,'Puy de Dôme','63',2),(62,'Pyrénées Atlantiques','64',1),(63,'Pyrénées (Hautes)','65',14),(64,'Pyrénées Orientales','66',11),(65,'Rhin (Bas)','67',23),(66,'Rhin (Haut)','68',23),(67,'Rhône','69',22),(68,'Saône (Haute)','70',9),(69,'Saône et Loire','71',3),(70,'Sarthe','72',18),(71,'Savoie','73',22),(72,'Savoie (Haute)','74',22),(73,'Paris','75',10),(74,'Seine Maritime','76',17),(75,'Seine et Marne','77',10),(76,'Yvelines','78',10),(77,'Sèvres (Deux)','79',20),(78,'Somme','80',19),(79,'Tarn','81',14),(80,'Tarn et Garonne','82',14),(81,'Var','83',21),(82,'Vaucluse','84',21),(83,'Vendée','85',18),(84,'Vienne','86',20),(85,'Vienne (Haute)','87',12),(86,'Vosges','88',13),(87,'Yonne','89',3),(88,'Belfort (Territoire de)','90',9),(89,'Essonne','91',10),(90,'Hauts de Seine','92',10),(91,'Seine Saint Denis','93',10),(92,'Val de Marne','94',10),(93,'Mayotte','976',8),(94,'Guadeloupe','971',8),(95,'Guyane','973',8),(96,'Martinique','972',8),(97,'Réunion','974',8),(98,'Côte d\'or','21',4),(100,'Côtes d\'armor','22',4),(102,'Corse du sud','2A',7),(103,'Haute corse','2B',7),(104,'Val d\'oise','95',10);
/*!40000 ALTER TABLE `departement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `droit`
--

DROP TABLE IF EXISTS `droit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `droit` (
  `idDroit` int(11) NOT NULL AUTO_INCREMENT,
  `libelleDroit` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idDroit`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `droit`
--

LOCK TABLES `droit` WRITE;
/*!40000 ALTER TABLE `droit` DISABLE KEYS */;
INSERT INTO `droit` VALUES (1,'Administrateur'),(3,'Enfant'),(4,'Administrateur'),(5,'Personne majeure'),(6,'Enfant'),(7,'Administrateur'),(8,'Personne majeure'),(9,'Enfant'),(10,'Administrateur'),(11,'Personne majeure'),(12,'Enfant'),(13,'Administrateur'),(14,'Personne majeure'),(15,'Enfant'),(16,'Administrateur'),(17,'Personne majeure'),(18,'Enfant'),(19,'Administrateur'),(20,'Personne majeure'),(21,'Enfant'),(22,'Administrateur'),(23,'Personne majeure'),(24,'Enfant'),(25,'Administrateur'),(26,'Personne majeure'),(27,'Enfant'),(28,'Administrateur'),(29,'Personne majeure'),(30,'Enfant'),(31,'Administrateur'),(32,'Personne majeure'),(33,'Enfant'),(34,'Administrateur'),(35,'Personne majeure'),(36,'Enfant'),(37,'Administrateur'),(38,'Personne majeure'),(39,'Enfant'),(40,'Administrateur'),(41,'Personne majeure'),(42,'Enfant'),(43,'Administrateur'),(44,'Personne majeure'),(45,'Enfant'),(46,'Administrateur'),(47,'Personne majeure'),(48,'Enfant'),(49,'Administrateur'),(50,'Personne majeure'),(51,'Enfant'),(52,'Administrateur'),(53,'Personne majeure'),(54,'Enfant'),(55,'Administrateur'),(56,'Personne majeure'),(57,'Enfant'),(58,'Administrateur'),(59,'Personne majeure'),(60,'Enfant'),(61,'Administrateur'),(62,'Personne majeure'),(63,'Enfant'),(64,'Administrateur'),(65,'Personne majeure'),(66,'Enfant'),(67,'Administrateur'),(68,'Personne majeure'),(69,'Enfant'),(70,'Administrateur'),(71,'Personne majeure'),(72,'Enfant'),(73,'Administrateur'),(74,'Personne majeure'),(75,'Enfant'),(76,'Administrateur'),(77,'Personne majeure'),(78,'Enfant');
/*!40000 ALTER TABLE `droit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encherit`
--

DROP TABLE IF EXISTS `encherit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `encherit` (
  `pseudo` varchar(30) NOT NULL,
  `idOffre` int(11) NOT NULL,
  `prix` double DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`pseudo`,`idOffre`),
  KEY `FK_Encherit_idOffre` (`idOffre`),
  CONSTRAINT `FK_Encherit_idOffre` FOREIGN KEY (`idOffre`) REFERENCES `offre` (`idOffre`),
  CONSTRAINT `FK_Encherit_pseudo` FOREIGN KEY (`pseudo`) REFERENCES `internaute` (`pseudo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encherit`
--

LOCK TABLES `encherit` WRITE;
/*!40000 ALTER TABLE `encherit` DISABLE KEYS */;
INSERT INTO `encherit` VALUES ('toto',15,1,'2011-04-27 09:08:09');
/*!40000 ALTER TABLE `encherit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
  `idImage` int(11) NOT NULL AUTO_INCREMENT,
  `libelleImage` varchar(50) DEFAULT NULL,
  `idOffre` int(11) NOT NULL,
  PRIMARY KEY (`idImage`),
  KEY `FK_Image_idOffre` (`idOffre`),
  CONSTRAINT `FK_Image_idOffre` FOREIGN KEY (`idOffre`) REFERENCES `offre` (`idOffre`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,'ImageUpload/mcd.png',1),(4,'ImageUpload/mcd.png',2),(5,'ImageUpload/mcd.png',3),(9,'ImageUpload/mpd.png',5),(12,'ImageUpload/mpd.png',7),(16,'ImageUpload/24-04-11 00:47',13),(17,'ImageUpload/26-04-11 22:16',14),(18,'ImageUpload/26-04-11 22:27',15);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `internaute`
--

DROP TABLE IF EXISTS `internaute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `internaute` (
  `pseudo` varchar(30) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `noRue` int(11) DEFAULT NULL,
  `nomRue` varchar(50) DEFAULT NULL,
  `ville` varchar(50) DEFAULT NULL,
  `cp` varchar(5) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `telephone` varchar(10) DEFAULT NULL,
  `mdp` varchar(30) DEFAULT NULL,
  `idDepartement` int(11) DEFAULT NULL,
  `idDroit` int(11) DEFAULT NULL,
  PRIMARY KEY (`pseudo`),
  KEY `FK_Internaute_idDepartement` (`idDepartement`),
  KEY `FK_Internaute_idDroit` (`idDroit`),
  CONSTRAINT `FK_Internaute_idDepartement` FOREIGN KEY (`idDepartement`) REFERENCES `departement` (`idDepartement`),
  CONSTRAINT `FK_Internaute_idDroit` FOREIGN KEY (`idDroit`) REFERENCES `droit` (`idDroit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `internaute`
--

LOCK TABLES `internaute` WRITE;
/*!40000 ALTER TABLE `internaute` DISABLE KEYS */;
INSERT INTO `internaute` VALUES ('aoto','a','a',2,'a','a','65453','a','0909090909','a',56,1),('Banbi','Reitz','Nicolas',28,'rue des pommiers','hayange','57700','nicolas.reitz@gmx.fr','0382859251','truc',1,1),('Bobby','Reitz','Nicolas',28,'rue des pommiers','hayange','57700','nicolas.reitz@gmx.fr','0382859251','truc',2,1),('Bobo','Reitz','Nicolas',28,'rue des pommiers','hayange','57700','nicolas.reitz@gmx.fr','0382859251','truc',1,1),('coco','CocoLolo','Lolo',2,'rue lol','MDR','12345','lol@mdr.fr','0909090909','coco',3,1),('Titi','a','a',26,'a','jkh','57700','a','0382859251','a',22,1),('toto','Nicolas','Sophie',10,'rue du poirier','Hayange','57700','nicolas.sophie@jtenmerde.fr','0303030334','a',55,1),('yoyo','tata','yoyo',10,'rue du schmok','montagne','56600','lala@hot.fr','0382842838','a',55,1);
/*!40000 ALTER TABLE `internaute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motclef`
--

DROP TABLE IF EXISTS `motclef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motclef` (
  `idMotClef` int(11) NOT NULL AUTO_INCREMENT,
  `libelleMotClef` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idMotClef`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motclef`
--

LOCK TABLES `motclef` WRITE;
/*!40000 ALTER TABLE `motclef` DISABLE KEYS */;
INSERT INTO `motclef` VALUES (1,'Administrateur'),(3,'Enfant'),(4,'Administrateur'),(5,'Personne majeure'),(6,'Enfant'),(7,'Administrateur'),(8,'Personne majeure'),(9,'Enfant'),(10,'Administrateur'),(11,'Personne majeure'),(12,'Enfant'),(13,'Administrateur'),(14,'Personne majeure'),(15,'Enfant'),(16,'Administrateur'),(17,'Personne majeure'),(18,'Enfant'),(19,'Administrateur'),(20,'Personne majeure'),(21,'Enfant'),(22,'Administrateur'),(23,'Personne majeure'),(24,'Enfant'),(25,'Administrateur'),(26,'Personne majeure'),(27,'Enfant'),(28,'Administrateur'),(29,'Personne majeure'),(30,'Enfant'),(31,'Administrateur'),(32,'Personne majeure'),(33,'Enfant'),(34,'Administrateur'),(35,'Personne majeure'),(36,'Enfant'),(37,'Administrateur'),(38,'Personne majeure'),(39,'Enfant'),(40,'Administrateur'),(41,'Personne majeure'),(42,'Enfant'),(43,'Administrateur'),(44,'Personne majeure'),(45,'Enfant'),(46,'Administrateur'),(47,'Personne majeure'),(48,'Enfant'),(49,'Administrateur'),(50,'Personne majeure'),(51,'Enfant'),(52,'Administrateur'),(53,'Personne majeure'),(54,'Enfant'),(55,'Administrateur'),(56,'Personne majeure'),(57,'Enfant'),(58,'Administrateur'),(59,'Personne majeure'),(60,'Enfant'),(61,'Administrateur'),(62,'Personne majeure'),(63,'Enfant'),(64,'Administrateur'),(65,'Personne majeure'),(66,'Enfant'),(67,'Administrateur'),(68,'Personne majeure'),(69,'Enfant'),(70,'Administrateur'),(71,'Personne majeure'),(72,'Enfant');
/*!40000 ALTER TABLE `motclef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offre`
--

DROP TABLE IF EXISTS `offre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offre` (
  `idOffre` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(70) DEFAULT NULL,
  `descriptif` text,
  `miseAPrix` double DEFAULT NULL,
  `joignable` tinyint(1) DEFAULT NULL,
  `dateDepot` datetime DEFAULT NULL,
  `dateDebut` datetime DEFAULT NULL,
  `dateFin` datetime DEFAULT NULL,
  `suspecte` tinyint(1) DEFAULT NULL,
  `pseudo` varchar(30) DEFAULT NULL,
  `idDepartement` int(11) DEFAULT NULL,
  `idCategorie` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOffre`),
  KEY `FK_Offre_pseudo` (`pseudo`),
  KEY `FK_Offre_idDepartement` (`idDepartement`),
  KEY `FK_Offre_idCategorie` (`idCategorie`),
  CONSTRAINT `FK_Offre_idCategorie` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`idCategorie`),
  CONSTRAINT `FK_Offre_idDepartement` FOREIGN KEY (`idDepartement`) REFERENCES `departement` (`idDepartement`),
  CONSTRAINT `FK_Offre_pseudo` FOREIGN KEY (`pseudo`) REFERENCES `internaute` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offre`
--

LOCK TABLES `offre` WRITE;
/*!40000 ALTER TABLE `offre` DISABLE KEYS */;
INSERT INTO `offre` VALUES (1,'bouillote','neuve',5,0,'2011-03-20 00:00:00','2011-03-20 00:00:00','2011-04-20 00:00:00',1,'Bobo',1,3),(2,'chambre','old age',12,0,'2011-03-20 00:00:00','2011-03-20 00:00:00','2011-04-20 00:00:00',0,'Bobby',2,4),(3,'voiture','nouvelle',5,0,'2011-03-20 00:00:00','2011-03-20 00:00:00','2011-04-20 00:00:00',0,'Bobby',3,5),(5,'train','sans loco',12,0,'2011-04-20 00:00:00','2011-04-20 00:00:00','2011-04-24 00:00:00',0,'Banbi',4,6),(6,'loco','sans wagon',5,0,'2011-04-21 00:00:00','2011-04-21 00:00:00','2011-04-21 00:00:00',0,'Bobo',5,7),(7,'nain','blanche neige',12,0,'2011-04-21 00:00:00','2011-04-21 00:00:00','2011-04-21 00:00:00',0,'Bobo',6,8),(13,'Assassin','Tueur d\'élite',10,0,'2011-04-24 00:47:24','2011-04-24 00:47:24','2011-04-26 00:00:00',0,'Bobo',1,1),(14,'Tititata','test',2,1,'2011-04-26 22:16:27','2011-04-26 22:16:27','2011-12-12 00:00:00',0,'Bobo',55,4),(15,'Lolo','Test',2,1,'2011-04-26 22:27:34','2011-04-26 22:27:34','2011-12-12 00:00:00',1,'Bobo',38,1);
/*!40000 ALTER TABLE `offre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region` (
  `idRegion` int(11) NOT NULL AUTO_INCREMENT,
  `libelleRegion` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idRegion`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (1,'Aquitaine'),(2,'Auvergne'),(3,'Bourgogne'),(4,'Bretagne'),(5,'Centre'),(6,'Champagne Ardenne'),(7,'Corse'),(8,'DOM/TOM'),(9,'Franche Comté'),(10,'Ile de France'),(11,'Languedoc Roussillon'),(12,'Limousin'),(13,'Lorraine'),(14,'Midi Pyrénées'),(15,'Nord Pas de Calais'),(17,'Haute Normandie '),(18,'Pays de la Loire'),(19,'Picardie'),(20,'Poitou Charentes'),(21,'Provence Alpes Côte d\'azur'),(22,'Rhône Alpes'),(23,'Alsace'),(24,'Basse-Normandie');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-04-27  7:09:40
