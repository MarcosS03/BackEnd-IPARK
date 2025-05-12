package br.com.ifpe.ipark.service;

import br.com.ifpe.ipark.dto.VagaDTO;
import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.model.Vaga;
import br.com.ifpe.ipark.repository.EstacionamentoRepository;
import br.com.ifpe.ipark.repository.VagaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;
    @Autowired
    private EstacionamentoRepository estacionamentoRepository;


    public Vaga save(VagaDTO vagaDTO) {

        Estacionamento estacionamento = estacionamentoRepository
                .findById(vagaDTO.estacionamentoID())
                .orElseThrow(() -> new RuntimeException("ID do Estacionamento não encontrado"));

        Vaga vaga = new Vaga();
        BeanUtils.copyProperties(vagaDTO, vaga);
        vaga.setUpdateTimeStamp(null);
        vaga.setStatuVaga("desocupada");
        vaga.setEstacionamento(estacionamento);

        vagaRepository.save(vaga);
        return vaga;

    }
    public Optional<Vaga> buscarVagaPorId(Long id){
        return vagaRepository.findById(id);
    }

    public List<Vaga> buscarVagaFull(){
        return vagaRepository.findAll();
    }

    public Vaga atualizarVaga(Long id, VagaDTO vagaDTO){
        Estacionamento estacionamento = estacionamentoRepository
                .findById(vagaDTO.estacionamentoID())
                .orElseThrow(() -> new RuntimeException("ID do Estacionamento não encontrado"));
        System.out.println(estacionamento+ "teste de print");
        Optional<Vaga> vagaOptional = vagaRepository.findById(id);


        if (vagaOptional.isEmpty()) {
            throw new RuntimeException("Usuário com ID " + id + " não encontrado.");
        }
        Vaga vaga = new Vaga();
        BeanUtils.copyProperties(vagaDTO, vaga);
        vaga.setId(id);
        vaga.setEstacionamento(estacionamento);
        return vagaRepository.save(vaga);
    }

    public void excluirVaga (Long id){
        vagaRepository.deleteById(id);
    }
}
