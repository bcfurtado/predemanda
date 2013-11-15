# Oráculo

Oráculo ou sistema de Pré-Demandas é uma ferramenta de apoio a decisão desenvolvida para auxiliar no processo de criação de uma Demanda na Universidade Federal do Ceará no Campus de Quixadá.

## Tecnologias Utilizadas
- Java 7
- vRaptor 3.5.3
- JPA 2.0 / Hibernate 4.1
- Gson 2.2.4
- Postgres 9.1
- Tomcat 7

## Configuracões

As configurações do banco do projeto deve ser alteradas no `pom.xml`, como no exemplo abaixo.

	<database.dialect>org.hibernate.dialect.PostgreSQLDialect</database.dialect>
	<database.driver>org.postgresql.Driver</database.driver>
	<database.url>jdbc:postgresql://localhost:5432/predemanda</database.url>
	<database.username>username</database.username>
	<database.password>password</database.password>
	
Além disso, a url do serviço a qual o sistema se integra, deve ser configurado no `config.properties`.

	url_service = http://localhost/sippaservice	

## Instalação

Crie o banco de dados

	create database mydatabase;

Compile o projeto

	mvn package

Execute as Migrations

	mvn flyway:migrate

Pronto :)
