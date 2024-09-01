package io.stryfura.pokemanager.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
@Table(name = "pokemon")
public class Pokemon implements Serializable {
    @Id
    @UuidGenerator
    @Column(name = "id", unique = true, updatable = false)
    private String id;
    private String name;
    private String pokeImg; //We'll see
    private String pokeMegaImg; //We'll see
    private String pokeShinyImg; //We'll see
    private String pokeShinyMegaImg; //We'll see

    @OneToMany
    @JoinColumn(name = "pokemon_id")
    private List<Buddy> buddies;
}