CREATE TABLE IF NOT EXISTS station_line (
    station_id BIGINT NOT NULL,
    line_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT pk_station_line_station_id_line_id PRIMARY KEY (station_id, line_id),
    CONSTRAINT fk_station_line_station_id FOREIGN KEY (station_id) REFERENCES station (id),
    CONSTRAINT fk_station_line_line_id FOREIGN KEY (line_id) REFERENCES line (id)
);

