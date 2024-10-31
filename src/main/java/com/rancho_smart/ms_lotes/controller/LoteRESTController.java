package com.rancho_smart.ms_lotes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rancho_smart.ms_lotes.entity.Lote;
import com.rancho_smart.ms_lotes.service.LoteService;

@RestController
@RequestMapping(path = "/lotes")
public class LoteRESTController {
    
    @Autowired
    private LoteService loteService;

    @GetMapping
    public ResponseEntity<List<Lote>> getAllLotes() {
        List<Lote> listado = this.loteService.getLotes();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/fincas/{idFinca}")
    public ResponseEntity<List<Lote>> getLotesByIdFinca(@PathVariable Long idFinca){
        List<Lote> lotesByIdFica = this.loteService.getLotesByIdFinca(idFinca);
        return new ResponseEntity<>(lotesByIdFica, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lote> getLoteById(@PathVariable Long id) {
        Optional<Lote> lote = this.loteService.getLoteById(id);
        return lote.map(ResponseEntity::ok)
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Lote> saveLote(@RequestBody Lote lote) {
        Lote loteCreado = this.loteService.saveLote(lote);
        return new ResponseEntity<>(loteCreado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lote> updateLote(@PathVariable Long id, @RequestBody Lote lote) {
        if (!this.loteService.getLoteById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            lote.setIdLote(id);
            Lote loteActualizado = this.loteService.saveLote(lote);
            return new ResponseEntity<>(loteActualizado, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLote(@PathVariable Long id) {
        if (!this.loteService.getLoteById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.loteService.deleteLote(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
