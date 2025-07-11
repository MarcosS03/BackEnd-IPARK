package br.com.ifpe.ipark.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import br.com.ifpe.ipark.dto.VeiculoEstacionadoDTO;
import br.com.ifpe.ipark.model.VeiculoEstacionado;
import br.com.ifpe.ipark.service.VeiculoEstacionadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/veiculoEstacionado")
@CrossOrigin(origins = "http://localhost:5173")
public class VeiculoEstacionadoController {

    @Autowired
    private VeiculoEstacionadoService veiculoService;

    @PostMapping("/insert")
    public ResponseEntity<Object> estacionarVeiculo(@RequestBody VeiculoEstacionadoDTO veiculoDTO, UriComponentsBuilder uriComponentsBuilder) {

        VeiculoEstacionado veiculo = veiculoService.save(veiculoDTO);

        var uri = uriComponentsBuilder.path("/veiculos/{id}")
                .buildAndExpand(veiculo.getId())
                .toUri();
        return ResponseEntity.created(uri).body(veiculo);
    }

    @GetMapping("/veiculos/{id}")
    public ResponseEntity<Object>buscarVeiculos(@PathVariable Long id){
        Optional<VeiculoEstacionado> veiculoOptional = veiculoService.buscarVeiculoPorId(id);

        if (veiculoOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Não existe veicuolo com o id informado");
        }
        var veiculo = veiculoOptional.get();
        BeanUtils.copyProperties(veiculoOptional, veiculo);
        return ResponseEntity.ok(veiculo);
    }

    @GetMapping("/veiculos")
    public ResponseEntity<Object>buscarVeiculosFull(){
        List<VeiculoEstacionado> veiculoList = veiculoService.buscarVeiculoFull();

        if (veiculoList.isEmpty()) {
            return ResponseEntity.badRequest().body("Não existe veiculo cadastrada!");
        }
        return ResponseEntity.ok(veiculoList);
    }

    @GetMapping("/sairEstacionamento")
    public void sairEstacionamento(@PathVariable Long id) {
        veiculoService.sairEstacionamento(id);
    }
}
