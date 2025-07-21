package br.com.ifpe.ipark.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "veiculoEstacionado")
public class VeiculoEstacionado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "estacionamento_id", nullable = false)
    @JsonIgnore
    private Estacionamento estacionamento;

    @OneToMany(mappedBy = "veiculoEstacionado", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<ListaVagas>listaVagas;

    @OneToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    private String dataEntrada;
    private String HoraEntrada;
    private String valorHora;

    @CreationTimestamp
    private Instant creationTimeStamp;

    @UpdateTimestamp
    @Column(insertable = false)
    private Instant updateTimeStamp;

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }


    public VeiculoEstacionado() {
    }

    public VeiculoEstacionado(Long id, Estacionamento estacionamento, List<ListaVagas> listaVagas, Veiculo veiculo, String dataEntrada, String horaEntrada, String valorHora, Instant creationTimeStamp, Instant updateTimeStamp) {
        this.id = id;
        this.estacionamento = estacionamento;
        this.listaVagas = listaVagas;
        this.veiculo = veiculo;
        this.dataEntrada = dataEntrada;
        HoraEntrada = horaEntrada;
        this.valorHora = valorHora;
        this.creationTimeStamp = creationTimeStamp;
        this.updateTimeStamp = updateTimeStamp;
    }

    public String getValorHora() {
        return valorHora;
    }

    public void setValorHora(String valorHora) {
        this.valorHora = valorHora;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }

    public List<ListaVagas> getListaVagas() {
        return listaVagas;
    }

    public void setListaVagas(List<ListaVagas> listaVagas) {
        this.listaVagas = listaVagas;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getHoraEntrada() {
        return HoraEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        HoraEntrada = horaEntrada;
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
