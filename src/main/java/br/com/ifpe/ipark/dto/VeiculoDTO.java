package br.com.ifpe.ipark.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record VeiculoDTO(
        @NotBlank(message = "A placa é obrigatória")
        @Size(min = 7, max = 7, message = "A placa deve ter 7 caracteres (ex: ABC-1234)")
        String placa,
        String chassi,
        String renavam,
        String modelo,
        String fabricante,
        String anoFabricacao,
        String anoModelo,
        String cor,
        String potencia,
        String capacidade,
        String categoria,
        @NotBlank(message = "ID do estacionamento não encontrado")
        Long estacionamentoID
) {
}
