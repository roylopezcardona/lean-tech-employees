package com.lean.tech.employees.service;

import java.util.List;

import com.lean.tech.employees.model.dto.EmployeeDTO;

public interface EmployeeService {

    public EmployeeDTO create(EmployeeDTO employeeDTO);

    public EmployeeDTO update(EmployeeDTO employeeDTO);

    public void delete(Long employeeId);

    public List<EmployeeDTO> list(String name, String position);

}
