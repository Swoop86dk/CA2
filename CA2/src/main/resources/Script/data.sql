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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `person` VALUES (1,'Simon','SuperSoldier','fb05@gmail.com'),(2,'Stefan','DerFührer','Bunker69@nationen.dk'),(3,'Martin','UniBomber','BoomBoom@kaboom.dk');

CREATE TABLE `hobby` (
  `name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL);
INSERT INTO `hobby` VALUES ('Boksemester','slår på folk'),('Bademester','Bader meget'),('Madmester','Æder meget');



CREATE TABLE `address` (
  `street` varchar(45) NOT NULL,
  `additional_info` varchar(45) NOT NULL);
INSERT INTO `address` VALUES ('Højhat 23','Dejlig gade'),('BrokenBone 34','Super gade'),('Medicine Street 65','drugs are free here');

CREATE TABLE `cityinfo` (
  `zipcode` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL);
INSERT INTO `cityinfo` VALUES ('2605','Brøndby'),('2760','Måløv'),('2750','Ballerup');

CREATE TABLE `phone` (
  `number` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL);
INSERT INTO `phone` VALUES ('44769212','fedt nummber'),('87654321','Super nummer'),('65656565','skide godt nummer terkel');
