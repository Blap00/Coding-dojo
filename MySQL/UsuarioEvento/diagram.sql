-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Libros
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Libros
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Libros` DEFAULT CHARACTER SET utf8 ;
USE `Libros` ;

-- -----------------------------------------------------
-- Table `Libros`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Libros`.`Usuarios` (
  `pk_idUsuarios` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NULL,
  PRIMARY KEY (`pk_idUsuarios`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Libros`.`Evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Libros`.`Evento` (
  `pk_idEvento` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `horaInicio` DATETIME NOT NULL,
  `horaFin` DATETIME NOT NULL,
  PRIMARY KEY (`pk_idEvento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Libros`.`Usuarios_has_Evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Libros`.`Usuarios_has_Evento` (
  `pk_Usuarios_has_Eventocol` INT NOT NULL AUTO_INCREMENT,
  `usuarios_pk_idUsuarios` INT NOT NULL,
  `evento_pk_idEvento` INT NOT NULL,
  `horaEvento` DATETIME NOT NULL,
  PRIMARY KEY (`pk_Usuarios_has_Eventocol`, `usuarios_pk_idUsuarios`, `evento_pk_idEvento`),
  INDEX `fk_Usuarios_has_Evento_Evento1_idx` (`evento_pk_idEvento` ASC) VISIBLE,
  INDEX `fk_Usuarios_has_Evento_Usuarios_idx` (`usuarios_pk_idUsuarios` ASC) VISIBLE,
  CONSTRAINT `fk_Usuarios_has_Evento_Usuarios`
    FOREIGN KEY (`usuarios_pk_idUsuarios`)
    REFERENCES `Libros`.`Usuarios` (`pk_idUsuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_has_Evento_Evento1`
    FOREIGN KEY (`evento_pk_idEvento`)
    REFERENCES `Libros`.`Evento` (`pk_idEvento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
