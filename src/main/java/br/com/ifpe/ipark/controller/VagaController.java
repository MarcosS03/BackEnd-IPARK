package br.com.ifpe.ipark.controller;


import br.com.ifpe.ipark.dto.VagaDTO;
import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.model.Vaga;
import br.com.ifpe.ipark.service.VagaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/vaga")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @PostMapping
    public ResponseEntity<Object> cadastraVaga(@RequestBody VagaDTO vagaDTO, UriComponentsBuilder uriComponentsBuilder) {

        Vaga vaga = vagaService.save(vagaDTO);

        var uri = uriComponentsBuilder.path("/vaga/{id}")
                .buildAndExpand(vaga.getId())
                .toUri();
        return ResponseEntity.created(uri).body(vaga);
    }

    @GetMapping("/vagas/{id}")
    public ResponseEntity<Object>buscarVaga(@PathVariable Long id){
        Optional<Vaga> vagaOptional = vagaService.buscarVagaPorId(id);

        if (vagaOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Não existe vaga com o id informado");
        }
        var estacionamento = vagaOptional.get();
        BeanUtils.copyProperties(vagaOptional, estacionamento);
        return ResponseEntity.ok(estacionamento);
    }

    @GetMapping("/vagas")
    public ResponseEntity<Object>buscarVagaFull(){
        List<Vaga> vagaList = vagaService.buscarVagaFull();
        System.out.println("Chamando getAll");

        if (vagaList.isEmpty()) {
            return ResponseEntity.badRequest().body("Não existe vaga cadastrada!");
        }
        return ResponseEntity.ok(vagaList);
    }

    @PutMapping("/updateVaga/{id}")
    public ResponseEntity<Object> cadastraVaga(@PathVariable Long id, @RequestBody VagaDTO vagaDTO, UriComponentsBuilder uriComponentsBuilder) {

        Vaga vagaAtualizado = vagaService.atualizarVaga(id, vagaDTO);
        var uri = uriComponentsBuilder.path("/vaga/{id}")
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
