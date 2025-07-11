package br.com.ifpe.ipark.controller;

import br.com.ifpe.ipark.model.ModeloVeiculo;
import br.com.ifpe.ipark.model.Veiculo;
import br.com.ifpe.ipark.service.ModeloVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/modeloVeiculos")
@CrossOrigin(origins = "http://localhost:5173")
public class ModeloVeiculoController {
    @Autowired
    private ModeloVeiculoService modeloService;

    @GetMapping("/modelos")
    public ResponseEntity<Object> buscarModelosFull(){
        List<ModeloVeiculo> modelosloList = modeloService.buscarModeloFull();

        if (modelosloList.isEmpty()) {
            return ResponseEntity.badRequest().body("Não existe modelos cadastrada!");
        }
        return ResponseEntity.ok(modelosloList);
    }
}
