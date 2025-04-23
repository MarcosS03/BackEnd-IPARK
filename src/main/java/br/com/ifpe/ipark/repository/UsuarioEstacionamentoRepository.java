package br.com.ifpe.ipark.repository;

import br.com.ifpe.ipark.model.UsuarioEstacionamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioEstacionamentoRepository extends JpaRepository<UsuarioEstacionamento, Long> {
}
