package br.edu.ifpi.api_jogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpi.api_jogos.models.*;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
}