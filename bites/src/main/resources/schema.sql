drop table if exists customer;

CREATE TABLE customer (
  id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255) NOT NULL,
   surname VARCHAR(255) NOT NULL,
   company_name VARCHAR(255),
   company_code VARCHAR(255),
   personal_code VARCHAR(255),
   address VARCHAR(255),
   CONSTRAINT pk_customer PRIMARY KEY (id)
);

drop table if exists ordered_service;

CREATE TABLE ordered_service (
  id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255) NOT NULL,
   type VARCHAR(255),
   description VARCHAR(255),
   active_from date,
   active_to date,
   CONSTRAINT pk_orderedservice PRIMARY KEY (id)
);