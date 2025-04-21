package br.com.ifpe.ipark.dto;

import java.util.List;

public record EstacionamentoDTO(String razaoSocial,
                                String nomeFantasia,
                                String cpf_cnpj,
                                String tipoPessoa,
                                UsuarioEstacionamentoDTO usuarioEstacionamento,
                                EnderecoDTO endereco,
                                List<ContatoDTO> contatos) {
}
