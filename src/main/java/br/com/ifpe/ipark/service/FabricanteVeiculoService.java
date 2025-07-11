package br.com.ifpe.ipark.service;

import br.com.ifpe.ipark.model.FabricanteVeiculo;
import br.com.ifpe.ipark.model.Veiculo;
import br.com.ifpe.ipark.repository.FabricanteVeiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FabricanteVeiculoService {

    @Autowired
    private FabricanteVeiRepository fabricanteRepository;

    public Optional<FabricanteVeiculo> buscarFabricantePorId(Long id){
        return fabricanteRepository.findById(id);
    }

    public List<FabricanteVeiculo> buscarFabricanteFull(){
        return fabricanteRepository.findAll();
    }
}
