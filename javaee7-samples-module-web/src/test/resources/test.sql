insert into user_info (username, password, email, blocked, firstname, lastname, personID)
values ('viky', '123', 'name1@email.com', 0, 'Victoria', 'Chernishenko', '010203-11032');


ALTER TABLE `databaseconnection`.`user_info`
CHANGE COLUMN `Username` `Username` VARCHAR(45) NOT NULL DEFAULT '-' ,
CHANGE COLUMN `Password` `Password` VARCHAR(45) NULL DEFAULT '-' ,
CHANGE COLUMN `email` `email` VARCHAR(64) NULL DEFAULT '-' ;
