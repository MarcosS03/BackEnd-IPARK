package br.com.ifpe.ipark.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estacionamentos")
public class Estacionamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razaoSocial")
    private String razaoSocial;
    @Column(name = "nomeFantasia")
    private String nomeFantasia;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private Endereco endereco;


}
