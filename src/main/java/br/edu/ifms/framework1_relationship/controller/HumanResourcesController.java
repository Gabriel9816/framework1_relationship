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

import br.edu.ifms.framework1_relationship.model.HumanResources;
import br.edu.ifms.framework1_relationship.service.HumanResourcesService;

@Controller // definindo essa clase como controladora
@RequestMapping("/humanResources") // caminho
public class HumanResourcesController {
  
    @Autowired
    HumanResourcesService humanResourcesService;

    @PostMapping("/listar")
    public String saves(@ModelAttribute("humanResources") HumanResources humanResources) {
        humanResourcesService.save(humanResources);
        return "redirect:/humanResources/listar";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/listar")
    public String locall(@Valid HumanResources humanResources, Model model) {
        List<HumanResources> humanResourcess = humanResourcesService.getHumanResourcess();
        model.addAttribute("listHumanResourcess", humanResourcess);
        model.addAttribute("humanResourcesUpdate", new HumanResources());
        return "listHumanResources";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/cadastrar")
    public String Cadastrar(Model model) {
        model.addAttribute("humanResources", new HumanResources());
        return "Cad/cadHumanResources";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/remove/{id}")
    public String removeHumanResources(@PathVariable("id") UUID id) {
        humanResourcesService.delete(id);
        return "redirect:/humanResources/listar";
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------
    @PostMapping("/update/{id}")
    public String updateHumanResources(@PathVariable("id") UUID id, @Valid HumanResources humanResources, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            humanResources.setId(id);
            return "edit";
        }

        this.humanResourcesService.save(humanResources);

        return "redirect:/humanResources/listar";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

}