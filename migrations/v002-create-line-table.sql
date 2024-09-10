CREATE TABLE IF NOT EXISTS line (
    id UUID NOT NULL,
    name VARCHAR NOT NULL,
    external_id VARCHAR NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    CONSTRAINT pk_line_id PRIMARY KEY (id)
);

CREATE UNIQUE INDEX uk_line_external_id
    ON line (external_id);
