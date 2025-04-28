package br.com.ifpe.ipark.dto;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record EstacionamentoDTO(String razaoSocial,
                                String nomeFantasia,
                                @CNPJ(message = "CNPJ inválido")
                                String cnpj,
                                String tipoPessoa,
                                List<UsuarioEstacionamentoDTO> usuarioEstacionamento,
                                EnderecoDTO endereco,
                                List<ContatoDTO> contatos) {
}
