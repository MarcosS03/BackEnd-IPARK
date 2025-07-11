package br.com.ifpe.ipark.repository;

import br.com.ifpe.ipark.model.VeiculoDesestacionado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoDesestacionadoRepository extends JpaRepository<VeiculoDesestacionado, Long> {
}
