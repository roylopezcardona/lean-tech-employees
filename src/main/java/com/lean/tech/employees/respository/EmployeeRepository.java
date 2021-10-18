package com.lean.tech.employees.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lean.tech.employees.domain.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    
    @Query(value = "SELECT emp FROM Employee emp JOIN emp.person per JOIN emp.position pos "
            + "WHERE (:name IS NULL OR per.name = :name) "
            + "AND (:position IS NULL OR pos.name = :position)")
    public List<Employee> list(String name, String position);

}
