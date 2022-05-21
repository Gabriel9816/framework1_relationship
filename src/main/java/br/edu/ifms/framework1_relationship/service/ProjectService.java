package br.edu.ifms.framework1_relationship.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifms.framework1_relationship.model.Project;
import br.edu.ifms.framework1_relationship.repository.ProjectRepository;

public class ProjectService {
        
    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getProjects() {
        return this.projectRepository.findAll();
    }

    public void save(Project project) {
        projectRepository.save(project);
    }

    public void delete(UUID id) {
        projectRepository.deleteById(id);
    }

    public Project findById(UUID id) {
        return projectRepository.findById(id).get();
    }
}
