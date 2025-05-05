package br.com.ifpe.ipark.dto;


import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record UsuarioEstacionamentoDTO(String nome,
                                       @CPF(message = "CPF inválido")
                                       String cpf,
                                       String setor,
                                       String funcao,
                                       Long estacionamentoID,
                                       List<EnderecoDTO> endereco,
                                       List<ContatoDTO> contatos) {
}
