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
-- Table `mydb`.`PK_Dojo's`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PK_Dojo's` (
  `idDojo's` INT NOT NULL,
  `Dojo name` VARCHAR(45) NOT NULL,
  `Ubicacion` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`idDojo's`),
  UNIQUE INDEX `Dojo name_UNIQUE` (`Dojo name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Ninja's`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Ninja's` (
  `PK_idNinja's` INT NOT NULL,
  `Ninja name` VARCHAR(45) NOT NULL,
  `Habilidad` VARCHAR(45) NOT NULL,
  `PK_Dojo's_idDojo's` INT NOT NULL,
  PRIMARY KEY (`PK_idNinja's`),
  INDEX `fk_Ninja's_PK_Dojo's_idx` (`PK_Dojo's_idDojo's` ASC) VISIBLE,
  CONSTRAINT `fk_Ninja's_PK_Dojo's`
    FOREIGN KEY (`PK_Dojo's_idDojo's`)
    REFERENCES `mydb`.`PK_Dojo's` (`idDojo's`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
