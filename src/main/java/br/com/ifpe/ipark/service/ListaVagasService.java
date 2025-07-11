package br.com.ifpe.ipark.service;

import br.com.ifpe.ipark.dto.ListaVagasDTO;
import br.com.ifpe.ipark.dto.VagaDTO;
import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.model.ListaVagas;
import br.com.ifpe.ipark.model.VeiculoEstacionado;
import br.com.ifpe.ipark.repository.EstacionamentoRepository;
import br.com.ifpe.ipark.repository.ListaVagasRepository;
import br.com.ifpe.ipark.repository.VeiculoEstacionadoRepository;
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
    @Autowired
    private VeiculoEstacionadoRepository VeiculoEstacionadoRepository;


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
        var result = vagaRepository.findAll();
        System.out.println(result);
        return vagaRepository.findAll();
    }

    public ListaVagas atualizarVaga(Long id, ListaVagasDTO vagaDTO){
        System.out.println("ID recebido no Serviço: " + id);
        System.out.println("estacionamentoID recebido no Serviço: " + vagaDTO.estacionamentoID());

        Estacionamento estacionamento = estacionamentoRepository
                .findById(vagaDTO.estacionamentoID())
                .orElseThrow(() -> new RuntimeException("ID do Estacionamento não encontrado"));

        VeiculoEstacionado veiculoEstacionado = VeiculoEstacionadoRepository
                .findById(vagaDTO.veiculoEstacionadoID())
                .orElse(null);

        System.out.println(estacionamento+ "chegou aqui");
        Optional<ListaVagas> vagaOptional = vagaRepository.findById(id);
        System.out.println(estacionamento+ "chegou aqui");



        if (vagaOptional.isEmpty()) {
            throw new RuntimeException("Vaga com ID " + id + " não encontrado.");
        }
        ListaVagas vaga = new ListaVagas();
        BeanUtils.copyProperties(vagaDTO, vaga);
        vaga.setId(id);
        vaga.setEstacionamento(estacionamento);
        vaga.setVeiculoEstacionado(veiculoEstacionado);
        System.out.println("teste de objeto no serice"+vaga);
        return vagaRepository.save(vaga);
    }

    public void excluirVaga (Long id){
        vagaRepository.deleteById(id);
    }
}
