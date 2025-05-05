package br.com.ifpe.ipark.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
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

    @OneToMany(mappedBy = "usuarioEstacionamento", cascade = CascadeType.ALL)
    private List<Contato> contatos;

    @OneToMany(mappedBy = "usuarioEstacionamento", cascade = CascadeType.ALL)
    private List<Endereco> enderecoList;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Estacionamento estacionamento;

    @CreationTimestamp
    private Instant creationTimeStamp;

    @UpdateTimestamp
    @Column(insertable = false)
    private Instant updateTimeStamp;

    public UsuarioEstacionamento() {
    }

    public UsuarioEstacionamento(Long id, String nome, String cpf, String setor, String funcao, List<Contato> contatos, List<Endereco> enderecoList, Estacionamento estacionamento, Instant creationTimeStamp, Instant updateTimeStamp) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.setor = setor;
        this.funcao = funcao;
        this.contatos = contatos;
        this.enderecoList = enderecoList;
        this.estacionamento = estacionamento;
        this.creationTimeStamp = creationTimeStamp;
        this.updateTimeStamp = updateTimeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
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
