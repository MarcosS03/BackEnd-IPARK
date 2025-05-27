package br.com.ifpe.ipark.controller;


import br.com.ifpe.ipark.dto.UsuarioEstacionamentoDTO;
import br.com.ifpe.ipark.model.Estacionamento;
import br.com.ifpe.ipark.model.UsuarioEstacionamento;
import br.com.ifpe.ipark.service.UsuarioEstService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/UsuarioEstacionamento")
public class UsEstController {

    @Autowired
    private UsuarioEstService usuarioEstService;

    @PostMapping("/insert")
    public ResponseEntity<Object> cadastrarUsuarioEstacionamento(@Valid @RequestBody UsuarioEstacionamentoDTO usuarioDTO, UriComponentsBuilder uriComponentsBuilder) {
        final String cpfNovo = usuarioDTO.cpf(); // Pega o CNPJ do DTO

        // Verifica se já existe um estacionamento com o mesmo CNPJ
        List<UsuarioEstacionamento> listaUsuarios = usuarioEstService.buscarUsuarioFull();
        boolean cnpjExistente = listaUsuarios.stream()
                .anyMatch(es -> es.getCpf().equals(cpfNovo));

        if (cnpjExistente) {
            return ResponseEntity.badRequest().body("CPF já cadastrado.");
        }

        UsuarioEstacionamento usuario = usuarioEstService.save(usuarioDTO);

        var uri = uriComponentsBuilder.path("/estacionamentos/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>buscarEstacionamento(@PathVariable Long id){
        Optional<UsuarioEstacionamento> usuarioOptional = usuarioEstService.buscarUsuarioPorId(id);

        if (usuarioOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Não existe Usuário com o id informado");
        }
        var estacionamento = usuarioOptional.get();
        BeanUtils.copyProperties(usuarioOptional, estacionamento);
        return ResponseEntity.ok(usuarioOptional);
    }

    @PutMapping("/updateUsuario/{id}")
    public ResponseEntity<Object> AtualizarUsuario(@PathVariable Long id, @RequestBody UsuarioEstacionamentoDTO usuarioDTO, UriComponentsBuilder uriComponentsBuilder) {

        UsuarioEstacionamento usuarioAtualizado = usuarioEstService.atualizarUsuario(id, usuarioDTO);
        var uri = uriComponentsBuilder.path("/estacionamentos/{id}")
                .buildAndExpand(usuarioAtualizado.getId())
                .toUri();
        return ResponseEntity.created(uri).body(usuarioAtualizado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object>ExcluirUsuario(@PathVariable Long id){

        if ( usuarioEstService.buscarUsuarioPorId(id).isEmpty()){
            return ResponseEntity.badRequest().body("Id não encontrado");
        }
        usuarioEstService.excluirUsuario(id);
        return ResponseEntity.ok().body("Usuario excluída com sucesso");
    }
}
