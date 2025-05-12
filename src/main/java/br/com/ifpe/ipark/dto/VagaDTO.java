package br.com.ifpe.ipark.dto;

public record VagaDTO(
         String tipoVaga,
         String valor,
         String quantidade,
         Long estacionamentoID
) {
}
