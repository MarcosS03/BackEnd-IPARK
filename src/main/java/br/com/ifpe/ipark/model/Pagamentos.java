package br.com.ifpe.ipark.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pagamentos")
public class Pagamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String credito;
    private String debito;
    private String dinheiro;
    private String pix;
    private String valorTotal;

    public Pagamentos() {
    }

    public Long getId() {
        return id;
    }

    public Pagamentos(Long id, String credito, String debito, String dinheiro, String pix, String valorTotal) {
        this.id = id;
        this.credito = credito;
        this.debito = debito;
        this.dinheiro = dinheiro;
        this.pix = pix;
        this.valorTotal = valorTotal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCredito() {
        return credito;
    }

    public void setCredito(String credito) {
        this.credito = credito;
    }

    public String getDebito() {
        return debito;
    }

    public void setDebito(String debito) {
        this.debito = debito;
    }

    public String getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(String dinheiro) {
        this.dinheiro = dinheiro;
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }
}
