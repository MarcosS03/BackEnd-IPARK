package br.com.ifpe.ipark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

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

    @OneToOne
    @JoinColumn( name = "listaVaga_id")
    @JsonIgnore
    private ListaVagas listaVagas;

    private String placa;
    private String chassi;
    private String renavam;
    private String modelo;
    private String fabricante;
    private String anoFabricacao;
    private String anoModelo;
    private String cor;
    private String potencia;
    private String capacidade;
    private String dataEntrada;
    private String dataSaida;
    private String HoraEntrada;
    private String HoraSaida;
    private String valorPago;
    private String tempoPermanecia;


    public VeiculoEstacionado() {
    }

    public VeiculoEstacionado(Long id, Estacionamento estacionamento, ListaVagas listaVagas, String placa, String chassi, String renavam, String modelo, String fabricante, String anoFabricacao, String anoModelo, String cor, String potencia, String capacidade, String dataEntrada, String dataSaida, String horaEntrada, String horaSaida, String valorPago, String tempoPermanecia) {
        this.id = id;
        this.estacionamento = estacionamento;
        this.listaVagas = listaVagas;
        this.placa = placa;
        this.chassi = chassi;
        this.renavam = renavam;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.cor = cor;
        this.potencia = potencia;
        this.capacidade = capacidade;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        HoraEntrada = horaEntrada;
        HoraSaida = horaSaida;
        this.valorPago = valorPago;
        this.tempoPermanecia = tempoPermanecia;
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

    public ListaVagas getListaVagas() {
        return listaVagas;
    }

    public void setListaVagas(ListaVagas listaVagas) {
        this.listaVagas = listaVagas;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
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
}
