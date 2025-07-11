package br.com.ifpe.ipark.repository;

import br.com.ifpe.ipark.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
