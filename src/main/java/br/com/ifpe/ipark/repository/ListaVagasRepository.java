package br.com.ifpe.ipark.repository;

import br.com.ifpe.ipark.model.ListaVagas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaVagasRepository extends JpaRepository<ListaVagas, Long> {
}
