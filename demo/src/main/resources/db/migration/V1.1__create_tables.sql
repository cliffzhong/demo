DROP TABLE IF EXISTS client_manager CASCADE;
DROP TABLE IF EXISTS client CASCADE;
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS client_sensitive CASCADE;
--DROP SEQUENCE IF EXISTS major_id_seq;
--DROP SEQUENCE IF EXISTS student_id_seq;
--DROP SEQUENCE IF EXISTS project_id_seq;

-- CREATE SEQUENCE major_id_seq START WITH 1;
-- CREATE SEQUENCE student_id_seq START WITH 1;
-- CREATE SEQUENCE project_id_seq START WITH 1;


CREATE TABLE manager (
    /*id                INTEGER NOT NULL default nextval('manager_id_seq'), */
    id                BIGSERIAL NOT NULL,
    name              VARCHAR(30) not null unique,
    description       VARCHAR(150)
);

ALTER TABLE manager ADD CONSTRAINT manager_pk PRIMARY KEY ( id );

CREATE TABLE product (
    /*id             INTEGER NOT NULL default nextval('product_id_seq'),*/
    id             BIGSERIAL NOT NULL,
    name   VARCHAR(30),
    description       VARCHAR(150),
    create_date    date default CURRENT_DATE
);

ALTER TABLE product ADD CONSTRAINT product_pk PRIMARY KEY ( id );

CREATE TABLE client (
    /*id              INTEGER NOT NULL default nextval('client_id_seq'),*/
    id              BIGSERIAL NOT NULL,
    login_name            VARCHAR(30) not null unique,
    password        VARCHAR(64),
    first_name      VARCHAR(30),
    last_name       VARCHAR(30),
    email           VARCHAR(50),
    enrolled_date      date default CURRENT_DATE,
    manager_id   bigint NOT NULL
);

ALTER TABLE client ADD CONSTRAINT client_pk PRIMARY KEY ( id );

CREATE TABLE client_sensitive (
    /*id              INTEGER NOT NULL default nextval('client_id_seq'),*/
    id              BIGSERIAL NOT NULL,
    login_name            VARCHAR(30) not null unique,
    password        VARCHAR(64),
    first_name      VARCHAR(30),
    last_name       VARCHAR(30),
    email           VARCHAR(50),
    address         VARCHAR(150),
    ssn             VARCHAR(30)
);

ALTER TABLE client_sensitive ADD CONSTRAINT client_sensitive_pk PRIMARY KEY ( id );

CREATE TABLE client_product (
    client_id    BIGINT NOT NULL,
    product_id    BIGINT NOT NULL
);

ALTER TABLE client
    ADD CONSTRAINT client_product_hold FOREIGN KEY ( manager_id )
        REFERENCES manager ( id );

ALTER TABLE client_product
    ADD CONSTRAINT client_fk FOREIGN KEY ( client_id )
        REFERENCES client ( id );

ALTER TABLE client_product
    ADD CONSTRAINT product_fk FOREIGN KEY ( product_id )
        REFERENCES product ( id );
