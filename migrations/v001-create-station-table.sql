CREATE TABLE IF NOT EXISTS station (
    id UUID NOT NULL,
    name VARCHAR NOT NULL,
    external_id VARCHAR NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    CONSTRAINT pk_station_id PRIMARY KEY (id)
);

CREATE UNIQUE INDEX uk_station_external_id
    ON station (external_id);
