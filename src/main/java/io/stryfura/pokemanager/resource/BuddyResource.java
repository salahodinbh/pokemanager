package io.stryfura.pokemanager.resource;

import io.stryfura.pokemanager.domain.Buddy;
import io.stryfura.pokemanager.service.BuddyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/buddies")
@RequiredArgsConstructor
public class BuddyResource {
    private final BuddyService buddyService;

    @PostMapping
    public ResponseEntity<Buddy> createBuddy(@RequestBody Buddy buddy) {
        //return ResponseEntity.ok().body(trainerService.createTrainer(buddy));
        return ResponseEntity.created(URI.create("/buddies/buddyID")).body(buddyService.createBuddy(buddy));
    }

    @GetMapping
    public ResponseEntity<Page<Buddy>> getBuddies(@RequestParam(value = "page", defaultValue = "0") int page,
                                                     @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok().body(buddyService.getAllBuddies(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buddy> getBuddy(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(buddyService.getBuddy(id));
    }
}
