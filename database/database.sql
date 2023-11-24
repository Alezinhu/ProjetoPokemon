CREATE SCHEMA IF NOT EXISTS `pokemon` DEFAULT CHARACTER SET utf8 ;
USE `pokemon` ;

CREATE TABLE IF NOT EXISTS `pokemon`.`Jogador` (
  `idJogador` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `nivel` INT NOT NULL,
  `vitorias` INT NOT NULL,
  PRIMARY KEY (`idJogador`));

CREATE TABLE IF NOT EXISTS `pokemon`.`Pokemon` (
  `idPokemon` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `nivel` INT NOT NULL,
  `Treinador_idTreinador` INT NOT NULL,
  PRIMARY KEY (`idPokemon`, `Treinador_idTreinador`),
  CONSTRAINT `fk_Pokemon_Treinador`
    FOREIGN KEY (`Treinador_idTreinador`)
    REFERENCES `pokemon`.`Jogador` (`idJogador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `pokemon`.`Professor` (
  `idProfessor` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `nivel` INT NOT NULL,
  `especialidade` VARCHAR(45) NOT NULL,
  `Treinador_idTreinador` INT NOT NULL,
  PRIMARY KEY (`idProfessor`, `Treinador_idTreinador`),
  CONSTRAINT `fk_Professor_Treinador1`
    FOREIGN KEY (`Treinador_idTreinador`)
    REFERENCES `pokemon`.`Jogador` (`idJogador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `pokemon`.`Arena` (
  `idArena` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `dificuldade` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idArena`));

CREATE TABLE IF NOT EXISTS `pokemon`.`Batalha` (
  `Jogador_idJogador` INT NOT NULL,
  `Ginásio_idGinásio` INT NOT NULL,
  PRIMARY KEY (`Jogador_idJogador`, `Ginásio_idGinásio`),
  CONSTRAINT `fk_Jogador_has_Ginásio_Jogador1`
    FOREIGN KEY (`Jogador_idJogador`)
    REFERENCES `pokemon`.`Jogador` (`idJogador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Jogador_has_Ginásio_Ginásio1`
    FOREIGN KEY (`Ginásio_idGinásio`)
    REFERENCES `pokemon`.`Arena` (`idArena`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

