package br.com.ifpe.ipark.dto;

import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.model.ListaVagas;
import br.com.ifpe.ipark.model.Veiculo;
import jakarta.validation.constraints.NotBlank;

public record VeiculoEstacionadoDTO(
        @NotBlank(message = "ID do estacionamento não pode ser null")
        Long estacionamentoID,
        @NotBlank(message = ("Vaga não selecionada"))
        Long listaVagasID,
        @NotBlank(message = "Veiculo não informado")
        Veiculo veiculoID,
        String dataEntrada,
        String HoraEntrada
) {
}
