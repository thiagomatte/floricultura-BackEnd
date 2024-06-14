package com.floricultura.controller;

import java.util.List;
import java.util.Optional;

import com.floricultura.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.floricultura.model.Planta;

@RestController
@RequestMapping("/planta")
public class PlantaController {
    
    @Autowired
    public PlantaRepository repository;

    @GetMapping("/todos")
    public List<Planta> getTodosPlanta(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Planta getPlantaPeloId(@PathVariable Long id){
        Optional<Planta> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }

    @DeleteMapping
    public void deletarPlanta(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PostMapping
    public Planta criarPlanta(@RequestBody Planta planta) {
        return repository.save(planta);
    }

    @PutMapping
    public Planta atualizarPlanta(@RequestBody Planta planta) {
        return repository.save(planta);
    }
}
