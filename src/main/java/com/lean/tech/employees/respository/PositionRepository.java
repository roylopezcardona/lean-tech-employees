package com.lean.tech.employees.respository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lean.tech.employees.domain.entity.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {

    public Optional<Position> findByName(String name);

}