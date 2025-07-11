package br.com.ifpe.ipark.dto;

import br.com.ifpe.ipark.model.ModeloVeiculo;

import java.util.List;

public record FabricanteVeiculoDTO(
        Long id,
        List<ModeloVeiculo> listaVeiculos,
        String fabricante,
        String tipoVeiculo
) {
}
