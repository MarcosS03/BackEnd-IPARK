package br.com.ifpe.ipark.repository;

import br.com.ifpe.ipark.model.FabricanteVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteVeiRepository extends JpaRepository<FabricanteVeiculo, Long> {
}
