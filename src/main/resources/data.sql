CREATE TABLE Autor IF NOT EXISTS(
      `id` INT NOT NULL AUTO_INCREMENT,
      `instant` DATETIME NOT NULL,
      `email` VARCHAR(200) NOT NULL,
      `nome` VARCHAR(200) NOT NULL,
      `descricao` VARCHAR(400) NOT NULL,
      PRIMARY KEY (`id`)
      );

CREATE TABLE Categoria IF NOT EXISTS(
      `id` INT NOT NULL AUTO_INCREMENT,
      `nome` VARCHAR(200) NOT NULL,
      PRIMARY KEY (`id`)
      );