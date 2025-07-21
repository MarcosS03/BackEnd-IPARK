package br.com.ifpe.ipark.dto;

public record PagamentosDTO(
        String credito,
        String debito,
        String dinheiro,
        String pix,
        String valorTotal
) {
}
