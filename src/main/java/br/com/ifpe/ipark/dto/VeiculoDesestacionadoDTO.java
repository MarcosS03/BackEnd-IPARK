package br.com.ifpe.ipark.dto;

import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.model.ListaVagas;
import br.com.ifpe.ipark.model.Pagamentos;
import br.com.ifpe.ipark.model.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoDesestacionadoDTO (
        @NotNull(message = "ID do estacionamento não pode ser null")
        Long estacionamentoID,
        @NotNull(message = ("Vaga não selecionada"))
        Long listaVagasID,
        @NotNull(message = "Veiculo não informado")
        Long veiculoID,
        String dataEntrada,
        String dataSaida,
        String HoraEntrada,
        String HoraSaida,
        String valorPago,
        String tempoPermanecia,
        //@NotNull(message = "Pagamento não informado")
        PagamentosDTO pagamentos
){

}
