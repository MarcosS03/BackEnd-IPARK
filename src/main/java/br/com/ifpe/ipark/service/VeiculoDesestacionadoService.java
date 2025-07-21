package br.com.ifpe.ipark.service;

import br.com.ifpe.ipark.dto.VeiculoDesestacionadoDTO;
import br.com.ifpe.ipark.model.*;
import br.com.ifpe.ipark.repository.*;
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
    @Autowired
    private PagamentosRepository pagamentosRepository;
    @Autowired
    private ListaVagasRepository listaVagasRepository;
    @Autowired
    private VeiculoRepository veiculoRepositoryModel;

    public VeiculoDesestacionado save(VeiculoDesestacionadoDTO veiculoDTO) {
        System.out.println("chegou no service");
        Estacionamento estacionamento = estacionamentoRepository
                .findById(veiculoDTO.estacionamentoID())
                .orElseThrow(() -> new RuntimeException("ID do Estacionamento não encontrado"));

        ListaVagas listaVagas = listaVagasRepository.findById(veiculoDTO.listaVagasID())
                 .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));

        Veiculo veiculoModel = veiculoRepositoryModel.findById(veiculoDTO.veiculoID())
                 .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        Pagamentos pagamentos = new Pagamentos();
        BeanUtils.copyProperties(veiculoDTO.pagamentos(), pagamentos);
        pagamentos = pagamentosRepository.save(pagamentos);
        VeiculoDesestacionado veiculo = new VeiculoDesestacionado();
        BeanUtils.copyProperties(veiculoDTO, veiculo);
        veiculo.setUpdateTimeStamp(null);



        veiculo.setEstacionamento(estacionamento);
        veiculo.setPagamentos(pagamentos);
        veiculo.setListaVagas(listaVagas);
        veiculo.setVeiculo(veiculoModel);

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
