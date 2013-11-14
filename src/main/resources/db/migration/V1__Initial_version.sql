--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

SET default_with_oids = false;

CREATE TABLE predemanda (
    id bigint NOT NULL,
    coordenadorid bigint,
    coordenadornome character varying(255),
    cursoid bigint,
    cursonome character varying(255),
    datadacriacao timestamp without time zone,
    datafim timestamp without time zone,
    datainicio timestamp without time zone
);


CREATE TABLE predemanda_disciplinas (
    predemanda_id bigint NOT NULL,
    disciplinas bigint
);


CREATE TABLE resposta (
    id bigint NOT NULL,
    idaluno bigint,
    predemanda_id bigint
);


CREATE TABLE resposta_disciplinas (
    resposta_id bigint NOT NULL,
    disciplinas bigint
);


ALTER TABLE ONLY predemanda
    ADD CONSTRAINT predemanda_pkey PRIMARY KEY (id);

ALTER TABLE ONLY resposta
    ADD CONSTRAINT resposta_pkey PRIMARY KEY (id);

ALTER TABLE ONLY resposta_disciplinas
    ADD CONSTRAINT fk46c1e28947234a5d FOREIGN KEY (resposta_id) REFERENCES resposta(id);

ALTER TABLE ONLY predemanda_disciplinas
    ADD CONSTRAINT fkb39e0fbbb185243d FOREIGN KEY (predemanda_id) REFERENCES predemanda(id);

ALTER TABLE ONLY resposta
    ADD CONSTRAINT fkebb72721b185243d FOREIGN KEY (predemanda_id) REFERENCES predemanda(id);

