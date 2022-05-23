package com.github.gustavoflor.zarco.repository;

import com.github.gustavoflor.zarco.entity.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepository extends JpaRepository<Line, Long> {
}
