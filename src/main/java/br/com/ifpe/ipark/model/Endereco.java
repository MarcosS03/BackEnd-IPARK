package br.com.ifpe.ipark.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "enderecos")
public class Endereco {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "estacionamentto")
    private List<Estacionamento> estacionamento;


}
