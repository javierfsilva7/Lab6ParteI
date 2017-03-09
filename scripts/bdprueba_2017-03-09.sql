SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `VI_CLIENTES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VI_CLIENTES` (
  `documento` BIGINT(20) NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `telefono` VARCHAR(20) NOT NULL,
  `direccion` VARCHAR(150) NOT NULL,
  `email` VARCHAR(150) NOT NULL,
  `vetado` TINYINT(1) NOT NULL,
  PRIMARY KEY (`documento`),
  UNIQUE INDEX `email` (`email` ASC))
ENGINE = MyISAM;

-- -----------------------------------------------------
-- Table `VI_TIPOITEM`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VI_TIPOITEM` (
  `id` INT(11) NOT NULL,
  `descripcion` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `descripcion` (`descripcion` ASC))
ENGINE = MyISAM;


-- -----------------------------------------------------
-- Table `VI_ITEMS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VI_ITEMS` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `descripcion` VARCHAR(500) NOT NULL,
  `fechalanzamiento` DATE NOT NULL,
  `tarifaxdia` BIGINT(20) NOT NULL,
  `formatorenta` VARCHAR(20) NOT NULL,
  `genero` VARCHAR(20) NOT NULL,
  `TIPOITEM_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_VI_ITEMS_VI_TIPOITEM_idx` (`TIPOITEM_id` ASC))
ENGINE = MyISAM;


-- -----------------------------------------------------
-- Table `VI_ITEMRENTADO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VI_ITEMRENTADO` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `CLIENTES_documento` BIGINT(20) NOT NULL,
  `ITEMS_id` INT(11) NOT NULL,
  `fechainiciorenta` DATE NOT NULL,
  `fechafinrenta` DATE NOT NULL,
  INDEX `fk_VI_ITEMRENTADO_VI_ITEMS1_idx` (`ITEMS_id` ASC),
  UNIQUE INDEX `ITEMS_id_UNIQUE` (`ITEMS_id` ASC),
  PRIMARY KEY (`id`))
ENGINE = MyISAM;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;




INSERT INTO `VI_TIPOITEM` (`id`, `descripcion`)
VALUES
  (1,'Video'),
  (2,'Juego'),
  (3,'Musica');
  


INSERT INTO `VI_ITEMS` (`id`, `nombre`, `descripcion`, `fechalanzamiento`, `tarifaxdia`, `formatorenta`, `genero`, `TIPOITEM_id`)
VALUES
  (1,'Los 4 Fantasticos','Los 4 Fantásticos  es una película de superhéroes  basada en la serie de cómic homónima de Marvel','2005-06-08',2000,'DVD','Ciencia Ficcion',1),
  (2,'Halo 3','Halo 3 es un videojuego de disparos en primera persona desarrollado por Bungie Studios.','2007-09-08',3000,'DVD','Shooter',2),
  (3,'Thriller','Thriller es una canción interpretada por el cantante estadounidense Michael Jackson, compuesta por Rod Temperton y producida por Quincy Jones.','1984-01-11',2000,'DVD','POP',3),
  (4,'Los 4 Fantasticos','Los 4 Fantásticos  es una película de superhéroes  basada en la serie de cómic homónima de Marvel','2005-06-08',2000,'DVD','Ciencia Ficcion',1),
  (5,'Halo 3','Halo 3 es un videojuego de disparos en primera persona desarrollado por Bungie Studios.','2007-09-08',3000,'DVD','Shooter',2),
  (6,'Thriller','Thriller es una canción interpretada por el cantante estadounidense Michael Jackson, compuesta por Rod Temperton y producida por Quincy Jones.','1984-01-11',2000,'DVD','POP',3);





  
  
  
INSERT INTO `VI_ITEMRENTADO` (`CLIENTES_documento`, `ITEMS_id`, `fechainiciorenta`, `fechafinrenta`)
VALUES
  (1026585665,1,'2017-03-06','2017-04-20'),
  (1026585669,2,'2017-03-05','2022-11-06'),
  (1026585667,3,'2017-02-14','2017-05-10');
  
  

