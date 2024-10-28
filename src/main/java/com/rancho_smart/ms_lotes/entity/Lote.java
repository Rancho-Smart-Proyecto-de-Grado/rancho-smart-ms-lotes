package com.rancho_smart.ms_lotes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LOTE")
public class Lote {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLote;

    @Column(name = "ID_FINCA")
    private Long idFinca;

    @Column(name = "PROPOSITO")
    private String proposito;

    @Column(name = "AREA")
    private Long area;

    @Column(name = "COBERTURA")
    private int cobertura;

    public Lote() {
    }

    public Lote(Long idFinca, String proposito, Long area, int cobertura) {
        this.idFinca = idFinca;
        this.proposito = proposito;
        this.area = area;
        this.cobertura = cobertura;
    }



    public Long getIdLote() {
        return idLote;
    }

    public void setIdLote(Long idLote) {
        this.idLote = idLote;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public int getCobertura() {
        return cobertura;
    }

    public void setCobertura(int cobertura) {
        this.cobertura = cobertura;
    }



    public Long getIdFinca() {
        return idFinca;
    }



    public void setIdFinca(Long idFinca) {
        this.idFinca = idFinca;
    }

    
}
