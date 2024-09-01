package io.stryfura.pokemanager.repo;

import io.stryfura.pokemanager.domain.Move;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoveRepo extends JpaRepository<Move, String> {
    Optional<Move> findById(String s);
}
