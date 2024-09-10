CREATE TABLE IF NOT EXISTS appointment_line_stop (
    id UUID NOT NULL,
    appointment_id UUID NOT NULL,
    line_stop_id UUID NOT NULL,
    arrival_time TIME NOT NULL,
    departure_time TIME NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    CONSTRAINT pk_appointment_line_stop_id PRIMARY KEY (id),
    CONSTRAINT fk_appointment_line_stop_appointment_id FOREIGN KEY (appointment_id) REFERENCES appointment (id),
    CONSTRAINT fk_appointment_line_stop_line_stop_id FOREIGN KEY (line_stop_id) REFERENCES line_stop (id)
);

CREATE UNIQUE INDEX uk_appointment_line_stop_appointment_id_line_stop_id
    ON appointment_line_stop (appointment_id, line_stop_id);
