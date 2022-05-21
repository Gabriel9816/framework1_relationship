package br.edu.ifms.framework1_relationship.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.framework1_relationship.model.Employee;

@Repository
public interface  EmployeeRepository extends JpaRepository<Employee, UUID>{
    // CONEXÃO DIRETA COM O BANCO DE DADOS
}