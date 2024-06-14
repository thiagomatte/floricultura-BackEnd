package com.floricultura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.floricultura.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}