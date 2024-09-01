package io.stryfura.pokemanager.resource;

import io.stryfura.pokemanager.domain.Trainer;
import io.stryfura.pokemanager.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.stryfura.pokemanager.constant.Constant.IMG_DIRECTORY;
import static org.springframework.util.MimeTypeUtils.IMAGE_JPEG_VALUE;
import static org.springframework.util.MimeTypeUtils.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/trainers")
@RequiredArgsConstructor
public class TrainerResource {
    private final TrainerService trainerService;

    @PostMapping
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer) {
        //return ResponseEntity.ok().body(trainerService.createTrainer(trainer));
        return ResponseEntity.created(URI.create("/trainers/userID")).body(trainerService.createTrainer(trainer));
    }

    @GetMapping
    public ResponseEntity<Page<Trainer>> getTrainers(@RequestParam(value = "page", defaultValue = "0") int page,
                                                     @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok().body(trainerService.getAllTrainers(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainer(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(trainerService.getTrainer(id));
    }

}
