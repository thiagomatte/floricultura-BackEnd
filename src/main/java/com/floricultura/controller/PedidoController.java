package com.floricultura.controller;

import java.util.List;
import java.util.Optional;

import com.floricultura.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.floricultura.model.Pedido;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    public PedidoRepository repository;

    @GetMapping("/todos")
    public List<Pedido> getTodosPedido(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Pedido getPedidoPeloId(@PathVariable Long id){
        Optional<Pedido> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }

    @DeleteMapping
    public void deletarPedido(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return repository.save(pedido);
    }

    @PutMapping
    public Pedido atualizarPedido(@RequestBody Pedido pedido) {
        return repository.save(pedido);
    }
}
