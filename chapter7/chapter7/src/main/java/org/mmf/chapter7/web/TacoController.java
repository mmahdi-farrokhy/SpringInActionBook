package org.mmf.chapter7.web;

import org.mmf.chapter7.Taco;
import org.mmf.chapter7.data.TacoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tacos", produces = {"application/json", "text/xml"})
@CrossOrigin(origins = {"http://localhost:8080", "http://tacocloud.com"})
public class TacoController {
    private final TacoRepository tacoRepository;

    public TacoController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping(params = "recent")
    public Iterable<Taco> recentTacos() {
        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        return tacoRepository.findAll(page).getContent();
    }

    @GetMapping("/{id}")
    public Optional<Taco> tacoById(@PathVariable Integer id) {
        return tacoRepository.findById(id);
    }
}
