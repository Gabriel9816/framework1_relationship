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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    ProjectService projectService;
    

    @GetMapping("/")
    public String listAllEmployees(Model html) {
        List<Employee> employeesList = employeeService.getEmployees();
        html.addAttribute("employeesList", employeesList);
        html.addAttribute("noDataEmployee", new Employee());
        List<Project> projectsList = projectService.getProjects();
        html.addAttribute("projectsList", projectsList);
        return "employee";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("noDataEmployee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee/";
    }


    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") UUID id) {
        employeeService.delete(id);
        return "redirect:/employee/";
    }


    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") UUID id, @ModelAttribute("noDataEmployee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee/";
    }
}

