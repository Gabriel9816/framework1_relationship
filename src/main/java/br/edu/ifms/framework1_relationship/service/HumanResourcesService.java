package br.edu.ifms.framework1_relationship.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.framework1_relationship.model.HumanResources;
import br.edu.ifms.framework1_relationship.repository.HumanResourcesRepository;

@Service
public class HumanResourcesService {
    
    @Autowired
    HumanResourcesRepository humanResourcesRepository;

    public List<HumanResources> getHumanResourcess() {
        return this.humanResourcesRepository.findAll();
    }

    public void save(HumanResources humanResources) {
        humanResourcesRepository.save(humanResources);
    }

    public void delete(UUID id) {
        humanResourcesRepository.deleteById(id);
    }

    public HumanResources findById(UUID id) {
        return humanResourcesRepository.findById(id).get();
    }
}
