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

import br.edu.ifms.framework1_relationship.model.Boss;
import br.edu.ifms.framework1_relationship.service.BossService;

@Controller // definindo essa clase como controladora
@RequestMapping("/boss") // caminho
public class BossController {
  
    @Autowired
    BossService bossService;

    @PostMapping("/listar")
    public String saves(@ModelAttribute("boss") Boss boss) {
        bossService.save(boss);
        return "redirect:/boss/listar/";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/listar")
    public String locall(@Valid Boss boss, Model model) {
        List<Boss> bosss = bossService.getBosss();
        model.addAttribute("listBosss", bosss);
        model.addAttribute("bossUpdate", new Boss());
        return "List/listBoss";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/cadastrar")
    public String Cadastrar(Model model) {
        model.addAttribute("boss", new Boss());
        return "Cad/cadBoss";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/remove/{id}")
    public String removeBoss(@PathVariable("id") UUID id) {
        bossService.delete(id);
        return "redirect:/boss/listar/";
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------
    @PostMapping("/update/{id}")
    public String updateBoss(@PathVariable("id") UUID id, @Valid Boss boss, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            boss.setId(id);
            return "errorPage";
        }

        this.bossService.save(boss);

        return "redirect:/boss/listar/";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

}