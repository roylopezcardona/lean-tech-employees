package com.lean.tech.employees.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lean.tech.employees.domain.entity.Employee;
import com.lean.tech.employees.domain.entity.Position;
import com.lean.tech.employees.model.dto.EmployeeDTO;
import com.lean.tech.employees.respository.EmployeeRepository;
import com.lean.tech.employees.respository.PositionRepository;
import com.lean.tech.employees.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private ObjectMapper objectMapper;
    
    private static final String EMPTY_STRING = "";

    @Override
    public EmployeeDTO create(EmployeeDTO employeeDTO) {
        Optional<Position> positionOpt = positionRepository.findByName(employeeDTO.getPosition().getName());
        Employee employee = objectMapper.convertValue(employeeDTO, Employee.class);

        if (positionOpt.isPresent()) {
            employee.setPosition(positionOpt.get());
        }
        return objectMapper.convertValue(employeeRepository.save(employee), EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO) {
        if (employeeRepository.findById(employeeDTO.getId()).isPresent()) {
            return create(employeeDTO);
        }
        throw new RuntimeException("The Employee does not exist");
    }

    @Override
    public void delete(Long employeeId) {
        if (employeeRepository.findById(employeeId).isPresent()) {
            employeeRepository.deleteById(employeeId);
        }
        throw new RuntimeException("The Employee does not exist");
    }

    @Override
    public List<EmployeeDTO> list(String name, String position) {
        return employeeRepository
                .list(EMPTY_STRING.equals(name) ? null : name, EMPTY_STRING.equals(position) ? null : position)
                .stream()
                .map(employee -> objectMapper.convertValue(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

}
