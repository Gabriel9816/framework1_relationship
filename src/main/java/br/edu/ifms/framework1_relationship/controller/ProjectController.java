package br.edu.ifms.framework1_relationship.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.framework1_relationship.model.Employee;
import br.edu.ifms.framework1_relationship.model.Project;
import br.edu.ifms.framework1_relationship.service.EmployeeService;
import br.edu.ifms.framework1_relationship.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String listAllProjects(Model html) {
        List<Project> projectsList = projectService.getProjects();
        html.addAttribute("projectsList", projectsList);
        html.addAttribute("noDataProject", new Project());
        List<Employee> employeesList = employeeService.getEmployees();
        html.addAttribute("employeesList", employeesList);
        return "Project";
    }


    @PostMapping("/save")
    public String saveProject(@ModelAttribute("noDataProject") Project project) {
        projectService.save(project);
        return "redirect:/project/";
    }


    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable("id") UUID id) {
        projectService.delete(id);
        return "redirect:/project/";
    }
    

    @PostMapping("/update/{id}")
    public String updateProject(@PathVariable("id") UUID id, @ModelAttribute("noDataProject") Project project) {
        projectService.save(project);
        return "redirect:/project/";
    }
}