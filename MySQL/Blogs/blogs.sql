-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `idUsuario` INT NOT NULL,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` TIMESTAMP NULL,
  PRIMARY KEY (`idUsuario`));


-- -----------------------------------------------------
-- Table `mydb`.`Blog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Blog` (
  `idBlog` INT NOT NULL,
  `nombreBlog` VARCHAR(45) NULL,
  `creadaEn` TIMESTAMP NULL,
  `actualizadaEn` TIMESTAMP NULL,
  PRIMARY KEY (`idBlog`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Administradores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Administradores` (
  `idAdmin` INT NOT NULL,
  `user_idUsuario1` INT NOT NULL,
  `Blog_idBlog` INT NOT NULL,
  `creadaEn` TIMESTAMP NULL,
  `actualizadaEn` TIMESTAMP NULL,
  PRIMARY KEY (`idAdmin`),
  INDEX `fk_Administradores_user1_idx` (`user_idUsuario1` ASC) VISIBLE,
  INDEX `fk_Administradores_Blog1_idx` (`Blog_idBlog` ASC) VISIBLE,
  CONSTRAINT `fk_Administradores_user1`
    FOREIGN KEY (`user_idUsuario1`)
    REFERENCES `mydb`.`user` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Administradores_Blog1`
    FOREIGN KEY (`Blog_idBlog`)
    REFERENCES `mydb`.`Blog` (`idBlog`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`Publicaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Publicaciones` (
  `idPublicaciones` INT NOT NULL,
  `Administradores_idAdmin` INT NOT NULL,
  `Blog_idBlog` INT NOT NULL,
  `tituloPublicacion` VARCHAR(45) NULL,
  `contenidoPublicacion` VARCHAR(255) NULL,
  `creadaEn` TIMESTAMP NULL,
  `actualizadaEn` TIMESTAMP NULL,
  PRIMARY KEY (`idPublicaciones`),
  INDEX `fk_Publicaciones_Administradores1_idx` (`Administradores_idAdmin` ASC) VISIBLE,
  INDEX `fk_Publicaciones_Blog1_idx` (`Blog_idBlog` ASC) VISIBLE,
  CONSTRAINT `fk_Publicaciones_Administradores1`
    FOREIGN KEY (`Administradores_idAdmin`)
    REFERENCES `mydb`.`Administradores` (`idAdmin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Publicaciones_Blog1`
    FOREIGN KEY (`Blog_idBlog`)
    REFERENCES `mydb`.`Blog` (`idBlog`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Comentario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Comentario` (
  `idComentario` INT NOT NULL,
  `Publicaciones_idPublicaciones` INT NOT NULL,
  `tituloComen` VARCHAR(80) NULL,
  `contenidoComen` VARCHAR(255) NULL,
  `creadoEn` TIMESTAMP NULL,
  `actualizadaEn` TIMESTAMP NULL,
  `user_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idComentario`),
  INDEX `fk_Comentario_Publicaciones1_idx` (`Publicaciones_idPublicaciones` ASC) VISIBLE,
  INDEX `fk_Comentario_user1_idx` (`user_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Comentario_Publicaciones1`
    FOREIGN KEY (`Publicaciones_idPublicaciones`)
    REFERENCES `mydb`.`Publicaciones` (`idPublicaciones`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comentario_user1`
    FOREIGN KEY (`user_idUsuario`)
    REFERENCES `mydb`.`user` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Archivos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Archivos` (
  `idArchivos` INT NOT NULL,
  `Administradores_idAdmin` INT NOT NULL,
  `Publicaciones_idPublicaciones` INT NOT NULL,
  `creadoEn` TIMESTAMP NULL,
  `actualizadoEn` TIMESTAMP NULL,
  `pathArchivo` VARCHAR(45) NULL,
  PRIMARY KEY (`idArchivos`),
  INDEX `fk_Archivos_Administradores1_idx` (`Administradores_idAdmin` ASC) VISIBLE,
  INDEX `fk_Archivos_Publicaciones1_idx` (`Publicaciones_idPublicaciones` ASC) VISIBLE,
  CONSTRAINT `fk_Archivos_Administradores1`
    FOREIGN KEY (`Administradores_idAdmin`)
    REFERENCES `mydb`.`Administradores` (`idAdmin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Archivos_Publicaciones1`
    FOREIGN KEY (`Publicaciones_idPublicaciones`)
    REFERENCES `mydb`.`Publicaciones` (`idPublicaciones`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`VistadePaginas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`VistadePaginas` (
  `idVistadePaginas` INT NOT NULL,
  `user_idUsuario` INT NOT NULL,
  `Blog_idBlog` INT NOT NULL,
  `direccionIP` VARCHAR(20) NULL,
  `TiempoVisita` VARCHAR(45) NULL,
  `ultimaVisita` TIMESTAMP NULL,
  PRIMARY KEY (`idVistadePaginas`),
  INDEX `fk_VistadePaginas_user1_idx` (`user_idUsuario` ASC) VISIBLE,
  INDEX `fk_VistadePaginas_Blog1_idx` (`Blog_idBlog` ASC) VISIBLE,
  CONSTRAINT `fk_VistadePaginas_user1`
    FOREIGN KEY (`user_idUsuario`)
    REFERENCES `mydb`.`user` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_VistadePaginas_Blog1`
    FOREIGN KEY (`Blog_idBlog`)
    REFERENCES `mydb`.`Blog` (`idBlog`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
