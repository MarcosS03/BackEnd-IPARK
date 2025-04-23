package br.com.ifpe.ipark.dto;


import java.util.List;

public record UsuarioEstacionamentoDTO(String nome,
                                       String cpf,
                                       String setor,
                                       String funcao,
                                       EstacionamentoDTO estacionamento,
                                       List<EnderecoDTO> endereco,
                                       List<ContatoDTO> contatos) {
}
