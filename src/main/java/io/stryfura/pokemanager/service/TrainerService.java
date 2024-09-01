package io.stryfura.pokemanager.service;

import io.stryfura.pokemanager.domain.Trainer;
import io.stryfura.pokemanager.repo.TrainerRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class TrainerService {
    private final TrainerRepo trainerRepo;

    public Page<Trainer>getAllTrainers(int page, int size) {
        return trainerRepo.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    public Trainer getTrainer(String id){
        return trainerRepo.findById(id).orElseThrow(() -> new RuntimeException("Trainer not found"));
    }

    public Trainer createTrainer(Trainer trainer){
        return trainerRepo.save(trainer);
    }

    public void deleteTrainer(Trainer trainer){
        //Assignment
    }
}
