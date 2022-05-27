package br.edu.ifms.framework1_relationship.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.framework1_relationship.model.Stock;
import br.edu.ifms.framework1_relationship.repository.StockRepository;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public List<Stock> getStocks() {
        return this.stockRepository.findAll();
    }

    public void save(Stock stock) {
        stockRepository.save(stock);
    }

    public void delete(UUID id) {
        stockRepository.deleteById(id);
    }

    public Stock findById(UUID id) {
        return stockRepository.findById(id).get();
    }
}
