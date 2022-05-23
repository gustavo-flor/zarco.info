package com.github.gustavoflor.zarco.entity;

import com.github.gustavoflor.zarco.dto.CreateLineDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lines")
@Getter
@Setter
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 64)
    private String name;

    public static Line of(final CreateLineDTO dto) {
        final Line line = new Line();
        line.setName(dto.name());
        return line;
    }
}
