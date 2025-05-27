package br.com.ifpe.ipark.service;

import br.com.ifpe.ipark.dto.ListaVagasDTO;
import br.com.ifpe.ipark.dto.VagaDTO;
import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.model.ListaVagas;
import br.com.ifpe.ipark.repository.EstacionamentoRepository;
import br.com.ifpe.ipark.repository.ListaVagasRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaVagasService {

    @Autowired
    private ListaVagasRepository vagaRepository;
    @Autowired
    private EstacionamentoRepository estacionamentoRepository;


    public ListaVagas save(ListaVagasDTO vagaDTO) {

        Estacionamento estacionamento = estacionamentoRepository
                .findById(vagaDTO.estacionamentoID())
                .orElseThrow(() -> new RuntimeException("ID do Estacionamento não encontrado"));

        ListaVagas vaga = new ListaVagas();
        BeanUtils.copyProperties(vagaDTO, vaga);
        vaga.setUpdateTimeStamp(null);
        vaga.setStatuVaga("desocupada");
        vaga.setEstacionamento(estacionamento);

        vagaRepository.save(vaga);
        return vaga;

    }
    public Optional<ListaVagas> buscarVagaPorId(Long id){
        return vagaRepository.findById(id);
    }

    public List<ListaVagas> buscarVagaFull(){
        return vagaRepository.findAll();
    }

    public ListaVagas atualizarVaga(Long id, VagaDTO vagaDTO){
        Estacionamento estacionamento = estacionamentoRepository
                .findById(vagaDTO.estacionamentoID())
                .orElseThrow(() -> new RuntimeException("ID do Estacionamento não encontrado"));
        System.out.println(estacionamento+ "teste de print");
        Optional<ListaVagas> vagaOptional = vagaRepository.findById(id);


        if (vagaOptional.isEmpty()) {
            throw new RuntimeException("Vaga com ID " + id + " não encontrado.");
        }
        ListaVagas vaga = new ListaVagas();
        BeanUtils.copyProperties(vagaDTO, vaga);
        vaga.setId(id);
        vaga.setEstacionamento(estacionamento);
        return vagaRepository.save(vaga);
    }

    public void excluirVaga (Long id){
        vagaRepository.deleteById(id);
    }
}
