package br.com.loterica.loterica.database.repository;

import br.com.loterica.loterica.database.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

}
