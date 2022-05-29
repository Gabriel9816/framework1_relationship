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

import br.edu.ifms.framework1_relationship.model.Stock;
import br.edu.ifms.framework1_relationship.service.StockService;

@Controller // definindo essa clase como controladora
@RequestMapping("/stock") // caminho
public class StockController {
  
    @Autowired
    StockService stockService;

    @PostMapping("/listar")
    public String saves(@ModelAttribute("stock") Stock stock) {
        stockService.save(stock);
        return "redirect:/stock/listar";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/listar")
    public String locall(@Valid Stock stock, Model model) {
        List<Stock> stocks = stockService.getStocks();
        model.addAttribute("listStocks", stocks);
        model.addAttribute("stockUpdate", new Stock());
        return "List/listStock";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/cadastrar")
    public String Cadastrar(Model model) {
        model.addAttribute("stock", new Stock());
        return "Cad/cadStock";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/remove/{id}")
    public String removeStock(@PathVariable("id") UUID id) {
        stockService.delete(id);
        return "redirect:/stock/listar";
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------
    @PostMapping("/update/{id}")
    public String updateStock(@PathVariable("id") UUID id, @Valid Stock stock, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            stock.setId(id);
            return "errorPage";
        }

        this.stockService.save(stock);

        return "redirect:/stock/listar";
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

}