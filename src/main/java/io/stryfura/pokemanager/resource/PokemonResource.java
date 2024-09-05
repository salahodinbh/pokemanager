package io.stryfura.pokemanager.resource;

import io.stryfura.pokemanager.domain.Pokemon;
import io.stryfura.pokemanager.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonResource {
    private final PokemonService pokemonService;

    @PostMapping
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) {
        //return ResponseEntity.ok().body(pokemonService.createPokemon(buddy));
        return ResponseEntity.created(URI.create("/pokemon/pokemonID")).body(pokemonService.createPokemon(pokemon));
    }

    @GetMapping
    public ResponseEntity<Page<Pokemon>> getPokemon(@RequestParam(value = "page", defaultValue = "0") int page,
                                                  @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok().body(pokemonService.getAllPokemon(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(pokemonService.getPokemon(id));
    }
}
