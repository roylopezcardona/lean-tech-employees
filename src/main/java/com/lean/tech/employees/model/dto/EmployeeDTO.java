package com.lean.tech.employees.model.dto;

import java.io.Serializable;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements Serializable {

    private static final long serialVersionUID = 1368465705546610706L;

    private Long id;
    
    @NonNull
    private Double salary;

    private PersonDTO person;

    private PositionDTO position;

}
