CREATE DATABASE IF NOT EXISTS Credentials;
USE Credentials;
DROP TABLE IF EXISTS Credentials;

CREATE TABLE Credentials (
  Id INTEGER NOT NULL AUTO_INCREMENT,
  UName VARCHAR(45) NOT NULL UNIQUE,
  Passwd VARCHAR(5000) NOT NULL,
  PRIMARY KEY (Id)
);
