package br.com.ifpe.ipark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.Instant;

@Entity
@Table(name = "veiculosDesestacionados")
public class VeiculoDesestacionado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "estacionamento_id", nullable = false)
    @JsonIgnore
    private Estacionamento estacionamento;

    @OneToOne
    @JoinColumn( name = "listaVaga_id")
    private ListaVagas listaVagas;

    @OneToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    private String dataEntrada;
    private String dataSaida;
    private String HoraEntrada;
    private String HoraSaida;
    private String valorPago;
    private String tempoPermanecia;

    @CreationTimestamp
    private Instant creationTimeStamp;

    @UpdateTimestamp
    @Column(insertable = false)
    private Instant updateTimeStamp;

    public VeiculoDesestacionado() {
    }

    public VeiculoDesestacionado(Long id, Estacionamento estacionamento, ListaVagas listaVagas, Veiculo veiculo, String dataEntrada, String dataSaida, String horaEntrada, String horaSaida, String valorPago, String tempoPermanecia, Instant creationTimeStamp, Instant updateTimeStamp) {
        this.id = id;
        this.estacionamento = estacionamento;
        this.listaVagas = listaVagas;
        this.veiculo = veiculo;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        HoraEntrada = horaEntrada;
        HoraSaida = horaSaida;
        this.valorPago = valorPago;
        this.tempoPermanecia = tempoPermanecia;
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

    public ListaVagas getListaVagas() {
        return listaVagas;
    }

    public void setListaVagas(ListaVagas listaVagas) {
        this.listaVagas = listaVagas;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getHoraEntrada() {
        return HoraEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        HoraEntrada = horaEntrada;
    }

    public String getHoraSaida() {
        return HoraSaida;
    }

    public void setHoraSaida(String horaSaida) {
        HoraSaida = horaSaida;
    }

    public String getValorPago() {
        return valorPago;
    }

    public void setValorPago(String valorPago) {
        this.valorPago = valorPago;
    }

    public String getTempoPermanecia() {
        return tempoPermanecia;
    }

    public void setTempoPermanecia(String tempoPermanecia) {
        this.tempoPermanecia = tempoPermanecia;
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
