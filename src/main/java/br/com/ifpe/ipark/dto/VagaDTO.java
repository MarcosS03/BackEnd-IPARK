package br.com.ifpe.ipark.dto;

public record VagaDTO(
         String descricão,
         String tipoVaga,
         String valor,
         String quantidade,
         Long estacionamentoID
) {
}
