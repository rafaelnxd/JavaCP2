package com.fiap.brinquedos.service;

import com.fiap.brinquedos.model.Brinquedo;
import com.fiap.brinquedos.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrinquedoService {

    @Autowired
    private BrinquedoRepository brinquedoRepository;

    // Retorna todos os brinquedos
    public List<Brinquedo> getAllBrinquedos() {
        return brinquedoRepository.findAll();
    }

    // Salva um novo brinquedo
    public Brinquedo saveBrinquedo(Brinquedo brinquedo) {
        return brinquedoRepository.save(brinquedo);
    }

    // Retorna um brinquedo por ID
    public Optional<Brinquedo> getBrinquedoById(Long id) {
        return brinquedoRepository.findById(id);
    }

    // Atualiza um brinquedo existente
    public Brinquedo updateBrinquedo(Long id, Brinquedo brinquedo) {
        if (brinquedoRepository.existsById(id)) {
            brinquedo.setId(id);
            return brinquedoRepository.save(brinquedo);
        }
        return null;
    }

    // Exclui um brinquedo por ID
    public void deleteBrinquedo(Long id) {
        brinquedoRepository.deleteById(id);
    }
}
