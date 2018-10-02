CREATE DATABASE  IF NOT EXISTS `CA2DATABASE`;
USE `CA2DATABASE`;
DROP TABLE IF EXISTS `hobby`;
DROP TABLE IF EXISTS `person`;
DROP TABLE IF EXISTS `address`;
DROP TABLE IF EXISTS `cityinfo`;
DROP TABLE IF EXISTS `phone`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `firstName` varchar(45) NOT NULL COMMENT '	',
  `lastName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)) 
  ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `person` VALUES (1,'Simon','SuperSoldier','fb05@gmail.com'),(2,'Stefan','DerFührer','Bunker69@nationen.dk'),(3,'Martin','UniBomber','BoomBoom@kaboom.dk');

CREATE TABLE `hobby` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL);
INSERT INTO `hobby` VALUES (1, 'Boksemester','slår på folk'),(2, 'Bademester','Bader meget'),(3, 'Madmester','Æder meget');



CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `street` varchar(45) NOT NULL,
  `additional_info` varchar(45) NOT NULL);
INSERT INTO `address` VALUES (1, 'Højhat 23','Dejlig gade'),(2, 'BrokenBone 34','Super gade'),(3, 'Medicine Street 65','drugs are free here');

CREATE TABLE `cityinfo` (
  `id` int(11) NOT NULL,
  `zipcode` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL);
INSERT INTO `cityinfo` VALUES (1, '2605','Brøndby'),(2, '2760','Måløv'),(3, '2750','Ballerup');

CREATE TABLE `phone` (
  `id` int(11) NOT NULL,
  `number` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL);
INSERT INTO `phone` VALUES (1, '44769212','fedt nummber'),(2, '87654321','Super nummer'),(3, '65656565','skide godt nummer terkel');
