package com.rancho_smart.ms_lotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_lotes.entity.Lote;
import java.util.List;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {
    public List<Lote> findByIdFinca(Long idFinca);
}
