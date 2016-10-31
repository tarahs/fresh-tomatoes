CREATE DATABASE  IF NOT EXISTS `freshtomatoes` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `freshtomatoes`;
-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: freshtomatoes
-- ------------------------------------------------------
-- Server version	5.7.11

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
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `description` text,
  `name` varchar(255) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'2016-10-31 00:00:00','When Tony Stark jumpstarts a dormant peacekeeping program, things go awry and Earth\'s Mightiest Heroes, including Iron Man, Captain America, Thor, The Incredible Hulk, Black Widow and Hawkeye, are put to the ultimate test as they battle to save the planet from destruction at the hands of the villainous Ultron.','Avengers - Age of Ultron',4.5,'http://resizing.flixster.com/s8kIQtOhr36lGPkcUGCVeqVWw9Y=/180x270/dkpu1ddg7pbsk.cloudfront.net/movie/11/19/01/11190143_ori.jpg'),(2,'2016-10-31 00:00:00','Continuing the global exploits in the unstoppable franchise built on speed, Vin Diesel, Paul Walker and Dwayne Johnson lead the returning cast of Fast & Furious 7. James Wan directs this chapter of the hugely successful series that also welcomes back favorites Michelle Rodriguez, Jordana Brewster, Tyrese Gibson, Chris Ludacris Bridges, Elsa Pataky and Lucas Black. They are joined by international action stars new to the franchise including Jason Statham, Djimon Hounsou, Tony Jaa, Ronda Rousey and Kurt Russell.','Furious 7',4,'http://resizing.flixster.com/tBSZ6CjTf-YkvC4o-VC0JFIY-vk=/170x270/dkpu1ddg7pbsk.cloudfront.net/movie/11/18/14/11181482_ori.jpg'),(3,'2016-10-31 00:00:00','From Disney comes two-time Oscar (R) winner Brad Bird\'s riveting, mystery adventure Tomorrowland, starring Academy Award (R) winner George Clooney. Bound by a shared destiny, former boy-genius Frank (Clooney), jaded by disillusionment, and Casey (Britt Robertson), a bright, optimistic teen bursting with scientific curiosity, embark on a danger-filled mission to unearth the secrets of an enigmatic place somewhere in time and space known only as Tomorrowland. What they must do there changes the world-and them-forever. Featuring a screenplay by Lost writer and co-creator Damon Lindelof and Brad Bird, from a story by Lindelof & Bird & Jeff Jensen, Tomorrowland promises to take audiences on a thrill ride of nonstop adventures through new dimensions that have only been dreamed of.(C) Walt Disney','Tomorrowland',3.5,'http://resizing.flixster.com/dH2TEhqdJ5A6xxV3mQBPZ_1yEac=/180x267/dkpu1ddg7pbsk.cloudfront.net/movie/11/19/06/11190666_ori.jpg'),(4,'2016-10-31 00:00:00','Filmmaker George Miller gears up for another post-apocalyptic action adventure with Fury Road, the fourth outing in the Mad Max film series. Charlize Theron stars alongside Tom Hardy (Bronson), with Zoe Kravitz, Adelaide Clemens, and Rosie Huntington Whiteley heading up the supporting cast. ~ Jeremy Wheeler, Rovi','Pitch Perfect 2',3,'http://resizing.flixster.com/GbDqFVUc_9VBNAnanZVQxlYD0ZM=/180x267/dkpu1ddg7pbsk.cloudfront.net/movie/11/19/12/11191276_ori.jpg'),(5,'2016-10-31 00:00:00','Based on the literary classic by Thomas Hardy, FAR FROM THE MADDING CROWD is the story of independent, beautiful and headstrong Bathsheba Everdene (Carey Mulligan), who attracts three very different suitors: Gabriel Oak (Matthias Schoenaerts), a sheep farmer, captivated by her fetching willfulness; Frank Troy (Tom Sturridge), a handsome and reckless Sergeant; and William Boldwood (Michael Sheen), a prosperous and mature bachelor. This timeless story of Bathshebas choices and passions explores the nature of relationships and love - as well as the human ability to overcome hardships through resilience and perseverance. (C) Fox Searchlight','Far From The Madding Crowd',4.5,'http://resizing.flixster.com/c8g2_ZQY4dBR7lxc9zWgzQnA01U=/180x267/dkpu1ddg7pbsk.cloudfront.net/movie/11/19/09/11190928_ori.jpg'),(6,'2016-10-31 00:00:00','A disgraced former surgeon named Stephen Strange (Benedict Cumberbatch) becomes a powerful sorcerer under the tutelage of a mystic known as the Ancient One (Tilda Swinton). Rachel McAdams, Mads Mikkelsen, and Chiwetel Ejiofor co-star in this entry in the Marvel Cinematic Universe. Directed by Scott Derrickson (Sinister).','Doctor Strange',4.5,'http://resizing.flixster.com/Sjs3ZF2OaserUWq9-b-N2zgI1d4=/320x476/v1.bTsxMjE3OTkzMTtqOzE3MTU2OzIwNDg7Mzg3OzU3Ng'),(7,'2016-10-31 00:00:00','DreamWorks Animation\'s TROLLS is an irreverent comedy extravaganza with incredible music! From the genius creators of SHREK, TROLLS stars Anna Kendrick as Poppy, the optimistic leader of the Trolls, and her polar opposite, Branch, played by Justin Timberlake. Together, this unlikely pair of Trolls must embark on an adventure that takes them far beyond the only world they\'ve ever known.','Trolls',4,'http://resizing.flixster.com/hOak3e2UF26HqE0X-b3mu9EsXHA=/320x474/v1.bTsxMjA5MzQ4NjtqOzE3MTU1OzIwNDg7Mjc2NDs0MDk2'),(8,'2016-10-31 00:00:00','HACKSAW RIDGE is the extraordinary true story of Desmond Doss [Andrew Garfield] who, in Okinawa during the bloodiest battle of WWII, saved 75 men without firing or carrying a gun. He was the only American soldier in WWII to fight on the front lines without a weapon, as he believed that while the war was justified, killing was nevertheless wrong. As an army medic, he single-handedly evacuated the wounded from behind enemy lines, braved fire while tending to soldiers and was wounded by a grenade and hit by snipers. Doss was the first conscientious objector to ever earn the Congressional Medal of Honor.','Hacksaw Ridge',5,'http://resizing.flixster.com/02T6g5TyLiKDDMrhrYwLwQXYxGU=/311x480/v1.bTsxMjI0MjE5NTtqOzE3MTg2OzIwNDg7MzYwMDs1NTUw');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-31 15:54:49
