CREATE TABLE IF NOT EXISTS line_stop (
    id UUID NOT NULL,
    line_id UUID NOT NULL,
    stop_id UUID NOT NULL,
    parent_id UUID,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    CONSTRAINT pk_line_stop_id PRIMARY KEY (id),
    CONSTRAINT fk_line_stop_line_id FOREIGN KEY (line_id) REFERENCES line (id),
    CONSTRAINT fk_line_stop_stop_id FOREIGN KEY (stop_id) REFERENCES stop (id),
    CONSTRAINT fk_line_stop_parent_id FOREIGN KEY (parent_id) REFERENCES line_stop (id)
);

CREATE UNIQUE INDEX uk_line_stop_line_id_parent_id
    ON line_stop (line_id, parent_id)
    NULLS NOT DISTINCT;

CREATE UNIQUE INDEX uk_line_stop_parent_id
    ON line_stop (parent_id);
