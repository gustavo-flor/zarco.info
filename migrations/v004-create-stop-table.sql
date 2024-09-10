CREATE TABLE IF NOT EXISTS stop (
    id UUID NOT NULL,
    name VARCHAR NOT NULL,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    CONSTRAINT pk_stop_id PRIMARY KEY (id)
);