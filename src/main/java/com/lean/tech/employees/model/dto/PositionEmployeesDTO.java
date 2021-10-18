package com.lean.tech.employees.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionEmployeesDTO {
    
    private Long id;

    private String name;
    
    private List<EmployeeDTO> employees;

}
