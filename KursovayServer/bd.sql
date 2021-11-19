drop database kurswork;
create database kurswork;
use kurswork;

create table if not exists `company`(
	`idcompany` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(45) NOT NULL,
	`numberEmpl` INT NOT NULL DEFAULT '0',
	PRIMARY KEY (`idcompany`)
);

create table if not exists `users`(
	`iduser` INT NOT NULL AUTO_INCREMENT,
	`login` varchar(45) NOT NULL,
	`password` varchar(45) NOT NULL,
	`status` INT NOT NULL DEFAULT '0',
	PRIMARY KEY (`iduser`)
);

CREATE TABLE IF NOT EXISTS `employes` (
	`idempl` INT NOT NULL AUTO_INCREMENT,
    `companyid` INT NOT NULL,
	`name` varchar(45) NOT NULL,
    `lastname` varchar(45) NOT NULL,
    `patronymic` varchar(45) NOT NULL,
	PRIMARY KEY (`idempl`)
);

CREATE TABLE IF NOT EXISTS `description`(
	`iddesc` INT NOT NULL auto_increment,
    `employeeid` INT NOT NULL,
	`hours` INT NOT NULL DEFAULT '0',
    `days` INT NOT NULL DEFAULT '0',
    `numbOfProd` INT NOT NULL DEFAULT '0',
PRIMARY KEY (`iddesc`)
);

CREATE TABLE IF NOT EXISTS `salaries`(
`idsal` INT NOT NULL AUTO_INCREMENT,
`employeeid` INT NOT NULL,
	`december` DECIMAL(5, 2) UNSIGNED NOT NULL DEFAULT '0',
    `january` DECIMAL(5, 2) UNSIGNED NOT NULL DEFAULT '0',
    `february` DECIMAL(5, 2) UNSIGNED NOT NULL DEFAULT '0',
	`march` DECIMAL(5, 2) UNSIGNED NOT NULL DEFAULT '0',
    `april` DECIMAL(5, 2) UNSIGNED NOT NULL DEFAULT '0',
    `may` DECIMAL(5, 2) UNSIGNED NOT NULL DEFAULT '0',
    `june` DECIMAL(5, 2) UNSIGNED NOT NULL DEFAULT '0',
    `july` DECIMAL(5, 2) UNSIGNED NOT NULL DEFAULT '0',
    `august` DECIMAL(5, 2) UNSIGNED NOT NULL DEFAULT '0',
    `september` DECIMAL(5, 2) UNSIGNED NOT NULL DEFAULT '0',
    `october` DECIMAL(5, 2) UNSIGNED NOT NULL DEFAULT '0',
    `november` DECIMAL(5, 2) UNSIGNED NOT NULL DEFAULT '0',
    PRIMARY KEY (`idsal`)
);

ALTER TABLE `salaries` ADD CONSTRAINT `employes_fk0` FOREIGN KEY (`employeeid`) REFERENCES `employes`(`idempl`) ON DELETE CASCADE;

ALTER TABLE `description` ADD CONSTRAINT `employes_fk1` FOREIGN KEY (`employeeid`) REFERENCES `employes`(`idempl`) ON DELETE CASCADE;

