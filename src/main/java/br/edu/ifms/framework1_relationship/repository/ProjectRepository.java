package br.edu.ifms.framework1_relationship.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.framework1_relationship.model.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID>{
    // CONEXÃO DIRETA COM O BANCO DE DADOS
}