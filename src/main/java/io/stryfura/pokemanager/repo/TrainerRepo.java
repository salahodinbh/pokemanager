package io.stryfura.pokemanager.repo;

import io.stryfura.pokemanager.domain.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer, String> {
    Optional<Trainer> findById(String id);
}
