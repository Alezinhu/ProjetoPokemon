CREATE SCHEMA IF NOT EXISTS `ale` DEFAULT CHARACTER SET utf8 ;
USE `ale` ;

CREATE TABLE IF NOT EXISTS `ale`.`Jogador` (
  `idJogador` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `nivel` INT NOT NULL,
  `vitorias` INT NOT NULL,
  PRIMARY KEY (`idJogador`));
  
CREATE TABLE IF NOT EXISTS `ale`.`Pokemon` (
  `idPokemon` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `nivel` INT NOT NULL,
  `Jogador_idJogador` INT NOT NULL,
  PRIMARY KEY (`idPokemon`, `Jogador_idJogador`),
  CONSTRAINT `fk_Pokemon_Jogador1`
    FOREIGN KEY (`Jogador_idJogador`)
    REFERENCES `ale`.`Jogador` (`idJogador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE IF NOT EXISTS `ale`.`Professor` (
  `idProfessor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `nivel` INT NOT NULL,
  `especialidade` VARCHAR(45) NOT NULL,
  `Jogador_idJogador` INT NOT NULL,
  PRIMARY KEY (`idProfessor`, `Jogador_idJogador`),
  CONSTRAINT `fk_Professor_Jogador1`
    FOREIGN KEY (`Jogador_idJogador`)
    REFERENCES `ale`.`Jogador` (`idJogador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE IF NOT EXISTS `ale`.`Arena` (
  `idArena` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `dificuldade` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idArena`));
  
CREATE TABLE IF NOT EXISTS `ale`.`Batalha` (
  `Jogador_idJogador` INT NOT NULL,
  `Arena_idArena` INT NOT NULL,
  PRIMARY KEY (`Jogador_idJogador`, `Arena_idArena`),
  CONSTRAINT `fk_Jogador_has_Arena_Jogador1`
    FOREIGN KEY (`Jogador_idJogador`)
    REFERENCES `ale`.`Jogador` (`idJogador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Jogador_has_Arena_Arena1`
    FOREIGN KEY (`Arena_idArena`)
    REFERENCES `ale`.`Arena` (`idArena`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);