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
  `Nombre` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `contrasenna` VARCHAR(45) NOT NULL,
  `CreadaEn` DATETIME NULL,
  `ActualizadaEn` DATETIME NULL,
  PRIMARY KEY (`pk_idUsuarios`),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Libros`.`Libros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Libros`.`Libros` (
  `PK_idLibros` INT NOT NULL AUTO_INCREMENT,
  `Titulo` VARCHAR(45) NOT NULL,
  `Autor` VARCHAR(45) NOT NULL,
  `CreadoEn` DATETIME NULL,
  `ActualizadoEn` DATETIME NULL,
  PRIMARY KEY (`PK_idLibros`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Libros`.`Libros Favoritos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Libros`.`Libros Favoritos` (
  `pk_idLibrosFav` INT NOT NULL,
  `Usuarios_pk_idUsuarios` INT NOT NULL,
  `Libros_PK_idLibros` INT NOT NULL,
  PRIMARY KEY (`pk_idLibrosFav`, `Usuarios_pk_idUsuarios`, `Libros_PK_idLibros`),
  INDEX `fk_Usuarios_has_Libros_Libros1_idx` (`Libros_PK_idLibros` ASC) VISIBLE,
  INDEX `fk_Usuarios_has_Libros_Usuarios_idx` (`Usuarios_pk_idUsuarios` ASC) VISIBLE,
  CONSTRAINT `fk_Usuarios_has_Libros_Usuarios`
    FOREIGN KEY (`Usuarios_pk_idUsuarios`)
    REFERENCES `Libros`.`Usuarios` (`pk_idUsuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_has_Libros_Libros1`
    FOREIGN KEY (`Libros_PK_idLibros`)
    REFERENCES `Libros`.`Libros` (`PK_idLibros`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
