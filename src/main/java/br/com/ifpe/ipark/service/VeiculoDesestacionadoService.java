package br.com.ifpe.ipark.service;

import br.com.ifpe.ipark.dto.VeiculoDesestacionadoDTO;
import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.model.VeiculoDesestacionado;
import br.com.ifpe.ipark.repository.EstacionamentoRepository;
import br.com.ifpe.ipark.repository.VeiculoDesestacionadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VeiculoDesestacionadoService {
    @Autowired
    private VeiculoDesestacionadoRepository veiculoRepository;
    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    public VeiculoDesestacionado save(VeiculoDesestacionadoDTO veiculoDTO) {

        Estacionamento estacionamento = estacionamentoRepository
                .findById(veiculoDTO.estacionameto().getId())
                .orElseThrow(() -> new RuntimeException("ID do Estacionamento não encontrado"));

        VeiculoDesestacionado veiculo = new VeiculoDesestacionado();
        BeanUtils.copyProperties(veiculoDTO, veiculo);
        veiculo.setUpdateTimeStamp(null);
        veiculo.setEstacionamento(estacionamento);

        veiculoRepository.save(veiculo);
        return veiculo;

    }

    public Optional<VeiculoDesestacionado> buscarVeiculoPorId(Long id){
        return veiculoRepository.findById(id);
    }

    public List<VeiculoDesestacionado> buscarVeiculoFull(){
        return veiculoRepository.findAll();
    }

    public void delete (Long id){
        veiculoRepository.deleteById(id);
    }
}
