package br.com.ifpe.ipark.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuariosEstacionamento")
public class UsuarioEstacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String setor;
    private String funcao;

    private String email;
    private String telefone;
    private List<Endereco> enderecoList;
    private Estacionamento estacionamento;



}
