package com.floricultura.repository;

import com.floricultura.model.Planta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantaRepository extends JpaRepository<Planta, Long>{
    
}
