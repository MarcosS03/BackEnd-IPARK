package br.com.ifpe.ipark.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estacionamentos")

public class EstacionamentoController {

    @PostMapping
    public ResponseEntity<Object> cadastrarEstacionamento(@RequestBody String body) {

        return null;
    }

}
