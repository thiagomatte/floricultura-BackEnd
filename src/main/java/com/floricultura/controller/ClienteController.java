package com.floricultura.controller;

import java.util.List;

import java.util.Optional;

import com.floricultura.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.floricultura.model.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    public ClienteRepository repository;

    @GetMapping("/todos")
    public List<Cliente> getTodosCliente(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente getClientePeloId(@PathVariable Long id){
        Optional<Cliente> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }

    @DeleteMapping
    public void deletarCliente(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @PutMapping
    public Cliente atualizarCliente(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }
}
