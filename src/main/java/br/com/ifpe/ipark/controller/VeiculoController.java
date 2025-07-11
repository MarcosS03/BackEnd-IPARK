package br.com.ifpe.ipark.controller;


import br.com.ifpe.ipark.dto.VeiculoDTO;
import br.com.ifpe.ipark.model.Veiculo;
import br.com.ifpe.ipark.service.VeiculoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin(origins = "http://localhost:5173")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/insert")
    public ResponseEntity<Object> cadastraVeiculo(@RequestBody VeiculoDTO veiculoDTO, UriComponentsBuilder uriComponentsBuilder) {

        Veiculo veiculo = veiculoService.save(veiculoDTO);

        var uri = uriComponentsBuilder.path("/veiculos/{id}")
                .buildAndExpand(veiculo.getId())
                .toUri();
        return ResponseEntity.created(uri).body(veiculo);
    }

    @GetMapping("/veiculos/{id}")
    public ResponseEntity<Object>buscarVeiculos(@PathVariable Long id){
        Optional<Veiculo> veiculoOptional = veiculoService.buscarVeiculoPorId(id);

        if (veiculoOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Não existe veicuolo com o id informado");
        }
        var estacionamento = veiculoOptional.get();
        BeanUtils.copyProperties(veiculoOptional, estacionamento);
        return ResponseEntity.ok(estacionamento);
    }

    @GetMapping("/veiculos")
    public ResponseEntity<Object>buscarVeiculosFull(){
        List<Veiculo> veiculoList = veiculoService.buscarVeiculoFull();

        if (veiculoList.isEmpty()) {
            return ResponseEntity.badRequest().body("Não existe veicuolo cadastrada!");
        }
        return ResponseEntity.ok(veiculoList);
    }
}
