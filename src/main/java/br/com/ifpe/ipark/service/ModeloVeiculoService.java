package br.com.ifpe.ipark.service;

import br.com.ifpe.ipark.model.FabricanteVeiculo;
import br.com.ifpe.ipark.model.ModeloVeiculo;
import br.com.ifpe.ipark.repository.ModeloVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloVeiculoService {

    @Autowired
    private ModeloVeiculoRepository modeloRepository;

    public Optional<ModeloVeiculo> buscarMoleloPorId(Long id){
        return modeloRepository.findById(id);
    }

    public List<ModeloVeiculo> buscarModeloFull(){
        return modeloRepository.findAll();
    }
}
