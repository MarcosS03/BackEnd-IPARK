package br.com.ifpe.ipark.repository;

import br.com.ifpe.ipark.model.Pagamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentosRepository extends JpaRepository<Pagamentos, Long> {
}
