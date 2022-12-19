CREATE TABLE usr
(
    id       UUID NOT NULL,
    username VARCHAR(255),
    CONSTRAINT pk_usr PRIMARY KEY (id)
);


CREATE TABLE data
(
    id                       UUID NOT NULL,
    user_id                  UUID NOT NULL,
    payload                  VARCHAR(255),
    expectation              VARCHAR(255),
    dispersion               VARCHAR(255),
    standard_deviation       VARCHAR(255),
    coefficient_of_variation VARCHAR(255),
    CONSTRAINT pk_data PRIMARY KEY (id)
);

ALTER TABLE data
    ADD CONSTRAINT FK_DATA_ON_USER FOREIGN KEY (user_id) REFERENCES usr (id);