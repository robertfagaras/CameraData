CREATE SCHEMA `lpc` DEFAULT CHARACTER SET latin1
CREATE SCHEMA `securitytest` DEFAULT CHARACTER SET latin1


CREATE TABLE lp (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` VARCHAR(45) NOT NULL,
  `carNumber` VARCHAR(45) NULL,
  PRIMARY KEY (id));


CREATE TABLE `securitytest`.`authorities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `authority` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `securitytest`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `enabled` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

INSERT INTO `securitytest`.`users`
(`id`,
`username`,
`password`,
`enabled`)
VALUES
(null,'John','12345',1);



INSERT INTO `securitytest`.`authorities`
(`id`,
`username`,
`authority`)
VALUES
(null,
'John',
'ADMIN');
