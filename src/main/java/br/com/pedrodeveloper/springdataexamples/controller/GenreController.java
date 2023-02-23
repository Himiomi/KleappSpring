package br.com.pedrodeveloper.springdataexamples.controller;

import br.com.pedrodeveloper.springdataexamples.model.Genre;
import br.com.pedrodeveloper.springdataexamples.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @PostMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public Genre createGenre(@RequestBody @Valid Genre genre) {
        return genreRepository.save(genre);
    }

    @GetMapping
    @CrossOrigin
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
}
