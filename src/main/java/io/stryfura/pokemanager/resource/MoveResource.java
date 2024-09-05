package io.stryfura.pokemanager.resource;

import io.stryfura.pokemanager.domain.Move;
import io.stryfura.pokemanager.service.MoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/moves")
@RequiredArgsConstructor
public class MoveResource {
    private final MoveService moveService;

    @PostMapping
    public ResponseEntity<Move> createMove(@RequestBody Move move) {
        //return ResponseEntity.ok().body(trainerService.createTrainer(buddy));
        return ResponseEntity.created(URI.create("/moves/moveID")).body(moveService.createMove(move));
    }

    @GetMapping
    public ResponseEntity<Page<Move>> getMoves(@RequestParam(value = "page", defaultValue = "0") int page,
                                                  @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok().body(moveService.getAllMoves(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Move> getMove(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(moveService.getMove(id));
    }
}
