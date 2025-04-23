package br.com.ifpe.ipark.controller;

import br.com.ifpe.ipark.dto.EstacionamentoDTO;
import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.service.EstacionamentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/estacionamentos")

public class EstacionamentoController {

    @Autowired
    private EstacionamentoService estacionamentoService;

    @PostMapping
    public ResponseEntity<Object> cadastrarEstacionamento(@RequestBody EstacionamentoDTO estacionamentoDTO, UriComponentsBuilder uriComponentsBuilder) {

        Estacionamento estacionamento = new Estacionamento();
        BeanUtils.copyProperties(estacionamentoDTO, estacionamento);
//
        estacionamentoService.save(estacionamento);

        System.out.println(estacionamento.getId());

        var uri = uriComponentsBuilder.path("/estacionamentos/{id}").buildAndExpand(estacionamento.getId()).toUri();
        return ResponseEntity.created(uri).body(estacionamento);

    }

}
