CREATE TABLE IF NOT EXISTS appointment (
    id UUID NOT NULL,
    line_id UUID NOT NULL,
    name VARCHAR NOT NULL,
    type VARCHAR NOT NULL,
    departure_time TIME NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    CONSTRAINT pk_appointment_id PRIMARY KEY (id),
    CONSTRAINT fk_appointment_line_id FOREIGN KEY (line_id) REFERENCES line (id)
);
