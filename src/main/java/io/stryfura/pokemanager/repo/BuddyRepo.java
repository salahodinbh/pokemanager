package io.stryfura.pokemanager.repo;

import io.stryfura.pokemanager.domain.Buddy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuddyRepo extends JpaRepository<Buddy, String> {
    Optional<Buddy> findById(String id);
}
