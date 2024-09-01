package io.stryfura.pokemanager.repo;

import io.stryfura.pokemanager.domain.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepo extends JpaRepository<Pokemon, String> {
    Optional<Pokemon> findById(String id);
}
