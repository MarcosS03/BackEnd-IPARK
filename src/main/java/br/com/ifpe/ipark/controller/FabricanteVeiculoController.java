package br.com.ifpe.ipark.controller;

import br.com.ifpe.ipark.model.FabricanteVeiculo;
import br.com.ifpe.ipark.model.Veiculo;
import br.com.ifpe.ipark.service.FabricanteVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fabricanteVeiculos")
@CrossOrigin(origins = "http://localhost:5173")
public class FabricanteVeiculoController {

    @Autowired
    private FabricanteVeiculoService fabricanteService;

    @GetMapping("/fabricantes")
    public ResponseEntity<Object> buscarFabricanteFull(){
        List<FabricanteVeiculo> fabricanteList = fabricanteService.buscarFabricanteFull();

        if (fabricanteList.isEmpty()) {
            return ResponseEntity.badRequest().body("Não existe fabricante cadastrado!");
        }
        return ResponseEntity.ok(fabricanteList);
    }
}
