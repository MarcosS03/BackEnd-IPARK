package br.com.ifpe.ipark.dto;


public record ModeloVeiculoDTO(
        Long id,
        String modelo,
        Long fabricante_id,
        String tipoVeiculo
) {
}
