DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       id   BIGINT NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
                       name  VARCHAR(255) NOT NULL UNIQUE
);