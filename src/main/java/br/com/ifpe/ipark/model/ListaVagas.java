package br.com.ifpe.ipark.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "listaVagas")
public class ListaVagas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cadastroVagaID;
    private String tipoVaga;
    private String valor;
    private String quantidade;
    private String statuVaga;

    @ManyToOne
    @JoinColumn(name = "estacionamento_id", nullable = false)
    //@JsonIgnore
    //@JsonBackReference
    private Estacionamento estacionamento;

    @OneToOne
    @JoinColumn( name = "veiculoEstacionadoID")
    //@JsonIgnore
    @JsonManagedReference
    private VeiculoEstacionado veiculoEstacionado;

    @CreationTimestamp
    private Instant creationTimeStamp;

    @UpdateTimestamp
    @Column(insertable = false)
    private Instant updateTimeStamp;


    public ListaVagas() {
    }

    public ListaVagas(Long id, Long cadastroVagaID, String tipoVaga, String valor, String quantidade, String statuVaga, Estacionamento estacionamento, VeiculoEstacionado veiculoEstacionado, Instant creationTimeStamp, Instant updateTimeStamp) {
        this.id = id;
        this.cadastroVagaID = cadastroVagaID;
        this.tipoVaga = tipoVaga;
        this.valor = valor;
        this.quantidade = quantidade;
        this.statuVaga = statuVaga;
        this.estacionamento = estacionamento;
        this.veiculoEstacionado = veiculoEstacionado;
        this.creationTimeStamp = creationTimeStamp;
        this.updateTimeStamp = updateTimeStamp;
    }

    public VeiculoEstacionado getVeiculoEstacionado() {
        return veiculoEstacionado;
    }

    public void setVeiculoEstacionado(VeiculoEstacionado veiculoEstacionado) {
        this.veiculoEstacionado = veiculoEstacionado;
    }

    public Long getCadastroVagaID() {
        return cadastroVagaID;
    }

    public void setCadastroVagaID(Long cadastroVagaID) {
        this.cadastroVagaID = cadastroVagaID;
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

    public String getStatuVaga() {
        return statuVaga;
    }

    public void setStatuVaga(String statuVaga) {
        this.statuVaga = statuVaga;
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

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
