package io.stryfura.pokemanager.service;

import io.stryfura.pokemanager.domain.Buddy;
import io.stryfura.pokemanager.repo.BuddyRepo;
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

import static io.stryfura.pokemanager.constant.Constant.IMG_DIRECTORY;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class BuddyService {
    private final BuddyRepo buddyRepo;

    public Page<Buddy> getAllTrainers(int page, int size) {
        return buddyRepo.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    public Buddy getBuddy(String id){
        return buddyRepo.findById(id).orElseThrow(() -> new RuntimeException("Buddy not found"));
    }

    public Buddy createBuddy(Buddy buddy){
        return buddyRepo.save(buddy);
    }

    public void deleteBuddy(Buddy buddy){
        //Assignment
    }

    public String uploadImg(String id, MultipartFile file){
        log.info("Saving image for buddy id: {}", id);
        Buddy buddy = getBuddy(id);
        String imgUrl = imgFunction.apply(id, file);
        buddy.setImgUrl(imgUrl);
        buddyRepo.save(buddy);
        return imgUrl;
    }

    private final Function<String, String> fileExtension = filename -> Optional.of(filename).filter(name -> name.contains("."))
            .map(name -> "." + name.substring(filename.lastIndexOf(".")+1)).orElse(".png");

    private final BiFunction<String, MultipartFile, String> imgFunction = (id, image) -> {
        String filename = id + fileExtension.apply(image.getOriginalFilename());
        try{
            Path fileStorageLocation = Paths.get(IMG_DIRECTORY).toAbsolutePath().normalize();
            if(!Files.exists(fileStorageLocation)) {
                Files.createDirectories(fileStorageLocation);
            }
            Files.copy(image.getInputStream(), fileStorageLocation.resolve(filename), REPLACE_EXISTING);
            return ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/buddy/image/" + filename).toUriString();
        } catch (Exception exception){
            throw new RuntimeException("Unable to save image");
        }
    };
}
