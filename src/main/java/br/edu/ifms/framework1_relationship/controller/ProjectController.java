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

import br.edu.ifms.framework1_relationship.model.Project;
import br.edu.ifms.framework1_relationship.service.ProjectService;

@Controller // definindo essa clase como controladora
@RequestMapping("/project") // caminho
public class ProjectController {
  
    @Autowired
    ProjectService projectService;

    @PostMapping("/listar")
    public String saves(@ModelAttribute("project") Project project) {
        projectService.save(project);
        return "redirect:/project/listar";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/listar")
    public String locall(@Valid Project project, Model model) {
        List<Project> projects = projectService.getProjects();
        model.addAttribute("listProjects", projects);
        model.addAttribute("projectUpdate", new Project());
        return "List/listProject";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/cadastrar")
    public String Cadastrar(Model model) {
        model.addAttribute("project", new Project());
        return "Cad/cadProject";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/remove/{id}")
    public String removeProject(@PathVariable("id") UUID id) {
        projectService.delete(id);
        return "redirect:/project/listar";
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------
    @PostMapping("/update/{id}")
    public String updateProject(@PathVariable("id") UUID id, @Valid Project project, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            project.setId(id);
            return "errorPage";
        }

        this.projectService.save(project);

        return "redirect:/project/listar";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

}