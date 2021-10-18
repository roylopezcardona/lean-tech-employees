package com.lean.tech.employees.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lean.tech.employees.api.EmployeeAPI;
import com.lean.tech.employees.model.dto.EmployeeDTO;
import com.lean.tech.employees.service.EmployeeService;

@RestController
public class EmployeeController implements EmployeeAPI {

    @Autowired
    private EmployeeService employeeService;
    
    @Override
    @ResponseBody
    public ResponseEntity<EmployeeDTO> create(@RequestBody @Validated EmployeeDTO employeeDTO) {
        return ResponseEntity.ok().body(employeeService.create(employeeDTO));
    }

    @Override
    public ResponseEntity<EmployeeDTO> update(@RequestBody @Validated EmployeeDTO employeeDTO) {
        if (Objects.isNull(employeeDTO.getId())) {
            throw new NullPointerException("Id is required to update the employee");
        }
        return ResponseEntity.ok().body(employeeService.update(employeeDTO));
    }

    @Override
    public void delete(@PathVariable(name = "employeeId") Long employeeId) {
        employeeService.delete(employeeId);
    }

    @Override
    public ResponseEntity<List<EmployeeDTO>> list(
            @RequestParam(name = "name", defaultValue = "") String name, 
            @RequestParam(name = "position", defaultValue = "") String position) {
        
        return ResponseEntity.ok().body(employeeService.list(name, position));
    }

}
