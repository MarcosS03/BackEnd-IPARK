package br.com.ifpe.ipark.controller;


import br.com.ifpe.ipark.dto.UsuarioEstacionamentoDTO;
import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.model.UsuarioEstacionamento;
import br.com.ifpe.ipark.service.UsuarioEstService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/UsuarioEstacionamento")
public class UsEstController {

    @Autowired
    private UsuarioEstService usuarioEstService;

    @PostMapping("/insert")
    public ResponseEntity<Object> cadastrarUsuarioEstacionamento(@Valid @RequestBody UsuarioEstacionamentoDTO usuarioDTO, UriComponentsBuilder uriComponentsBuilder) {


        UsuarioEstacionamento usuario = usuarioEstService.save(usuarioDTO);

        var uri = uriComponentsBuilder.path("/estacionamentos/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);

    }
}
