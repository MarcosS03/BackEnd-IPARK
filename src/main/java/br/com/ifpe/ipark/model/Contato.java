package br.com.ifpe.ipark.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "contatos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contato {
    @Id
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "fone")
    private String fone;
    @Column(name = "whatsApp")
    private String whatsApp;

    @ManyToOne
    private Estacionamento estacionamento;

    @ManyToOne
    private UsuarioEstacionamento usuarioEstacionamento;

    @CreationTimestamp
    private Instant creationTimeStamp;

    @UpdateTimestamp
    private Instant updateTimeStamp;



}
