package br.com.ifpe.ipark.service;


import br.com.ifpe.ipark.dto.EnderecoDTO;
import br.com.ifpe.ipark.dto.UsuarioEstacionamentoDTO;
import br.com.ifpe.ipark.model.Endereco;
import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.model.UsuarioEstacionamento;
import br.com.ifpe.ipark.repository.EstacionamentoRepository;
import br.com.ifpe.ipark.repository.UsuarioEstacionamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioEstService {

    @Autowired
    private UsuarioEstacionamentoRepository usuarioEstacionamentoRepository;

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    public UsuarioEstacionamento save(UsuarioEstacionamentoDTO usuarioDTO){

        Estacionamento estacionamento = estacionamentoRepository
                .findById(usuarioDTO.estacionamentoID())
                .orElseThrow(() -> new RuntimeException("Estacionamento não encontrado"));


        UsuarioEstacionamento usuario = new UsuarioEstacionamento();
        BeanUtils.copyProperties(usuarioDTO, usuario);

        List<Endereco> enderecos = new ArrayList<>();
        for(EnderecoDTO enderecoDTO : usuarioDTO.endereco()){
            Endereco endereco = new Endereco();
            BeanUtils.copyProperties(enderecoDTO, endereco);
            endereco.setEstacionamento(estacionamento);
            enderecos.add(endereco);
        }


        usuario.setEstacionamento(estacionamento);
        usuario.setEnderecoList(enderecos);


        usuarioEstacionamentoRepository.save(usuario);

        return usuario;
    }

    public Optional<UsuarioEstacionamento> buscarUsuarioPorId(Long id){
        return usuarioEstacionamentoRepository.findById(id);
    }

    public List<UsuarioEstacionamento> buscarUsuarioFull(){
        return usuarioEstacionamentoRepository.findAll();
    }
}
