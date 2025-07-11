package br.com.ifpe.ipark.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "cadastroVagas")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoVaga;
    private String valor;
    private String quantidade;
    private String statuVaga;

    @ManyToOne
    @JoinColumn(name = "estacionamento_id", nullable = false)
    @JsonIgnoreProperties({"vagas", "listaVagas", "usuarioEstacionamento", "endereco", "contatos"})
    private Estacionamento estacionamento;

//    @OneToMany(mappedBy = "cadastroVagaId", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ListaVagas> listaVagas;


    @CreationTimestamp
    private Instant creationTimeStamp;

    @UpdateTimestamp
    @Column(insertable = false)
    private Instant updateTimeStamp;


    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }

    public Vaga() {
    }

    public Vaga(Long id, String tipoVaga, String valor, String quantidade, String statuVaga, Estacionamento estacionamento,Instant creationTimeStamp, Instant updateTimeStamp) {
        this.id = id;
        this.tipoVaga = tipoVaga;
        this.valor = valor;
        this.quantidade = quantidade;
        this.statuVaga = statuVaga;
        this.estacionamento = estacionamento;
        this.creationTimeStamp = creationTimeStamp;
        this.updateTimeStamp = updateTimeStamp;
    }

    public String getStatuVaga() {
        return statuVaga;
    }

    public void setStatuVaga(String statuVaga) {
        this.statuVaga = statuVaga;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoVaga() {
        return tipoVaga;
    }

    public void setTipoVaga(String tipoVaga) {
        this.tipoVaga = tipoVaga;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
}
