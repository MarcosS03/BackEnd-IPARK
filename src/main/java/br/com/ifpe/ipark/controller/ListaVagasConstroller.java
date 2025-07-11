package br.com.ifpe.ipark.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import br.com.ifpe.ipark.dto.ListaVagasDTO;
import br.com.ifpe.ipark.model.ListaVagas;
import br.com.ifpe.ipark.service.ListaVagasService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/ListaVagas")
@CrossOrigin(origins = "http://localhost:5173")
public class ListaVagasConstroller {

    @Autowired
    private ListaVagasService vagaService;

    @PostMapping("/insert")
    public ResponseEntity<Object> cadastraVaga(@RequestBody ListaVagasDTO vagaDTO, UriComponentsBuilder uriComponentsBuilder) {

        ListaVagas vaga = vagaService.save(vagaDTO);

        var uri = uriComponentsBuilder.path("/ListaVagas/{id}")
                .buildAndExpand(vaga.getId())
                .toUri();
        return ResponseEntity.created(uri).body(vaga);
    }

    @GetMapping("/ListaVagas/{id}")
    public ResponseEntity<Object>buscarVaga(@PathVariable Long id){
        Optional<ListaVagas> vagaOptional = vagaService.buscarVagaPorId(id);

        if (vagaOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Não existe vaga com o id informado");
        }
        var vaga = vagaOptional.get();
        BeanUtils.copyProperties(vagaOptional, vaga);
        return ResponseEntity.ok(vaga);
    }

    @GetMapping("/ListaVagas")
    public ResponseEntity<Object>buscarVagaFull(){
        List<ListaVagas> vagaList = vagaService.buscarVagaFull();

        if (vagaList.isEmpty()) {
            return ResponseEntity.ok(vagaList);
        }
        return ResponseEntity.ok(vagaList);
    }

    @PutMapping("/updateVaga/{id}")
    public ResponseEntity<Object> AtualizarVaga(@PathVariable Long id, @RequestBody ListaVagasDTO vagaDTO, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("ID recebido no Controller: " + id);

        ListaVagas vagaAtualizado = vagaService.atualizarVaga(id, vagaDTO);
        var uri = uriComponentsBuilder.path("/ListaVagas/{id}")
                .buildAndExpand(vagaAtualizado.getId())
                .toUri();
        return ResponseEntity.created(uri).body(vagaAtualizado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object>ExcluirVaga(@PathVariable Long id){

        if ( vagaService.buscarVagaPorId(id).isEmpty()){
            return ResponseEntity.badRequest().body("Id não encontrado");
        }
        vagaService.excluirVaga(id);
        return ResponseEntity.ok().body("Vaga excluída com sucesso");
    }
}
