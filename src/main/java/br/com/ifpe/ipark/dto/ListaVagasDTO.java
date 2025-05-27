package br.com.ifpe.ipark.dto;

public record ListaVagasDTO(
        Long cadastroVagaID,
        String tipoVaga,
        String valor,
        String quantidade,
        Long estacionamentoID

) {
}
