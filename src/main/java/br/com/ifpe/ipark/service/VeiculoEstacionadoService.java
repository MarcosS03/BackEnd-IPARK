package br.com.ifpe.ipark.service;

import br.com.ifpe.ipark.dto.VeiculoEstacionadoDTO;
import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.model.VeiculoEstacionado;
import br.com.ifpe.ipark.repository.EstacionamentoRepository;
import br.com.ifpe.ipark.repository.VeiculoEstacionadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoEstacionadoService {
    @Autowired
    private VeiculoEstacionadoRepository veiculoRepository;
    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    public VeiculoEstacionado save(VeiculoEstacionadoDTO veiculoDTO) {

        Estacionamento estacionamento = estacionamentoRepository
                .findById(veiculoDTO.estacionamentoID())
                .orElseThrow(() -> new RuntimeException("ID do Estacionamento não encontrado"));

        VeiculoEstacionado veiculo = new VeiculoEstacionado();
        veiculo.setVeiculo(veiculoDTO.veiculoID());
        BeanUtils.copyProperties(veiculoDTO, veiculo);
        veiculo.setUpdateTimeStamp(null);
        veiculo.setEstacionamento(estacionamento);

        veiculoRepository.save(veiculo);
        return veiculo;

    }

    public Optional<VeiculoEstacionado> buscarVeiculoPorId(Long id){
        return veiculoRepository.findById(id);
    }

    public List<VeiculoEstacionado> buscarVeiculoFull(){
        return veiculoRepository.findAll();
    }

    public void sairEstacionamento (Long id){
        veiculoRepository.deleteById(id);
    }
}
