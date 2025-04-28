package br.com.ifpe.ipark.controller;

import br.com.ifpe.ipark.dto.EstacionamentoDTO;
import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.service.EstacionamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoService estacionamentoService;

    private long estacionamentoId;


    @PostMapping("/insert")
    public ResponseEntity<Object> cadastrarEstacionamento(@Valid @RequestBody EstacionamentoDTO estacionamentoDTO, UriComponentsBuilder uriComponentsBuilder) {

        final String cnpjNovo = estacionamentoDTO.cnpj(); // Pega o CNPJ do DTO

        // Verifica se já existe um estacionamento com o mesmo CNPJ
        List<Estacionamento> listaEstacionamentos = estacionamentoService.buscarCursoFull();
        boolean cnpjExistente = listaEstacionamentos.stream()
                .anyMatch(es -> es.getCnpj().equals(cnpjNovo));

        if (cnpjExistente) {
            return ResponseEntity.badRequest().body("CNPJ já cadastrado.");
        }

        // Aqui salva o DTO, mas recebe o Estacionamento como retorno
        Estacionamento estacionamentoSalvo = estacionamentoService.save(estacionamentoDTO);

        var uri = uriComponentsBuilder.path("/estacionamentos/{id}")
                .buildAndExpand(estacionamentoSalvo.getId())
                .toUri();
        return ResponseEntity.created(uri).body(estacionamentoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>buscarEstacionamento(@PathVariable Long id){
        Optional<Estacionamento> estacionamentoOptional = estacionamentoService.buscarCursoPorId(id);

        if (estacionamentoOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Não existe curso com o id informado");
        }
        var estacionamento = estacionamentoOptional.get();
        BeanUtils.copyProperties(estacionamentoOptional, estacionamento);
        return ResponseEntity.ok(estacionamento);
    }

}
