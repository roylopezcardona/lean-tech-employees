package com.lean.tech.employees.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lean.tech.employees.model.dto.EmployeeDTO;

@RequestMapping(path = "/employees")
public interface EmployeeAPI {

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(EmployeeDTO employeeDTO);

    @PutMapping
    public ResponseEntity<EmployeeDTO> update(EmployeeDTO employeeDTO);

    @DeleteMapping(value = "/{employeeId}")
    public void delete(Long employeeId);

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> list(String name, String position);

}
