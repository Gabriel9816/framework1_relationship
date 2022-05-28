package br.edu.ifms.framework1_relationship.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.framework1_relationship.model.Employee;
import br.edu.ifms.framework1_relationship.repository.EmployeeRepository;


@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return this.employeeRepository.findAll();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public void delete(UUID id) {
        employeeRepository.deleteById(id);
    }

    public Employee findById(UUID id) {
        return employeeRepository.findById(id).get();
    }
}
