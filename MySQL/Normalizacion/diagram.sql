-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ERMPractice
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ERMPractice
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ERMPractice` DEFAULT CHARACTER SET utf8 ;
USE `ERMPractice` ;

-- -----------------------------------------------------
-- Table `ERMPractice`.`dojo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ERMPractice`.`dojo` (
  `iddojo` INT NOT NULL,
  `nameDojo` VARCHAR(45) NULL,
  `locationDojo` VARCHAR(255) NULL,
  `createdAt` DATETIME NULL,
  `updatedAt` DATETIME NULL,
  PRIMARY KEY (`iddojo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ERMPractice`.`students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ERMPractice`.`students` (
  `idstudents` INT NOT NULL,
  `dojo_iddojo` INT NOT NULL,
  `nameStudent` VARCHAR(45) NULL,
  `createdAt` DATETIME NULL,
  `updatedAt` DATETIME NULL,
  PRIMARY KEY (`idstudents`),
  INDEX `fk_students_dojo_idx` (`dojo_iddojo` ASC) VISIBLE,
  CONSTRAINT `fk_students_dojo`
    FOREIGN KEY (`dojo_iddojo`)
    REFERENCES `ERMPractice`.`dojo` (`iddojo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ERMPractice`.`Intereses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ERMPractice`.`Intereses` (
  `idIntereses` INT NOT NULL,
  `nombreInteres` VARCHAR(255) NULL,
  `createdAt` DATETIME NULL,
  `updatedAt` DATETIME NULL,
  `students_idstudents` INT NOT NULL,
  PRIMARY KEY (`idIntereses`),
  INDEX `fk_Intereses_students1_idx` (`students_idstudents` ASC) VISIBLE,
  CONSTRAINT `fk_Intereses_students1`
    FOREIGN KEY (`students_idstudents`)
    REFERENCES `ERMPractice`.`students` (`idstudents`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ERMPractice`.`direccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ERMPractice`.`direccion` (
  `iddireccion` INT NOT NULL,
  `direccion1` VARCHAR(255) NULL,
  `createdAt` DATETIME NULL,
  `updatedAt` DATETIME NULL,
  `students_idstudents` INT NOT NULL,
  PRIMARY KEY (`iddireccion`),
  INDEX `fk_direccion_students1_idx` (`students_idstudents` ASC) VISIBLE,
  CONSTRAINT `fk_direccion_students1`
    FOREIGN KEY (`students_idstudents`)
    REFERENCES `ERMPractice`.`students` (`idstudents`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
