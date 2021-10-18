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
public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 2320796226290341840L;

    private Long id;
    
    @NonNull
    private String name;
    
    @NonNull
    private String lastName;
    
    @NonNull
    private String address;
    
    @NonNull
    private String cellphone;
    
    @NonNull
    private String cityName;
    
}
