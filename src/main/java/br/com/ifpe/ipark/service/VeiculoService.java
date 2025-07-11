package br.com.ifpe.ipark.service;


import br.com.ifpe.ipark.dto.VeiculoDTO;
import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.model.Vaga;
import br.com.ifpe.ipark.model.Veiculo;
import br.com.ifpe.ipark.repository.EstacionamentoRepository;
import br.com.ifpe.ipark.repository.VeiculoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private EstacionamentoRepository estacionamentoRepository;
    public Veiculo save(VeiculoDTO veiculoDTO) {

        Estacionamento estacionamento = estacionamentoRepository
                .findById(veiculoDTO.estacionamentoID())
                .orElseThrow(() -> new RuntimeException("ID do Estacionamento não encontrado"));

        Veiculo veiculo = new Veiculo();
        BeanUtils.copyProperties(veiculoDTO, veiculo);
        veiculo.setUpdateTimeStamp(null);
        veiculo.setEstacionamento(estacionamento);

        veiculoRepository.save(veiculo);
        return veiculo;

    }

    public Optional<Veiculo> buscarVeiculoPorId(Long id){
        return veiculoRepository.findById(id);
    }

    public List<Veiculo> buscarVeiculoFull(){
        return veiculoRepository.findAll();
    }
}
