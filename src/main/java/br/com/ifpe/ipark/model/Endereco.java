package br.com.ifpe.ipark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;


@Entity
@Table(name = "enderecos")
@ToString
public class Endereco {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn( name = "estacionamento_id")
    @JsonIgnore
    private Estacionamento estacionamento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private UsuarioEstacionamento usuarioEstacionamento;

    private String rua;
    private String numero;
    private String cep;
    private String cidade;
    private String bairro;
    private String estado;


    @CreationTimestamp
    private Instant creationTimeStamp;

    @UpdateTimestamp
    @Column(insertable = false)
    private Instant updateTimeStamp;

    public Endereco() {
    }

    public Endereco(Long id, Estacionamento estacionamento, UsuarioEstacionamento usuarioEstacionamento, String rua, String numero, String cep, String cidade, String bairro, String estado, Instant creationTimeStamp, Instant updateTimeStamp) {
        this.id = id;
        this.estacionamento = estacionamento;
        this.usuarioEstacionamento = usuarioEstacionamento;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
        this.creationTimeStamp = creationTimeStamp;
        this.updateTimeStamp = updateTimeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }

    public UsuarioEstacionamento getUsuarioEstacionamento() {
        return usuarioEstacionamento;
    }

    public void setUsuarioEstacionamento(UsuarioEstacionamento usuarioEstacionamento) {
        this.usuarioEstacionamento = usuarioEstacionamento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Instant getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(Instant creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public Instant getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(Instant updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }
}
