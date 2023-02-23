package br.com.pedrodeveloper.springdataexamples.controller;

import br.com.pedrodeveloper.springdataexamples.model.Profil;
import br.com.pedrodeveloper.springdataexamples.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/profils")
public class ProfilController {

    @Autowired
    private ProfilRepository profilRepository;

    @PostMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public Profil createProfil(@RequestBody @Valid Profil profil) {
        return profilRepository.save(profil);
    }

    @GetMapping
    @CrossOrigin
    public List<Profil> getAllProfils() {
        return profilRepository.findAll();
    }
}
