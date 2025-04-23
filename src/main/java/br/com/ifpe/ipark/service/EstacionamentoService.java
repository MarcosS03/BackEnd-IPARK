package br.com.ifpe.ipark.service;

import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.repository.EstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    public void save(Estacionamento estacionamento) {
        estacionamentoRepository.save(estacionamento);

    }
}
