package br.com.ifpe.ipark.model;

import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "estacionamentos")
@ToString
public class Estacionamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razaoSocial")
    private String razaoSocial;
    @Column(name = "nomeFantasia")
    private String nomeFantasia;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "tipoPessoa")
    private String tipoPessoa;

    @OneToMany(mappedBy = "estacionamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioEstacionamento> usuarioEstacionamento;

    @OneToOne(mappedBy = "estacionamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;

    @OneToMany(mappedBy = "estacionamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contato> contatos;

    @OneToMany(mappedBy = "estacionamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vaga>vagas;

    @CreationTimestamp
    private Instant creationTimeStamp;

    @UpdateTimestamp
    @Column(insertable = false)
    private Instant updateTimeStamp;

    public Estacionamento() {
    }

    public Estacionamento(Long id, String razaoSocial, String nomeFantasia, String cnpj, String tipoPessoa, List<UsuarioEstacionamento> usuarioEstacionamento, Endereco endereco, List<Contato> contatos, Instant creationTimeStamp, Instant updateTimeStamp) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.tipoPessoa = tipoPessoa;
        this.usuarioEstacionamento = usuarioEstacionamento;
        this.endereco = endereco;
        this.contatos = contatos;
        this.creationTimeStamp = creationTimeStamp;
        this.updateTimeStamp = updateTimeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<UsuarioEstacionamento> getUsuarioEstacionamento() {
        return usuarioEstacionamento;
    }

    public void setUsuarioEstacionamento(List<UsuarioEstacionamento> usuarioEstacionamento) {
        this.usuarioEstacionamento = usuarioEstacionamento;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
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
