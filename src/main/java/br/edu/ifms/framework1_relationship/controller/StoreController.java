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

import br.edu.ifms.framework1_relationship.model.Store;
import br.edu.ifms.framework1_relationship.service.StoreService;

@Controller // definindo essa clase como controladora
@RequestMapping("/store") // caminho
public class StoreController {
  
    @Autowired
    StoreService storeService;

    @PostMapping("/listar")
    public String saves(@ModelAttribute("store") Store store) {
        storeService.save(store);
        return "redirect:/store/listar";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/listar")
    public String locall(@Valid Store store, Model model) {
        List<Store> stores = storeService.getStores();
        model.addAttribute("listStores", stores);
        model.addAttribute("storeUpdate", new Store());
        return "listStore";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/cadastrar")
    public String Cadastrar(Model model) {
        model.addAttribute("store", new Store());
        return "Cad/cadStore";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/remove/{id}")
    public String removeStore(@PathVariable("id") UUID id) {
        storeService.delete(id);
        return "redirect:/store/listar";
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------
    @PostMapping("/update/{id}")
    public String updateStore(@PathVariable("id") UUID id, @Valid Store store, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            store.setId(id);
            return "edit";
        }

        this.storeService.save(store);

        return "redirect:/store/listar";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

}