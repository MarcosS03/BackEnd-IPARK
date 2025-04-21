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
@Table(name = "estacionamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estacionamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razaoSocial")
    private String razaoSocial;
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
    @Column(name = "cpf_cnpj")
    private String cpf_cnpj;
    @Column(name = "tipoPessoa")
    private String tipoPessoa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private UsuarioEstacionamento usuarioEstacionamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "estacionamento_id")
    private List<Contato> contatos;

    @CreationTimestamp
    private Instant creationTimeStamp;

    @UpdateTimestamp
    private Instant updateTimeStamp;

}
