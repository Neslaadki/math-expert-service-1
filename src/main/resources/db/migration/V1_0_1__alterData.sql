ALTER TABLE data
    ADD COLUMN confidence_level varchar(255) DEFAULT NULL,
    ADD COLUMN autocorrelation_shift varchar(255) DEFAULT NULL,
    ADD COLUMN confidence_interval varchar(255) DEFAULT NULL,
    ADD COLUMN autocorrelation_coefficient varchar(255) DEFAULT NULL;