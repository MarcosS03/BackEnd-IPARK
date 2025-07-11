package br.com.ifpe.ipark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "modeloVeiculo")
public class ModeloVeiculo {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fabricante_id", nullable = false)
    @JsonIgnore
    private FabricanteVeiculo fabricante;
    private String modelo;
    private String tipoModelo;



    public ModeloVeiculo() {
    }

    public ModeloVeiculo(Long id, FabricanteVeiculo fabricante, String modelo, String tipoModelo) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.tipoModelo = tipoModelo;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getTipoModelo() {
        return tipoModelo;
    }

    public void setTipoModelo(String tipoModelo) {
        this.tipoModelo = tipoModelo;
    }

    public FabricanteVeiculo getFabricante() {
        return fabricante;
    }

    public void setFabricante(FabricanteVeiculo fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
