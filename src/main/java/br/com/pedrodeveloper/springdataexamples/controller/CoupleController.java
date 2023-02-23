package br.com.pedrodeveloper.springdataexamples.controller;

import br.com.pedrodeveloper.springdataexamples.model.Couple;
import br.com.pedrodeveloper.springdataexamples.repository.CoupleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/couples")
public class CoupleController {

    @Autowired
    private CoupleRepository coupleRepository;

    @PostMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public Couple createCouple(@RequestBody @Valid Couple couple) {
        return coupleRepository.save(couple);
    }

    @GetMapping
    @CrossOrigin
    public List<Couple> getAllCouples() {
        return coupleRepository.findAll();
    }
}
