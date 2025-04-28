package br.com.ifpe.ipark.service;

import br.com.ifpe.ipark.dto.EnderecoDTO;
import br.com.ifpe.ipark.dto.UsuarioEstacionamentoDTO;
import br.com.ifpe.ipark.model.Endereco;
import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.model.UsuarioEstacionamento;
import br.com.ifpe.ipark.repository.UsuarioEstacionamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UsuarioEstService {

    private UsuarioEstacionamentoRepository usuarioEstacionamentoRepository;

    public UsuarioEstacionamento save(UsuarioEstacionamentoDTO usuarioDTO){

        UsuarioEstacionamento usuario = new UsuarioEstacionamento();
        BeanUtils.copyProperties(usuarioDTO, usuario);

        Estacionamento estacionamento = new Estacionamento();
        BeanUtils.copyProperties(usuarioDTO.estacionamento(), estacionamento);

        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(usuarioDTO.endereco(), endereco);

        return null;
    }
}
