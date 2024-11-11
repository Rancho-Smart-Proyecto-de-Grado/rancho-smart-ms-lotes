package com.rancho_smart.ms_lotes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_lotes.entity.Lote;
import com.rancho_smart.ms_lotes.repository.LoteRepository;

@Service
public class LoteService {
    
    @Autowired
    private LoteRepository loteRepository;

    public List<Lote> getLotes() {
        return this.loteRepository.findAll();
    }

    public Optional<Lote> getLoteById(Long id) {
        return this.loteRepository.findById(id);
    }

    public List<Lote> getLotesByIdFinca(Long idFinca){
        return this.loteRepository.findByIdFinca(idFinca);
    }

    public Lote saveLote(Lote lote) {
        return this.loteRepository.save(lote);
    }

    public void deleteLote(Long id) {
        this.loteRepository.deleteById(id);
    }
}
