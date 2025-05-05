package br.com.ifpe.ipark.repository;

import br.com.ifpe.ipark.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
}
