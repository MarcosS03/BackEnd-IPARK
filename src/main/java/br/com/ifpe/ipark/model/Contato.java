package br.com.ifpe.ipark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;
    @Column(name = "fone")
    private String fone;
    @Column(name = "whatsApp")
    private String whatsApp;

    @ManyToOne
    @JoinColumn(name = "estacionamento_id")
    @JsonIgnore
    private Estacionamento estacionamento;

    @ManyToOne
    @JoinColumn(name = "Usuario_id")
    @JsonIgnore
    private UsuarioEstacionamento usuarioEstacionamento;

    @CreationTimestamp
    private Instant creationTimeStamp;

    @UpdateTimestamp
    @Column(insertable = false)
    private Instant updateTimeStamp;

    public Contato() {
    }

    public Contato(Long id, String email, String fone, String whatsApp, Estacionamento estacionamento, UsuarioEstacionamento usuarioEstacionamento, Instant creationTimeStamp, Instant updateTimeStamp) {
        this.id = id;
        this.email = email;
        this.fone = fone;
        this.whatsApp = whatsApp;
        this.estacionamento = estacionamento;
        this.usuarioEstacionamento = usuarioEstacionamento;
        this.creationTimeStamp = creationTimeStamp;
        this.updateTimeStamp = updateTimeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
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
