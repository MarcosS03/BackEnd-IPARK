package br.com.ifpe.ipark.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "usuariosEstacionamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEstacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String setor;
    private String funcao;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Usuario_id")
    private List<Contato> contatos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private List<Endereco> enderecoList;

    @OneToOne(mappedBy = "usuarioEstacionamento")
    private Estacionamento estacionamento;

    @CreationTimestamp
    private Instant creationTimeStamp;

    @UpdateTimestamp
    private Instant updateTimeStamp;



}
