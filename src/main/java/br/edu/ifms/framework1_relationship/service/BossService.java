package br.edu.ifms.framework1_relationship.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.framework1_relationship.model.Boss;
import br.edu.ifms.framework1_relationship.repository.BossRepository;

@Service
public class BossService {
    @Autowired
    BossRepository bossRepository;

    public List<Boss> getBosss() {
        return this.bossRepository.findAll();
    }

    public void save(Boss boss) {
        bossRepository.save(boss);
    }

    public void delete(UUID id) {
        bossRepository.deleteById(id);
    }

    public Boss findById(UUID id) {
        return bossRepository.findById(id).get();
    }
}
