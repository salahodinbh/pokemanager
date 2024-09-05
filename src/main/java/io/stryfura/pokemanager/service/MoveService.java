package io.stryfura.pokemanager.service;

import io.stryfura.pokemanager.domain.Move;
import io.stryfura.pokemanager.repo.MoveRepo;
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
public class MoveService {
    private final MoveRepo moveRepo;

    public Page<Move> getAllMoves(int page, int size) {
        return moveRepo.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    public Move getMove(String id){
        return moveRepo.findById(id).orElseThrow(() -> new RuntimeException("Move not found"));
    }

    public Move createMove(Move move){
        return moveRepo.save(move);
    }

    public void deleteMove(Move move){
        //Assignment
    }
}
