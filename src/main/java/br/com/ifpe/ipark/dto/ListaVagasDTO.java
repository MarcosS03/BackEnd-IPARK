package br.com.ifpe.ipark.dto;

public record ListaVagasDTO(
        Long cadastroVagaID,
        String tipoVaga,
        String valor,
        String quantidade,
        String statuVaga,
        Long estacionamentoID,
        Long veiculoEstacionadoID

) {
    // Construtor Compacto
    public ListaVagasDTO {
        // Aqui também definimos o valor padrão:
        // Se 'veiculoEstacionadoID' for nulo, ele vira '0L'.
        // Caso contrário, mantém o valor original.
        veiculoEstacionadoID = (veiculoEstacionadoID != null) ? veiculoEstacionadoID : 0L;
    }
}
