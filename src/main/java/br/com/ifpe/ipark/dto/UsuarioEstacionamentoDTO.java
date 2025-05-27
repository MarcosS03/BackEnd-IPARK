package br.com.ifpe.ipark.dto;


import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record UsuarioEstacionamentoDTO(String nome,
                                       @CPF(message = "CPF inválido")
                                       String cpf,
                                       String setor,
                                       String funcao,
                                       @NotNull(message = "O ID do estacionamento não pode ser nulo")
                                       Long estacionamentoID,
                                       List<EnderecoDTO> endereco,
                                       List<ContatoDTO> contatos) {
}
