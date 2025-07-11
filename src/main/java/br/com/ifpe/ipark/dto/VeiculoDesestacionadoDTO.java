package br.com.ifpe.ipark.dto;

import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.model.ListaVagas;
import br.com.ifpe.ipark.model.Veiculo;
import jakarta.validation.constraints.NotBlank;

public record VeiculoDesestacionadoDTO (
        @NotBlank(message = "ID do estacionamento não pode ser null")
        Estacionamento estacionameto,
        @NotBlank(message = ("Vaga não selecionada"))
        ListaVagas vaga,
        @NotBlank(message = "Veiculo não informado")
        Veiculo veiculo,
        String dataEntrada,
        String dataSaida,
        String HoraEntrada,
        String HoraSaida,
        String valorPago,
        String tempoPermanecia
){

}
