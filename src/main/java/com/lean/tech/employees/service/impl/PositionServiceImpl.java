package com.lean.tech.employees.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lean.tech.employees.model.dto.EmployeeDTO;
import com.lean.tech.employees.model.dto.PositionEmployeesDTO;
import com.lean.tech.employees.service.EmployeeService;
import com.lean.tech.employees.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private EmployeeService employeeService;
    
    @Override
    public List<PositionEmployeesDTO> list() {
        List<EmployeeDTO> employees = employeeService.list(null, null);
        
        List<PositionEmployeesDTO> positionEmployees = new ArrayList<>();
        employees.stream()
            .collect(Collectors.groupingBy(employeeDTO -> {
                    return employeeDTO.getPosition().getName();
                }, Collectors.mapping(Function.identity(), 
                        Collectors.collectingAndThen(Collectors.toList(), 
                                employeesList -> employeesList.stream()
                                        .sorted(Comparator.comparing(EmployeeDTO::getSalary).reversed())
                                .collect(Collectors.toList())))))
            .forEach((positionName, employeesList) -> {
                positionEmployees.add(PositionEmployeesDTO.builder()
                        .employees(employeesList)
                        .id(employeesList.get(0).getId())
                        .name(positionName)
                        .build());
                
                employeesList.forEach(employee -> employee.setPosition(null));
            });
        
        return positionEmployees;
    }

}
