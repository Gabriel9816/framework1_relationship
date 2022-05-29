package br.edu.ifms.framework1_relationship.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.framework1_relationship.model.Employee;
import br.edu.ifms.framework1_relationship.service.EmployeeService;

@Controller // definindo essa clase como controladora
@RequestMapping("/employee") // caminho
public class EmployeeController {
  
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/listar")
    public String saves(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee/listar";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/listar")
    public String locall(@Valid Employee employee, Model model) {
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("listEmployees", employees);
        model.addAttribute("employeeUpdate", new Employee());
        return "List/listEmployee";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/cadastrar")
    public String Cadastrar(Model model) {
        model.addAttribute("employee", new Employee());
        return "Cad/cadEmployee";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/remove/{id}")
    public String removeEmployee(@PathVariable("id") UUID id) {
        employeeService.delete(id);
        return "redirect:/employee/listar";
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") UUID id, @Valid Employee employee, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            employee.setId(id);
            return "errorPage";
        }

        this.employeeService.save(employee);

        return "redirect:/employee/listar";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

}