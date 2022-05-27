package br.edu.ifms.framework1_relationship.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.framework1_relationship.model.Store;
import br.edu.ifms.framework1_relationship.repository.StoreRepository;

@Service
public class StoreService {
    @Autowired
    StoreRepository storeRepository;

    public List<Store> getStores() {
        return this.storeRepository.findAll();
    }

    public void save(Store store) {
        storeRepository.save(store);
    }

    public void delete(UUID id) {
        storeRepository.deleteById(id);
    }

    public Store findById(UUID id) {
        return storeRepository.findById(id).get();
    }
}
