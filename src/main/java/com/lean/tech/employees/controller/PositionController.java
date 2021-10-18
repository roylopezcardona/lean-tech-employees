package com.lean.tech.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.lean.tech.employees.api.PositionAPI;
import com.lean.tech.employees.model.dto.PositionEmployeesDTO;
import com.lean.tech.employees.service.PositionService;

@RestController
public class PositionController implements PositionAPI {

    @Autowired
    private PositionService positionService;

    @Override
    public ResponseEntity<List<PositionEmployeesDTO>> list() {
        return ResponseEntity.ok().body(positionService.list());
    }

}
