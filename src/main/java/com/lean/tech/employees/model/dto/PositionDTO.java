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
public class PositionDTO implements Serializable {

    private static final long serialVersionUID = -6863309574859461772L;

    private Long id;

    @NonNull
    private String name;

}
