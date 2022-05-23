package com.github.gustavoflor.zarco.repository;

import com.github.gustavoflor.zarco.entity.Line;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineRepository {
    List<Line> findAll();
}
