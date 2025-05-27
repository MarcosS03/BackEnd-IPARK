package br.com.ifpe.ipark.repository;

import br.com.ifpe.ipark.model.VeiculoEstacionado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiEstRepository extends JpaRepository<VeiculoEstacionado, Long> {

}
