package com.lean.tech.employees.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lean.tech.employees.model.dto.PositionEmployeesDTO;

@RequestMapping(path = "/positions")
public interface PositionAPI {

    @GetMapping
    public ResponseEntity<List<PositionEmployeesDTO>> list();

}
