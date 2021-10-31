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
	`ideml` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(45) NOT NULL,
    `lastname` varchar(45) NOT NULL,
    `patronymic` varchar(45) NOT NULL,
	PRIMARY KEY (`ideml`)
);

CREATE TABLE IF NOT EXISTS `description`(
	`iddesc` INT NOT NULL auto_increment,
	`hours` INT NOT NULL DEFAULT '0',
    `days` INT NOT NULL DEFAULT '0',
    `numbOfProd` INT NOT NULL DEFAULT '0',
PRIMARY KEY (`iddesc`)
);

CREATE TABLE IF NOT EXISTS `salaries`(
`idsal` INT NOT NULL AUTO_INCREMENT,
	`december` INT NOT NULL DEFAULT '0',
    `january` INT NOT NULL DEFAULT '0',
    `february` INT NOT NULL DEFAULT '0',
	`march` INT NOT NULL DEFAULT '0',
    `april` INT NOT NULL DEFAULT '0',
    `may` INT NOT NULL DEFAULT '0',
    `june` INT NOT NULL DEFAULT '0',
    `july` INT NOT NULL DEFAULT '0',
    `august` INT NOT NULL DEFAULT '0',
    `september` INT NOT NULL DEFAULT '0',
    `october` INT NOT NULL DEFAULT '0',
    `november` INT NOT NULL DEFAULT '0',
    PRIMARY KEY (`idsal`)
);

ALTER TABLE `employes` ADD CONSTRAINT `employes_fk0` FOREIGN KEY (`ideml`) REFERENCES `salaries`(`idsal`) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE `employes` ADD CONSTRAINT `employes_fk1` FOREIGN KEY (`ideml`) REFERENCES `description`(`iddesc`)  ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE `company` ADD CONSTRAINT `company_fk3` FOREIGN KEY (`idcompany`) REFERENCES `employes`(`ideml`)  ON UPDATE CASCADE ON DELETE CASCADE;
