package br.com.ifpe.ipark.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fabricanteVeiculo")
public class FabricanteVeiculo {

    @Id
    private Long id;
    @OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModeloVeiculo>listaVeiculos;
    private String fabricante;
    private String categoria;

    public FabricanteVeiculo() {
    }

    public FabricanteVeiculo(Long id, List<ModeloVeiculo> listaVeiculos, String fabricante, String categoria) {
        this.id = id;
        this.listaVeiculos = listaVeiculos;
        this.fabricante = fabricante;
        this.categoria = categoria;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<ModeloVeiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List<ModeloVeiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}
