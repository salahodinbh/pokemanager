package io.stryfura.pokemanager.service;

import io.stryfura.pokemanager.domain.Pokemon;
import io.stryfura.pokemanager.repo.PokemonRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class PokemonService {
    private final PokemonRepo pokemonRepo;

    public Page<Pokemon> getAllPokemon(int page, int size) {
        return pokemonRepo.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    public Pokemon getPokemon(String id){
        return pokemonRepo.findById(id).orElseThrow(() -> new RuntimeException("Pokemon not found"));
    }

    public Pokemon createPokemon(Pokemon pokemon){
        return pokemonRepo.save(pokemon);
    }

    public void deletePokemon(Pokemon pokemon){
        //Assignment
    }
}
