package br.com.ifpe.ipark.service;


import br.com.ifpe.ipark.dto.ContatoDTO;
import br.com.ifpe.ipark.dto.EnderecoDTO;
import br.com.ifpe.ipark.dto.UsuarioEstacionamentoDTO;
import br.com.ifpe.ipark.model.Contato;
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
            endereco.setUsuarioEstacionamento(usuario);
            enderecos.add(endereco);
        }

        List<Contato> contatos =  new ArrayList<>();

        for (ContatoDTO contato : usuarioDTO.contatos()){
            Contato c = new Contato();
            BeanUtils.copyProperties(contato, c);
            c.setUsuarioEstacionamento(usuario);
            contatos.add(c);

        }


        usuario.setEstacionamento(estacionamento);
        usuario.setEnderecoList(enderecos);
        usuario.setContatos(contatos);


        usuarioEstacionamentoRepository.save(usuario);

        return usuario;
    }

    public Optional<UsuarioEstacionamento> buscarUsuarioPorId(Long id){
        return usuarioEstacionamentoRepository.findById(id);
    }

    public List<UsuarioEstacionamento> buscarUsuarioFull(){

        return usuarioEstacionamentoRepository.findAll();
    }

    public UsuarioEstacionamento atualizarUsuario(Long id, UsuarioEstacionamentoDTO usuarioDTO){
        Estacionamento estacionamento = estacionamentoRepository
                .findById(usuarioDTO.estacionamentoID())
                .orElseThrow(() -> new RuntimeException("ID do Estacionamento não encontrado"));
        System.out.println(estacionamento+ "teste de print");
        Optional<UsuarioEstacionamento> usuarioOptional = usuarioEstacionamentoRepository.findById(id);


        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário com ID " + id + " não encontrado.");
        }
        UsuarioEstacionamento usuario = new UsuarioEstacionamento();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuario.setId(id);
        usuario.setEstacionamento(estacionamento);
        return usuarioEstacionamentoRepository.save(usuario);
    }

    public void excluirUsuario (Long id){
        usuarioEstacionamentoRepository.deleteById(id);
    }
}
