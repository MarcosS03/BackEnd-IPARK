package br.com.ifpe.ipark.service;

import br.com.ifpe.ipark.dto.ContatoDTO;
import br.com.ifpe.ipark.dto.EstacionamentoDTO;
import br.com.ifpe.ipark.model.Contato;
import br.com.ifpe.ipark.model.Endereco;
import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.repository.EstacionamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    public Estacionamento save(EstacionamentoDTO estacionamentoDTO) {

        Estacionamento estacionamento = new Estacionamento();
        BeanUtils.copyProperties(estacionamentoDTO, estacionamento);

        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(estacionamentoDTO.endereco(), endereco);
        endereco.setEstacionamento(estacionamento);

        List<Contato> contatos = new ArrayList<>();


        for(ContatoDTO contatoDTO : estacionamentoDTO.contatos()){
            Contato contato = new Contato();
            BeanUtils.copyProperties(contatoDTO, contato);
            contato.setEstacionamento(estacionamento);
            contatos.add(contato);
        }


        estacionamento.setEndereco(endereco);
        estacionamento.setContatos(contatos);


        estacionamentoRepository.save(estacionamento);
        return estacionamento;

    }

    public Optional<Estacionamento> buscarCursoPorId(Long id){
        return estacionamentoRepository.findById(id);
    }
    public List<Estacionamento> buscarCursoFull(){
        return estacionamentoRepository.findAll();
    }
}
