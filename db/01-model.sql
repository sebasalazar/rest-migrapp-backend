BEGIN TRANSACTION;

DROP TABLE IF EXISTS credentials CASCADE;
CREATE TABLE credentials (
    pk bigserial NOT NULL,
    app varchar(255) NOT NULL,
    key varchar(255) NOT NULL,
    created timestamp NOT NULL DEFAULT NOW(), -- Fecha de creación del registro
    updated timestamp NOT NULL DEFAULT NOW(), -- Fecha de actualización del registro.
    UNIQUE (app),
    PRIMARY KEY (pk)
);
CREATE UNIQUE INDEX ON credentials(UPPER(TRIM(both FROM app)));

DROP TABLE IF EXISTS countries CASCADE;
CREATE TABLE countries (
    pk bigserial NOT NULL,
    lang varchar(2) NOT NULL,
    name varchar(255) NOT NULL,
    code varchar(2) NOT NULL,
    abbr varchar(3) NOT NULL,
    currency_iso varchar(3) NOT NULL,
    currency_code int NOT NULL,
    decimal_precision int NOT NULL,
    currency_name varchar(255) NOT NULL,
    active boolean NOT NULL DEFAULT '0', -- Flag que indica si el comercio está activo
    created timestamp NOT NULL DEFAULT NOW(), -- Fecha de creación del registro
    updated timestamp NOT NULL DEFAULT NOW(), -- Fecha de actualización del registro.
    UNIQUE (code),
    PRIMARY KEY (pk)
);
CREATE UNIQUE INDEX ON countries(UPPER(TRIM(both FROM name)));
CREATE UNIQUE INDEX ON countries(UPPER(TRIM(both FROM code)));
CREATE UNIQUE INDEX ON countries(UPPER(TRIM(both FROM abbr)));


DROP TABLE IF EXISTS indicators CASCADE;
CREATE TABLE indicators (
    pk bigserial NOT NULL,
    country_fk bigint NOT NULL,
    code int NOT NULL,
    year int NOT NULL,
    value numeric NOT NULL,
    FOREIGN KEY (country_fk) REFERENCES countries(pk) ON UPDATE CASCADE ON DELETE CASCADE,
    created timestamp NOT NULL DEFAULT NOW(), -- Fecha de creación del registro
    updated timestamp NOT NULL DEFAULT NOW(), -- Fecha de actualización del registro.
    UNIQUE (country_fk, code, year),
    PRIMARY KEY (pk)
);

COMMIT;
